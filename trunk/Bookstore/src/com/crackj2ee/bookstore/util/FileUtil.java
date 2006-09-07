package com.crackj2ee.bookstore.util;

import java.io.*;

public class FileUtil {

    public static void readFile(File file, OutputStream output) throws IOException {
        InputStream input = null;
        byte[] buffer = new byte[1024];
        int n = 0;
        try {
            input = new BufferedInputStream(new FileInputStream(file));
            while(n!=(-1)) {
                n = input.read(buffer);
                if(n>0)
                    output.write(buffer, 0, n);
            }
            output.flush();
        }
        finally {
            if(input!=null)
                input.close();
        }
    }

    public static void writeFile(File file, byte[] data) throws IOException {
        OutputStream output = null;
        try {
            output = new BufferedOutputStream(new FileOutputStream(file));
            output.write(data);
        }
        finally {
            if(output!=null)
                output.close();
        }
    }

}
