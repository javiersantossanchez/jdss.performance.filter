package jdss.performance.filter.core.wrapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.ByteArrayInputStream;

public class ServletInputStreamImpl extends ServletInputStream {

    private static final Logger logger = LogManager.getLogger(ServletInputStreamImpl.class);

    private ByteArrayInputStream byteArrayInputStream;

    public ServletInputStreamImpl() { }

    public ServletInputStreamImpl(ByteArrayInputStream byteArrayInputStream) {
        if(byteArrayInputStream == null){
            throw new IllegalArgumentException("The Parameter [byteArrayInputStream] can not be null");
        }
        this.byteArrayInputStream = byteArrayInputStream;
    }

    @Override
    public int read () {
        try {
            return byteArrayInputStream.read();
        }catch (NullPointerException e){
            logger.error("The byteArrayInputStream object is null, There a problem with the request");
            throw e;
        }
    }

    @Override
    public boolean isFinished() {
        logger.error("The isFinished method is not implemented on {}", HttpServletRequestWrapperImpl.class.getCanonicalName());
        throw new RuntimeException("The isFinished method is not implemented on " + HttpServletRequestWrapperImpl.class.getCanonicalName());
    }

    @Override
    public boolean isReady() {
        logger.error("The isReady method is not implemented on %s", HttpServletRequestWrapperImpl.class.getCanonicalName());
        throw new RuntimeException("The isReady method is not implemented on " + HttpServletRequestWrapperImpl.class.getCanonicalName());
    }

    @Override
    public void setReadListener(ReadListener readListener) {
        logger.error("The setReadListener method is not implemented on %s", HttpServletRequestWrapperImpl.class.getCanonicalName());
        throw new RuntimeException("The setReadListener method is not implemented on " + HttpServletRequestWrapperImpl.class.getCanonicalName());
    }

    public void setByteArrayInputStream(ByteArrayInputStream byteArrayInputStream) {
        this.byteArrayInputStream = byteArrayInputStream;
    }
}
