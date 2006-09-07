package com.crackj2ee.bookstore.domain;

/**
 * Page object is used to store and fetch page information.
 * 
 * @author xuefeng
 */
public class Page {

    public static final int DEFAULT_PAGE_SIZE = 10;

    private int pageIndex;
    private int pageSize;
    private int totalCount;
    private int pageCount;
    private String url;

    public Page(int pageIndex, int pageSize, String url) {
        // check:
        if(pageIndex<1)
            pageIndex = 1;
        if(pageSize<1)
            pageSize = 1;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        // if no query in url, we append a tem0 variable:
        if(url.indexOf('?')==(-1))
            this.url = url + "?tmp0=0";
        else
            this.url = url;
    }

    public Page(int pageIndex, String url) {
        this(pageIndex, DEFAULT_PAGE_SIZE, url);
    }

    public Page(int pageIndex) {
        this(pageIndex, DEFAULT_PAGE_SIZE, "listBooks.jspx");
    }

    public String getUrl() { return url; }

    public int getPageIndex() { return pageIndex; }

    public int getPageSize() { return pageSize; }

    public int getPageCount() { return pageCount; }

    public int getTotalCount() { return totalCount; }

    public int getFirstResult() { return (pageIndex-1)*pageSize; }

    public boolean getHasPrevious() { return pageIndex>1; }

    public boolean getHasNext() { return pageIndex<pageCount; }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        pageCount = totalCount / pageSize + (totalCount%pageSize==0 ? 0 : 1);
        // adjust pageIndex:
        if(totalCount==0) {
            if(pageIndex!=1)
                throw new IllegalArgumentException("PageIndex");
        }
        else {
            if(pageIndex>pageCount)
                throw new IllegalArgumentException("PageIndex");
        }
    }

    public boolean isEmpty() {
        return totalCount==0;
    }

}
