package net.livebookstore.hibernate;

import java.util.List;

import org.hibernate.*;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.*;
import org.hibernate.type.Type;

/**
 * If don't have this 'bitand' function, Hibernate will report 
 * exception: unexpected char: '&' when using "a & b" SQL operation.
 * 
 * @author Xuefeng
 */
public class BitAndFunction implements SQLFunction {

    public Type getReturnType(Type type, Mapping mapping) {
        return Hibernate.INTEGER;
    }

    public boolean hasArguments() {
        return true;
    }

    public boolean hasParenthesesIfNoArguments() {
        return true;
    }

    public String render(List args, SessionFactoryImplementor factory) throws QueryException {
        if (args.size() != 2) {
            throw new IllegalArgumentException("BitAndFunction requires 2 arguments!"); 
        }
        return args.get(0).toString() + " & " + args.get(1).toString();
    }

}
