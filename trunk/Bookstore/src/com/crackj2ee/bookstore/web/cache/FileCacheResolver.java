package com.crackj2ee.bookstore.web.cache;

import java.io.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.*;
import org.springframework.core.io.Resource;

import com.crackj2ee.bookstore.util.ZipUtil;

/**
 * Resolve file cache.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="fileCacheResolver"
 */
public class FileCacheResolver {

    private Log log = LogFactory.getLog(getClass());
    private String fileCacheRoot = null;

    /**
     * @spring.property value="/WEB-INF/static-files/"
     */
    public void setFileCacheRoot(Resource cacheRoot) {
        File dir = null;
        try {
            dir = cacheRoot.getFile();
        }
        catch (IOException e) {
            log.warn("Exception when setting file cache root.", e);
            return;
        }
        if(!dir.isDirectory() && !dir.mkdirs()) {
            log.warn("Invalid directory for cache: " + dir.getAbsolutePath());
            return;
        }
        String s = dir.getAbsolutePath();
        if(!s.endsWith("/") && !s.endsWith("\\"))
            fileCacheRoot = s + "/";
        else
            fileCacheRoot = s;
        log.info("File cache root is set to: " + fileCacheRoot);
    }

    /**
     * Try to load cached file to response. If no cached file, false will be returned.
     * 
     * @param response
     * @param key
     * @return True if cached file is loaded. Otherwise false will returned.
     */
    public boolean tryOutput(HttpServletResponse response, String key) {
        // detect if file is exist:
        File fs = key2File(key);
        if(!fs.isFile()) {
            // not found:
            return false;
        }
        response.setHeader("Content-Encoding", "gzip");
        // load file:
        OutputStream output = null;
        InputStream input = null;
        try {
            output = response.getOutputStream();
            input = new BufferedInputStream(new FileInputStream(fs));
            byte[] buffer = new byte[1024];
            int n = (-1);
            while((n=input.read(buffer))>0) {
                output.write(buffer, 0, n);
            }
            output.flush();
        }
        catch(IOException e) {
            log.warn("Load cached file failed.", e);
            try {
                response.sendError(500);
            }
            catch (IOException e1) {}
            return true;
        }
        finally {
            if(input!=null) {
                try {
                    input.close();
                }
                catch (IOException e) {}
            }
        }
        return true;
    }

    /**
     * Write rendered page data to file.
     */
    public void writeToFile(String key, byte[] data) {
        File fs = key2File(key);
        File dir = fs.getParentFile();
        if(!dir.isDirectory() && !dir.mkdirs())
            return;
        data = ZipUtil.gzip(data);
        OutputStream output = null;
        try {
            output = new BufferedOutputStream(new FileOutputStream(fs));
            output.write(data);
        }
        catch(IOException ioe) {
            log.warn("Failed to write file.", ioe);
        }
        finally {
            if(output!=null) {
                try {
                    output.close();
                }
                catch (IOException ioe) {}
            }
        }
    }

    /**
     * Remove static file.
     * 
     * @param key
     */
    public void removeFile(String key) {
        if(fileCacheRoot!=null) {
            File fs = key2File(key);
            if(fs.isFile())
                fs.delete();
        }
    }

    private File key2File(String key) {
        int hash = key.hashCode();
        int dir1 = (hash & 0xf0) >>> 4;
        int dir2 = hash & 0xf;
        return new File(fileCacheRoot + dir1 + "/" + dir2 + "/" + key + ".gzip");
    }

}
