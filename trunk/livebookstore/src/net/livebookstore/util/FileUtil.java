package net.livebookstore.util;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.servlet.http.HttpServletResponse;

public class FileUtil {

    public static void removeFile(File file) {
        int maxTry = 3;
        while(maxTry>0) {
            maxTry--;
            if(file.isFile()) {
                if(file.delete())
                    return;
                else
                    continue;
            }
            else {
                return;
            }
        }
    }

    public static void readFile(File file, OutputStream output) throws IOException {
        FileInputStream input = null;
        FileChannel fc = null;
        try {
            input = new FileInputStream(file);
            fc = input.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            for(;;) {
                buffer.clear();
                int n = fc.read(buffer);
                if(n==(-1))
                    break;
                output.write(buffer.array(), 0, buffer.position());
            }
        }
        finally {
            if(fc!=null) {
                try {
                    fc.close();
                }
                catch(IOException e) {}
            }
            if(input!=null) {
                try {
                    input.close();
                }
                catch(IOException e) {}
            }
        }
    }

    public static void writeFile(File file, byte[] data) throws IOException {
        final int MAX_BUFFER_SIZE = 4096;
        FileOutputStream output = null;
        FileChannel fc = null;
        try {
            output = new FileOutputStream(file);
            fc = output.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(MAX_BUFFER_SIZE);
            int offset = 0;
            while(offset<data.length) {
                buffer.clear();
                int len = data.length - offset;
                if(len>MAX_BUFFER_SIZE)
                    len = MAX_BUFFER_SIZE;
                buffer.put(data, offset, len);
                offset += len;
                buffer.flip();
                fc.write(buffer);
            }
        }
        finally {
            if(fc!=null) {
                try {
                    fc.close();
                }
                catch(IOException e) {}
            }
            if(output!=null) {
                try {
                    output.close();
                }
                catch(IOException e) {}
            }
        }
    }

}
