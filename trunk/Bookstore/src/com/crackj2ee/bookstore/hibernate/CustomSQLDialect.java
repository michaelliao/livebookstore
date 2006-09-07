package com.crackj2ee.bookstore.hibernate;

import org.apache.commons.logging.LogFactory;
import org.hibernate.dialect.HSQLDialect;

public class CustomSQLDialect extends HSQLDialect {

    public CustomSQLDialect() {
        super();
        LogFactory.getLog(CustomSQLDialect.class).info("Register bitand function for bit-and operation. (e.g.: where a & b = :id)");
        registerFunction("bitand", new BitAndFunction());
    }

}
