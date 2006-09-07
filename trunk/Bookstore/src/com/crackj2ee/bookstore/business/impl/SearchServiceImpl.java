package com.crackj2ee.bookstore.business.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.*;
import org.compass.annotations.config.CompassAnnotationsConfiguration;
import org.compass.core.*;

import com.crackj2ee.bookstore.business.SearchService;
import com.crackj2ee.bookstore.domain.Book;
import com.crackj2ee.bookstore.domain.Page;

/**
 * Implementation of SearchService.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="searchService" destroy-method="shutdown"
 */
public class SearchServiceImpl implements SearchService {

    private Log log = LogFactory.getLog(getClass());

    private Compass compass;

    public SearchServiceImpl() {
        compass = new CompassAnnotationsConfiguration()
                .configure()
                .addClass(Book.class)
                .buildCompass();
    }

    public void shutdown() {
        compass.close();
    }

    public void index(Book book) {
        log.info("Index book...");
        CompassSession session = compass.openSession();
        CompassTransaction tx = session.beginTransaction();
        session.create(book);
        tx.commit();
        session.close();
        log.info("Done.");
    }

    public void unindex(Book book) {
        log.info("Unindex book...");
        CompassSession session = compass.openSession();
        CompassTransaction tx = session.beginTransaction();
        session.delete(book);
        tx.commit();
        session.close();
        log.info("Done.");
    }

    public void reindex(Book book) {
        log.info("Reindex book...");
        CompassSession session = compass.openSession();
        CompassTransaction tx = session.beginTransaction();
        session.delete(book);
        session.create(book);
        tx.commit();
        session.close();
        log.info("Done.");
    }

    @SuppressWarnings("unchecked")
    public List<Book> search(String q, Page page) {
        CompassSession session = compass.openSession();
        CompassTransaction tx = session.beginTransaction();
        try {
            CompassHits hits = session.find(q);
            int count = hits.length();
            page.setTotalCount(count);
            if(count==0)
                return Collections.EMPTY_LIST;
            // fetch hits[start, end):
            int start = page.getFirstResult();
            int end = start + page.getPageSize();
            if(end > count)
                end = count;
            List<Book> results = new ArrayList<Book>(end-start);
            for(int i=start; i<end; i++) {
                results.add((Book)hits.data(i));
            }
            return results;
        }
        finally {
            tx.commit();
            session.close();
        }
    }

}
