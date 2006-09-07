package com.crackj2ee.bookstore.web.cache;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * This class is used for wrapped response for cache.
 * 
 * @author Xuefeng
 */
public class CachedResponseWrapper extends HttpServletResponseWrapper {

    /**
     * Indicate that getOutputStream() or getWriter() is not called yet.
     */
    public static final int OUTPUT_NONE = 0;

    /**
     * Indicate that getWriter() is already called.
     */
    public static final int OUTPUT_WRITER = 1;

    /**
     * Indicate that getOutputStream() is already called.
     */
    public static final int OUTPUT_STREAM = 2;

    private int outputType = OUTPUT_NONE;

    private ServletOutputStream output = null;
    private PrintWriter writer = null;
    private ByteArrayOutputStream buffer = null;

    public CachedResponseWrapper(HttpServletResponse resp) throws IOException {
        super(resp);
        buffer = new ByteArrayOutputStream();
    }

    public PrintWriter getWriter() throws IOException {
        if(outputType==OUTPUT_STREAM)
            throw new IllegalStateException();
        else if(outputType==OUTPUT_WRITER)
            return writer;
        else {
            outputType = OUTPUT_WRITER;
            writer = new PrintWriter(new OutputStreamWriter(buffer, getCharacterEncoding()));
            return writer;
        }
    }

    public ServletOutputStream getOutputStream() throws IOException {
        if(outputType==OUTPUT_WRITER)
            throw new IllegalStateException();
        else if(outputType==OUTPUT_STREAM)
            return output;
        else {
            outputType = OUTPUT_STREAM;
            output = new WrappedOutputStream(buffer);
            return output;
        }
    }

    public void flushBuffer() throws IOException {
        if(outputType==OUTPUT_WRITER)
            writer.flush();
        if(outputType==OUTPUT_STREAM)
            output.flush();
    }

    public void reset() {
        outputType = OUTPUT_NONE;
        buffer.reset();
    }

    /**
     * Call this method to get cached response data.
     * @return byte array buffer.
     * @throws IOException
     */
    public byte[] getResponseData() throws IOException {
        flushBuffer();
        return buffer.toByteArray();
    }

    /**
     * This class is used to wrap a ServletOutputStream and 
     * store output stream in byte[] buffer.
     */
    class WrappedOutputStream extends ServletOutputStream {

        private ByteArrayOutputStream buffer;

        public WrappedOutputStream(ByteArrayOutputStream buffer) {
            this.buffer = buffer;
        }

        public void write(int b) throws IOException {
            buffer.write(b);
        }

        public byte[] toByteArray() {
            return buffer.toByteArray();
        }
    }

}
