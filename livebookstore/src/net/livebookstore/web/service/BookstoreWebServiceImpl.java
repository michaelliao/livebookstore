package net.livebookstore.web.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import net.livebookstore.business.SearchService;
import net.livebookstore.domain.Book;
import net.livebookstore.domain.Page;

/**
 * Implementation of BookstoreWebService.
 * 
 * @author Xuefeng
 */
@WebService(
    name="BookstoreWebService",
    serviceName="BookstoreWebService",
    targetNamespace="http://www.livebookstore.net/BookstoreWebService"
)
public class BookstoreWebServiceImpl implements BookstoreWebService {

    private SearchService searchService;
    private String imageRootUrl;
    private static final SearchResult EMPTY_RESULT = new SearchResult(new BookResult[0], 0, 0, 1, Page.DEFAULT_PAGE_SIZE);

    /**
     * Set book's image root url, such as "http://www.livebookstore.net/upload/"
     */
    public void setImageRootUrl(String imageRootUrl) {
        if(imageRootUrl==null || imageRootUrl.trim().equals(""))
            throw new IllegalArgumentException("Property imageRootUrl is null or empty.");
        imageRootUrl = imageRootUrl.trim();
        if(!imageRootUrl.startsWith("http://") && !imageRootUrl.startsWith("https://"))
            throw new IllegalArgumentException("Property imageRootUrl must start with \"http://\" or \"https://\"");
        if(!imageRootUrl.endsWith("/"))
            imageRootUrl = imageRootUrl + "/";
        this.imageRootUrl = imageRootUrl;
    }

    /**
     * Inject SearchService object. All search operations are wrapped in 
     * this interface.
     */
    public final void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    @WebMethod
    @WebResult
    public SearchResult search(@WebParam String keyword, int pageIndex) {
        System.out.println("Call WebService search: " + keyword);
        Page page = new Page(pageIndex);
        List<Book> books = searchService.search(keyword, page);
        if(page.getTotalCount()==0)
            return EMPTY_RESULT;
        BookResult[] results = new BookResult[books.size()];
        for(int i=0; i<results.length; i++) {
            // copy Book to BookResult:
            BookResult result = new BookResult();
            Book book = books.get(i);
            result.setId(book.getId());
            result.setName(book.getName());
            result.setOriginalName(book.getOriginalName());
            result.setAuthor(book.getAuthor());
            result.setLanguage(book.getLanguage());
            result.setPubDate(book.getPubDate());
            result.setImage(imageRootUrl + book.getImage());
            results[i] = result;
        }
        System.out.println("Return " + page.getTotalCount() + " books.");
        return new SearchResult(results,
                page.getTotalCount(),
                page.getPageCount(),
                page.getPageIndex(),
                page.getPageSize()
        );
    }

}
