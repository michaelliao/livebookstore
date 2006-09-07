package com.crackj2ee.bookstore.webservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BookstoreService extends Remote {

    static final String ACCESS_KEY = "1W562JHVKAFKDAG4JYG2";
    static final String REST_REQUEST = "http://webservices.amazon.com/onca/xml?Service=AWSECommerceService&Operation=ItemSearch&SearchIndex=Books";

    String hello(String username, String password) throws RemoteException;

}
