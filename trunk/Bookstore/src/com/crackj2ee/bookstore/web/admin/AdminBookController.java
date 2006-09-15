package com.crackj2ee.bookstore.web.admin;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.crackj2ee.bookstore.domain.*;
import com.crackj2ee.bookstore.util.HttpUtil;
import com.crackj2ee.bookstore.util.ImageUtil;
import com.crackj2ee.bookstore.web.core.AbstractMvcController;
import com.crackj2ee.bookstore.web.core.AdminRequired;

/**
 * Manage books.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="adminBookController" name="/adminBook.jspx"
 */
public class AdminBookController extends AbstractMvcController implements AdminRequired {

    private String bookUploadDir;

    /**
     * Set book upload directory. Spring will auto map ralative web path 
     * "/upload/" to real local directory such as "C:/mybookstore/upload/".
     * 
     * @spring.property value="/upload/"
     */
    public void setBookUploadDir(Resource resource) {
        try {
            File f = resource.getFile();
            // check dir:
            if(!f.isDirectory()) {
                if(!f.mkdirs())
                    throw new IOException("Cannot create dirs: " + f.getPath());
            }
            String dir = f.getPath();
            // make sure dir is end with "/":
            if(!dir.endsWith("/") && !dir.endsWith("\\"))
                dir = dir + "/";
            log.info("Upload dir is set to: " + dir);
            bookUploadDir = dir;
        }
        catch (Exception e) {
            log.warn("Set book upload dir failed.", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public Map handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = HttpUtil.getString(request, "action", "list");
        int pageIndex = HttpUtil.getInt(request, "page", 1);
        int categoryId = HttpUtil.getInt(request, "categoryId", Category.ROOT_ID);
        Category root = businessService.queryRoot();
        Category current = (Category)businessService.query(Category.class, new Integer(categoryId));

        if(action.equals("add")) {
            // add new book:
            Book book = (Book)HttpUtil.createFormBean(request, Book.class);
            businessService.create(book);
            // upload image:
            File bookFile = new File(bookUploadDir + book.getImage());
            bookFile.getParentFile().mkdirs();
            MultipartHttpServletRequest multipart = (MultipartHttpServletRequest)request;
            InputStream input = multipart.getFile("file").getInputStream();
            ImageUtil.createPreviewImage(input, bookFile);
            input.close();
            searchService.index(book);
            log.info("Book \"" + book.getName() + "\" has been created.");
        }
        if(action.equals("delete")) {
            // delete a book:
            String[] ids = request.getParameterValues("id");
            for(int i=0; i<ids.length; i++) {
                int id = Integer.parseInt(ids[i]);
                Book book = (Book)businessService.query(Book.class, new Integer(id));
                businessService.delete(book);
                searchService.unindex(book);
                log.info("Book [id=" + book.getId() + "] has been deleted.");
            }
        }

        // query books:
        Page page = new Page(pageIndex, "adminBook.jspx?categoryId=" + categoryId);
        List books = businessService.queryBooks(current, page);
        // build model:
        Map map = new HashMap();
        map.put("root", root);
        map.put("categoryId", new Integer(categoryId));
        map.put("books", books);
        map.put("page", page);
        return map;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/adminBook.html";
    }

}
