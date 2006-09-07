package com.crackj2ee.bookstore.util;

import java.lang.reflect.Method;

import org.apache.commons.logging.LogFactory;

public class BeanUtil {

    /**
     * Copy all basic properties (boolean, int, String, Date) 
     * but ignore reference properties.
     * 
     * @param srcObj
     * @param destObj
     */
    public static void copyProperties(Object srcObj, Object destObj) {
        Class dest = destObj.getClass();
        Class src = srcObj.getClass();
        Method[] ms = dest.getMethods();
        for(int i=0; i<ms.length; i++) {
            String name = ms[i].getName();
            if(name.startsWith("set")) {
                Class[] cc = ms[i].getParameterTypes();
                if(cc.length==1) {
                    String type = cc[0].getName(); // parameter type
                    if(type.equals("java.lang.String")
                        || type.equals("int")
                        || type.equals("java.lang.Integer")
                        || type.equals("long")
                        || type.equals("java.lang.Long")
                        || type.equals("boolean")
                        || type.equals("java.lang.Boolean")
                        || type.equals("java.util.Date"))
                    {
                        try {
                            // get property name:
                            String getMethod = "g" + name.substring(1);
                            // call get method:
                            Method getM = src.getMethod(getMethod, new Class[0]);
                            Object ret = getM.invoke(srcObj, new Object[] {});
                            System.out.println("call: " + ms[i].getName() + ": " + getMethod);
                            ms[i].invoke(destObj, new Object[] {ret});
                        }
                        catch(Exception e) {
                            System.out.println("Invoke method " + ms[i].getName() + " failed: " + e.getMessage());
                        }
                    }
                }
            }
        }

    }
}
