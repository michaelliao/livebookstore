package net.livebookstore.dao.jdbc;

import java.lang.reflect.Method;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.RowMapper;

/**
 * Mapping row to a domain object.
 * 
 * FIXME: Only getXxx() and setXxx() methods are handled, isXxx() and fields 
 * is not properly handled.
 * 
 * @author Xuefeng
 */
public class DomainRowMapper<T> implements RowMapper {

    private static final Class[] SUPPORTED_TYPE = {
        boolean.class, int.class, short.class, long.class, float.class, double.class,
        Boolean.class, Integer.class, Short.class, Long.class, Float.class, Double.class,
        String.class, Date.class
    };

    protected Log log = LogFactory.getLog(getClass());

    private Class<T> domainClass;
    private String tableName;
    private String[] getterNames;
    private String[] setterNames;
    private String[] columnNames;
    private Class[] columnTypes;

    public DomainRowMapper(Class<T> domainClass) {
        this.domainClass = domainClass;
        tableName = domainClass.getSimpleName();
        if(domainClass.isAnnotationPresent(Table.class)) {
            Table t = domainClass.getAnnotation(Table.class);
            String t_name = t.name();
            if(t_name!=null && !t_name.equals(""))
                tableName = t_name;
        }
        Method[] ms = domainClass.getDeclaredMethods();
        List<String> propertyNames = new ArrayList<String>();
        List<String> columnNames = new ArrayList<String>();
        List<Class> columnTypes = new ArrayList<Class>();
        String id = null;
        for(Method m : ms) {
            String getter = m.getName();
            if(getter.length()<=3 || ! getter.startsWith("get"))
                continue;
            if(m.isAnnotationPresent(Transient.class))
                continue;
            Class mapping = m.getReturnType();
            if(!isSupported(mapping)) {
                log.warn("Unable to map with type: " + mapping.getName());
                continue;
            }
            String propertyName = Character.toLowerCase(getter.charAt(3)) + getter.substring(4);
            String columnName = propertyName;
            // map this getter method to row column:
            if(m.isAnnotationPresent(Column.class)) {
                // detect column name:
                Column c = m.getAnnotation(Column.class);
                String name = c.name();
                if(name!=null && !name.equals(""))
                    columnName = name;
            }
            if(m.isAnnotationPresent(Id.class)) {
                id = propertyName;
                // add id-column at first:
                propertyNames.add(0, propertyName);
                columnNames.add(0, columnName);
                columnTypes.add(0, mapping);
                log.info("Mapping " + propertyName + " (" + m.getReturnType().getName() + ") to column [" + columnName + "] as Id.");
            }
            else {
                // add column-property mapping:
                propertyNames.add(propertyName);
                columnNames.add(columnName);
                columnTypes.add(mapping);
                log.info("Mapping " + propertyName + " (" + m.getReturnType().getName() + ")to column [" + columnName + "].");
            }
        }
        // now check:
        if(propertyNames.size()==0)
            throw new RuntimeException("No any getter method defined to map to columns.");
        if(id==null)
            log.warn("No @Id annotation defined to identify an Object.");
        // convert to array:
        this.columnNames = columnNames.toArray(new String[0]);
        this.columnTypes = columnTypes.toArray(new Class[0]);
        // get getter/setter names:
        this.getterNames = new String[this.columnNames.length];
        this.setterNames = new String[this.columnNames.length];
        for(int i=0; i<this.setterNames.length; i++) {
            String prop = propertyNames.get(i);
            this.getterNames[i] = "get" + Character.toUpperCase(prop.charAt(0)) + prop.substring(1);
            this.setterNames[i] = "set" + Character.toUpperCase(prop.charAt(0)) + prop.substring(1);
        }
    }

    /**
     * Get table name.
     */
    public String getTable() {
        return tableName;
    }

    /**
     * Get id column name.
     */
    public String getId() {
        return columnNames[0];
    }

    /**
     * Get all columns' name, the first one is id.
     */
    public String[] getColumns() {
        return columnNames;
    }

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Object object = null;
        try {
            object = domainClass.newInstance();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        // load each column to t:
        for(int i=0; i<setterNames.length; i++) {
            Class c = columnTypes[i];
            invokeSetter(object, setterNames[i], c, columnNames[i], rs);
        }
        return object;
    }

    private boolean isSupported(Class test) {
        for(Class c : SUPPORTED_TYPE) {
            if(c==test)
                return true;
        }
        return false;
    }

    public Object getValue(Object object, String columnName) {
        if(domainClass.isAssignableFrom(object.getClass())) {
            for(int i=0; i<columnNames.length; i++) {
                if(columnNames[i].equals(columnName)) {
                    return invokeGetter(object, getterNames[i]);
                }
            }
            throw new IllegalArgumentException("Cannot find column: " + columnName);
        }
        throw new ClassCastException("Object class is not " + domainClass.getName());
    }

    private static final Class[] EMPTY_PARAMETER = {};
    private static final Object[] EMPTY_OBJECT = {};

    private Object invokeGetter(Object object, String getterName) {
        try {
            Method m = object.getClass().getMethod(getterName, EMPTY_PARAMETER);
            return m.invoke(object, EMPTY_OBJECT);
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void invokeSetter(Object object, String setterName, Class columnType, String columnName, ResultSet rs) throws SQLException {
        Object value = null;
        if(columnType==String.class) {
            value = rs.getString(columnName);
        }
        else if(columnType==boolean.class || columnType==Boolean.class) {
            value = Boolean.valueOf(rs.getBoolean(columnName));
        }
        else if(columnType==int.class || columnType==Integer.class) {
            value = new Integer(rs.getInt(columnName));
        }
        else if(columnType==short.class || columnType==Short.class) {
            value = new Short(rs.getShort(columnName));
        }
        else if(columnType==long.class || columnType==Long.class) {
            value = new Long(rs.getLong(columnName));
        }
        else if(columnType==float.class || columnType==Float.class) {
            value = new Float(rs.getFloat(columnName));
        }
        else if(columnType==double.class || columnType==Double.class) {
            value = new Double(rs.getDouble(columnName));
        }
        else if(columnType==Date.class) {
            value = rs.getTimestamp(columnName);
        }
        else {
            // not a suitable type:
            return;
        }
        try {
            Method m = object.getClass().getDeclaredMethod(setterName, new Class[]{columnType});
            m.setAccessible(true);
            m.invoke(object, new Object[]{value});
            log.info("Invoke method " + setterName + "() with value: " + value);
        }
        catch (NoSuchMethodException e) {
            log.error("No " + setterName + "() method defined.");
            throw new Error(e);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
