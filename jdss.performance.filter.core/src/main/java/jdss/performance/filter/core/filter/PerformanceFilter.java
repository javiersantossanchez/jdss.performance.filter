package jdss.performance.filter.core.filter;

import jdss.performance.filter.core.wrapper.HttpServletRequestWrapperImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;


/***
 * The Java Filter used to register the request information to be used for monitoring.
 * @author Javier Santos (javier.david.santos@gmail.com)
 * @version 1.0
 */
@WebFilter(filterName="performanceFilter",urlPatterns={"/*"})
public class PerformanceFilter implements  Filter  {

    private static final Logger logger = LogManager.getLogger(PerformanceFilter.class);

    public void init(FilterConfig config) {
    }

    /***
     * Main filter method.
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     *
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequestWrapperImpl requestWrapper = new HttpServletRequestWrapperImpl((HttpServletRequest) servletRequest);

        //The initial time.
        long startMilliSeconds = Calendar.getInstance().getTimeInMillis();

        filterChain.doFilter(requestWrapper, servletResponse);

        //The spend time
        Long spendTime = Calendar.getInstance().getTimeInMillis() - startMilliSeconds;

        logger.info("{} {} {} {} {} {}",requestWrapper.getRequestURI(),spendTime,((HttpServletResponse)servletResponse).getStatus(),requestWrapper.getRemoteAddr(),requestWrapper.getRemoteUser(),requestWrapper.getMethod());
    }
}
