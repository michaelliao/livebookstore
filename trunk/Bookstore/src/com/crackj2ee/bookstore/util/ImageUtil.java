package com.crackj2ee.bookstore.util;

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

import org.apache.commons.logging.*;

import com.crackj2ee.bookstore.exception.ApplicationException;

/**
 * Create preview image.
 * 
 * @author Xuefeng
 */
public class ImageUtil {

    private static final int IMAGE_WIDTH = 80;
    private static final int IMAGE_HEIGHT = 100;

    private static Log log = LogFactory.getLog(ImageUtil.class);

    /**
     * Create a preview image from an Image-InputStream, and close the InputStream.
     */
    public static void createPreviewImage(InputStream srcInput, File destFile) {
        if(srcInput==null)
            throw new ApplicationException("无效的文件内容。");
        BufferedImage bis = null;
        try {
            bis = ImageIO.read(srcInput);
            if(bis==null)
                throw new ApplicationException("无法加载图像");
        }
        catch(IOException ioe) {
            throw new ApplicationException("无法加载图像：" + ioe.getMessage());
        }
        try {
            BufferedImage bid = null;
            bid = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bid.createGraphics();
            g.drawImage(bis, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT, null);
            g.dispose();
            ImageIO.write(bid, "jpg", destFile);
        }
        catch(Exception e) {
            log.warn("Create preview image failed.", e);
        }
    }

}
