package example.chapter7;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @spring.bean name="/image.do"
 */
public class ImageController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 在内存中绘图:
        String code = String.valueOf((int)(Math.random() * 9000) + 1000);
        BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 100, 50);
        g.setColor(Color.RED);
        g.drawRect(0, 0, 99, 49);
        g.setColor(Color.BLACK);
        g.drawString(code, 20, 20);
        g.dispose();
        image.flush();
        // 设置ContentType:
        response.setContentType("image/jpeg");
        response.setHeader("Cache-Control", "no-cache");
        // 输出到ServletOutputStream:
        ServletOutputStream output = response.getOutputStream();
        ImageIO.write(image, "jpeg", output);
        output.close();
        return null;
    }

}
