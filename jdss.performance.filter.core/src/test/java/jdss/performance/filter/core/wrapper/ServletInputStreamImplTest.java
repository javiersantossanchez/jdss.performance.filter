package jdss.performance.filter.core.wrapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

/***
 *  Class with unit test for @{ServletInputStreamImpl}
 *  @author Javier Santos (javier.david.santos@gmail.com)
 *  @version 1.0
 */
public class ServletInputStreamImplTest {

    private final ServletInputStreamImpl servletInputStream = new ServletInputStreamImpl();

    @Test
    void callToNotImplementedMethodIsFinished(){
        Assertions.assertThrows(RuntimeException.class, () -> servletInputStream.isFinished());
    }

    @Test
    void callToNotImplementedMethodIsReady(){
        Assertions.assertThrows(RuntimeException.class, () -> servletInputStream.isReady());
    }

    @Test
    void callToNotImplementedMethodSetReadListener(){
        Assertions.assertThrows(RuntimeException.class, () -> servletInputStream.setReadListener(null));
    }


    @Test
    void createInstanceWithByteArrayInputStreamParameterAsNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ServletInputStreamImpl(null));
    }

    @Test
    void callReadMethodWithByteArrayInputStreamObjectNull(){
        Assertions.assertThrows(NullPointerException.class, () -> servletInputStream.read());
    }

    @Test
    void callReadMethodHappyPath(){
        String dummyRequest = "Dummy Request";

        ByteArrayInputStream bais = new ByteArrayInputStream(dummyRequest.getBytes());
        servletInputStream.setByteArrayInputStream(new ByteArrayInputStream(dummyRequest.getBytes()));
        int response = servletInputStream.read();

        int expected = bais.read();

        Assertions.assertEquals(expected,response);
    }

}
