package jdss.performance.filter.core.wrapper;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.*;

public class HttpServletRequestWrapperImplTest {


    private final HttpServletRequest servletRequest = mock(HttpServletRequest.class);
    private final HttpServletRequestWrapperImpl HttpServletRequestWrapperImpl = new HttpServletRequestWrapperImpl(servletRequest);


}
