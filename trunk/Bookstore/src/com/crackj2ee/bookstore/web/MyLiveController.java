package com.crackj2ee.bookstore.web;

import java.util.*;

import javax.servlet.http.*;

import com.crackj2ee.bookstore.web.core.*;

/**
 * Display orders in MyLive main page.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="myLiveController" name="/myLive.jspx"
 */
public class MyLiveController extends AbstractMvcController implements LoginRequired {

    public Map handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // list all orders:
        return null;
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) {
        return "/myLive.html";
    }

}
