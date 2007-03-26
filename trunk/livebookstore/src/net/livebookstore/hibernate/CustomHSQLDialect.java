package net.livebookstore.hibernate;

import org.hibernate.dialect.HSQLDialect;

/**
 * Custom HSQL dialect, to register bitand() function.
 * 
 * @author Xuefeng
 */
public class CustomHSQLDialect extends HSQLDialect {

    public CustomHSQLDialect() {
        registerFunction("bitand", new HsqlBitAndFunction());
    }
}
