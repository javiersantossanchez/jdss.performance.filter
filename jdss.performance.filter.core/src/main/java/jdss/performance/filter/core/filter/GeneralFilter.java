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

@WebFilter(filterName="performanceFilter",urlPatterns={"/*"})
public class GeneralFilter implements  Filter  {


    private static final Logger logger = LogManager.getLogger(GeneralFilter.class);

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequestWrapperImpl requestWrapper = new HttpServletRequestWrapperImpl((HttpServletRequest) servletRequest);
        //The initial time.
        long startMiliSeconds = Calendar.getInstance().getTimeInMillis();

        filterChain.doFilter(requestWrapper, servletResponse);

        //The spend time
        Long spendTime = Calendar.getInstance().getTimeInMillis() - startMiliSeconds;

        logger.info("Resource requested: {} ----- Time spend:  {}  -----  Status:  {}",requestWrapper.getRequestURI(),spendTime,((HttpServletResponse)servletResponse).getStatus());
    }
}
