package example.chapter7;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UploadController implements Controller {

    private Log log = LogFactory.getLog(getClass());

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipart = (MultipartHttpServletRequest)request;
            MultipartFile file = multipart.getFile("file");
            if(file==null || file.isEmpty()) {
                // 文件不存在:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return null;
            }
            String filename = file.getOriginalFilename();
            log.info("Upload file name: " + filename);
            // 获取文件扩展名:
            String ext = "";
            int pos;
            if((pos = filename.lastIndexOf('.'))!=(-1)) {
                ext = URLEncoder.encode(filename.substring(pos).trim(), "UTF-8");
            }
            InputStream input = null;
            OutputStream output = null;
            String uploadFile = request.getSession()
                    .getServletContext()
                    .getRealPath("/upload" + System.currentTimeMillis() + ext);
            try {
                input = file.getInputStream();
                output = new BufferedOutputStream(new FileOutputStream(uploadFile));
                byte[] buffer = new byte[1024];
                int n;
                while((n=input.read(buffer))!=(-1)) {
                    output.write(buffer, 0, n);
                }
            }
            finally {
                if(input!=null) {
                    try {
                        input.close();
                    }
                    catch(IOException ioe) {}
                }
                if(output!=null) {
                    try {
                        output.close();
                    }
                    catch(IOException ioe) {}
                }
            }
            Writer writer = response.getWriter();
            writer.write("File uploaded successfully!");
            writer.flush();
        }
        else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return null;
    }

}
