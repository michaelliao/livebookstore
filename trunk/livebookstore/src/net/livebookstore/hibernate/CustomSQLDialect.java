package net.livebookstore.hibernate;

import org.apache.commons.logging.LogFactory;
import org.hibernate.dialect.HSQLDialect;
import org.hibernate.dialect.MySQL5Dialect;

/**
 * Define custom SQL dialect to register BitAnd function.
 * 
 * @author Xuefeng
 */
public class CustomSQLDialect extends MySQL5Dialect {

    public CustomSQLDialect() {
        super();
        LogFactory.getLog(CustomSQLDialect.class).info("Register bitand function for bit-and operation. (e.g.: where a & b = :c)");
        if(HSQLDialect.class.isAssignableFrom(getClass()))
            registerFunction("bitand", new HsqlBitAndFunction());
        else
            registerFunction("bitand", new BitAndFunction());
    }

}
