/**
 * Items.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.amazon.ws;

public class Items  implements java.io.Serializable {
    private com.amazon.ws.Request request;

    private org.apache.axis.types.NonNegativeInteger totalResults;

    private org.apache.axis.types.NonNegativeInteger totalPages;

    private com.amazon.ws.SearchResultsMapSearchIndex[] searchResultsMap;

    private com.amazon.ws.Item[] item;

    public Items() {
    }

    public Items(
           com.amazon.ws.Request request,
           org.apache.axis.types.NonNegativeInteger totalResults,
           org.apache.axis.types.NonNegativeInteger totalPages,
           com.amazon.ws.SearchResultsMapSearchIndex[] searchResultsMap,
           com.amazon.ws.Item[] item) {
           this.request = request;
           this.totalResults = totalResults;
           this.totalPages = totalPages;
           this.searchResultsMap = searchResultsMap;
           this.item = item;
    }


    /**
     * Gets the request value for this Items.
     * 
     * @return request
     */
    public com.amazon.ws.Request getRequest() {
        return request;
    }


    /**
     * Sets the request value for this Items.
     * 
     * @param request
     */
    public void setRequest(com.amazon.ws.Request request) {
        this.request = request;
    }


    /**
     * Gets the totalResults value for this Items.
     * 
     * @return totalResults
     */
    public org.apache.axis.types.NonNegativeInteger getTotalResults() {
        return totalResults;
    }


    /**
     * Sets the totalResults value for this Items.
     * 
     * @param totalResults
     */
    public void setTotalResults(org.apache.axis.types.NonNegativeInteger totalResults) {
        this.totalResults = totalResults;
    }


    /**
     * Gets the totalPages value for this Items.
     * 
     * @return totalPages
     */
    public org.apache.axis.types.NonNegativeInteger getTotalPages() {
        return totalPages;
    }


    /**
     * Sets the totalPages value for this Items.
     * 
     * @param totalPages
     */
    public void setTotalPages(org.apache.axis.types.NonNegativeInteger totalPages) {
        this.totalPages = totalPages;
    }


    /**
     * Gets the searchResultsMap value for this Items.
     * 
     * @return searchResultsMap
     */
    public com.amazon.ws.SearchResultsMapSearchIndex[] getSearchResultsMap() {
        return searchResultsMap;
    }


    /**
     * Sets the searchResultsMap value for this Items.
     * 
     * @param searchResultsMap
     */
    public void setSearchResultsMap(com.amazon.ws.SearchResultsMapSearchIndex[] searchResultsMap) {
        this.searchResultsMap = searchResultsMap;
    }


    /**
     * Gets the item value for this Items.
     * 
     * @return item
     */
    public com.amazon.ws.Item[] getItem() {
        return item;
    }


    /**
     * Sets the item value for this Items.
     * 
     * @param item
     */
    public void setItem(com.amazon.ws.Item[] item) {
        this.item = item;
    }

    public com.amazon.ws.Item getItem(int i) {
        return this.item[i];
    }

    public void setItem(int i, com.amazon.ws.Item _value) {
        this.item[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Items)) return false;
        Items other = (Items) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.request==null && other.getRequest()==null) || 
             (this.request!=null &&
              this.request.equals(other.getRequest()))) &&
            ((this.totalResults==null && other.getTotalResults()==null) || 
             (this.totalResults!=null &&
              this.totalResults.equals(other.getTotalResults()))) &&
            ((this.totalPages==null && other.getTotalPages()==null) || 
             (this.totalPages!=null &&
              this.totalPages.equals(other.getTotalPages()))) &&
            ((this.searchResultsMap==null && other.getSearchResultsMap()==null) || 
             (this.searchResultsMap!=null &&
              java.util.Arrays.equals(this.searchResultsMap, other.getSearchResultsMap()))) &&
            ((this.item==null && other.getItem()==null) || 
             (this.item!=null &&
              java.util.Arrays.equals(this.item, other.getItem())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getRequest() != null) {
            _hashCode += getRequest().hashCode();
        }
        if (getTotalResults() != null) {
            _hashCode += getTotalResults().hashCode();
        }
        if (getTotalPages() != null) {
            _hashCode += getTotalPages().hashCode();
        }
        if (getSearchResultsMap() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSearchResultsMap());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSearchResultsMap(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getItem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItem(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Items.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Items"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("request");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Request"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Request"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalResults");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "TotalResults"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "nonNegativeInteger"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalPages");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "TotalPages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "nonNegativeInteger"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchResultsMap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SearchResultsMap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SearchResultsMap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Item"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Item"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
