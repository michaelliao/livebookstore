package net.livebookstore.hibernate;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * Define custom SQL dialect to register BitAnd function.
 * 
 * @author Xuefeng
 */
public class CustomMySQL5Dialect extends MySQL5Dialect {

    public CustomMySQL5Dialect() {
        registerFunction("bitand", new BitAndFunction());
    }

}
