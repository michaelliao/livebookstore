package net.livebookstore.web.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 * Live Bookstore's WebService, perform a search.
 * 
 * @author Xuefeng
 */
public interface BookstoreWebService {

    /**
     * Do a search with specified keyword and page. The default page index 
     * should be 1.
     * 
     * @param keyword Keyword to search.
     * @param pageIndex Which page.
     * @return A SearchResult object that contains search informations.
     */
    @WebMethod
    @WebResult SearchResult search(@WebParam String keyword, int pageIndex);

}
