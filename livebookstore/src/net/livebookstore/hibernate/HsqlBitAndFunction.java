package net.livebookstore.hibernate;

import java.util.List;

import org.hibernate.QueryException;
import org.hibernate.engine.SessionFactoryImplementor;

/**
 * BitAnd function for HSQL.
 * 
 * @author Xuefeng
 */
public class HsqlBitAndFunction extends BitAndFunction {

    @Override
    public String render(List args, SessionFactoryImplementor factory) throws QueryException {
        return "BITAND(" + args.get(0).toString() + ", " + args.get(1).toString() + ")";
    }
}
