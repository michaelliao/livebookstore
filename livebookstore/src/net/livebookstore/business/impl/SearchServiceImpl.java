package net.livebookstore.business.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.livebookstore.domain.Book;
import net.livebookstore.domain.Page;

import org.apache.commons.logging.*;
import org.compass.annotations.config.CompassAnnotationsConfiguration;
import org.compass.core.Compass;
import org.compass.core.CompassHighlighter;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;
import org.compass.core.CompassTransaction;
import org.compass.core.converter.basic.DateConverter;
import org.springframework.core.io.Resource;

import net.livebookstore.business.SearchService;

/**
 * Implementation of SearchService.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="searchService" init-method="init" destroy-method="destroy"
 */
public class SearchServiceImpl implements SearchService {

    private final Log log = LogFactory.getLog(getClass());

    private String directory;
    private Compass compass;

    /**
     * Set compass index directory.
     * 
     * @spring.property value="/WEB-INF/compass"
     */
    public void setIndexDirectory(Resource resouce) {
        try {
            File dir = resouce.getFile();
            if(!dir.isDirectory()) {
                if(!dir.mkdirs()) {
                    throw new ExceptionInInitializerError("Could not create directory for compass: " + dir.getPath());
                }
            }
            directory = dir.getPath();
            log.info("Set compass directory: " + directory);
        }
        catch(IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Init compass.
     */
    public void init() {
        DateConverter dateConverter = new DateConverter();
        dateConverter.setFormat("yyyy-MM-dd");
        compass = new CompassAnnotationsConfiguration()
                .setConnection(directory)
                .addClass(Book.class)
                .setSetting("compass.engine.highlighter.default.formatter.simple.pre", "<span class=\"highlight\">")
                .setSetting("compass.engine.highlighter.default.formatter.simple.post", "</span>")
                .registerConverter("date", dateConverter)
                .buildCompass();
    }

    /**
     * Destroy compass.
     */
    public void destroy() {
        compass.close();
    }

    public void index(Book book) {
        log.info("Index book...");
        CompassSession session = null;
        CompassTransaction tx = null;
        try {
            session = compass.openSession();
            tx = session.beginTransaction();
            session.create(book);
            tx.commit();
            log.info("Done.");
        }
        catch(RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            if(session!=null)
                session.close();
        }
    }

    public void unindex(Book book) {
        log.info("Unindex book...");
        CompassSession session = null;
        CompassTransaction tx = null;
        try {
            session = compass.openSession();
            tx = session.beginTransaction();
            session.delete(book);
            tx.commit();
            log.info("Done.");
        }
        catch(RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            if(session!=null)
                session.close();
        }
    }

    public void reindex(Book book) {
        log.info("Reindex book...");
        CompassSession session = null;
        CompassTransaction tx = null;
        try {
            session = compass.openSession();
            tx = session.beginTransaction();
            session.delete(book);
            session.create(book);
            tx.commit();
            log.info("Done.");
        }
        catch(RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            if(session!=null)
                session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Book> search(String q, Page page) {
        if(q==null)
            return Collections.EMPTY_LIST;
        q = q.trim();
        if("".equals(q))
            return Collections.EMPTY_LIST;
        CompassSession session = null;
        CompassTransaction tx = null;
        try {
            session = compass.openSession();
            tx = session.beginTransaction();
            CompassHits hits = session.find(q);
            int count = hits.length();
            page.setTotalCount(count);
            if(count==0) {
                tx.commit();
                return Collections.EMPTY_LIST;
            }
            // fetch hits[start, end):
            int start = page.getFirstResult();
            int end = start + page.getPageSize();
            if(end > count)
                end = count;
            List<Book> results = new ArrayList<Book>(end-start);
            for(int i=start; i<end; i++) {
                Book book = (Book) hits.data(i);
                CompassHighlighter hl = hits.highlighter(i);
                String name = hl.fragment("name");
                String author = hl.fragment("author");
                if(name!=null)
                    book.setName(name);
                if(author!=null)
                    book.setAuthor(author);
                results.add(book);
            }
            tx.commit();
            return results;
        }
        catch(RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            if(session!=null)
                session.close();
        }
    }

}
