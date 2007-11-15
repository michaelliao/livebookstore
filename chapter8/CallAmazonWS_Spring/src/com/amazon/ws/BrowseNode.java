/**
 * BrowseNode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.amazon.ws;

public class BrowseNode  implements java.io.Serializable {
    private java.lang.String browseNodeId;

    private java.lang.String name;

    private com.amazon.ws.BrowseNode[] children;

    private com.amazon.ws.BrowseNode[] ancestors;

    public BrowseNode() {
    }

    public BrowseNode(
           java.lang.String browseNodeId,
           java.lang.String name,
           com.amazon.ws.BrowseNode[] children,
           com.amazon.ws.BrowseNode[] ancestors) {
           this.browseNodeId = browseNodeId;
           this.name = name;
           this.children = children;
           this.ancestors = ancestors;
    }


    /**
     * Gets the browseNodeId value for this BrowseNode.
     * 
     * @return browseNodeId
     */
    public java.lang.String getBrowseNodeId() {
        return browseNodeId;
    }


    /**
     * Sets the browseNodeId value for this BrowseNode.
     * 
     * @param browseNodeId
     */
    public void setBrowseNodeId(java.lang.String browseNodeId) {
        this.browseNodeId = browseNodeId;
    }


    /**
     * Gets the name value for this BrowseNode.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this BrowseNode.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the children value for this BrowseNode.
     * 
     * @return children
     */
    public com.amazon.ws.BrowseNode[] getChildren() {
        return children;
    }


    /**
     * Sets the children value for this BrowseNode.
     * 
     * @param children
     */
    public void setChildren(com.amazon.ws.BrowseNode[] children) {
        this.children = children;
    }


    /**
     * Gets the ancestors value for this BrowseNode.
     * 
     * @return ancestors
     */
    public com.amazon.ws.BrowseNode[] getAncestors() {
        return ancestors;
    }


    /**
     * Sets the ancestors value for this BrowseNode.
     * 
     * @param ancestors
     */
    public void setAncestors(com.amazon.ws.BrowseNode[] ancestors) {
        this.ancestors = ancestors;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BrowseNode)) return false;
        BrowseNode other = (BrowseNode) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.browseNodeId==null && other.getBrowseNodeId()==null) || 
             (this.browseNodeId!=null &&
              this.browseNodeId.equals(other.getBrowseNodeId()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.children==null && other.getChildren()==null) || 
             (this.children!=null &&
              java.util.Arrays.equals(this.children, other.getChildren()))) &&
            ((this.ancestors==null && other.getAncestors()==null) || 
             (this.ancestors!=null &&
              java.util.Arrays.equals(this.ancestors, other.getAncestors())));
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
        if (getBrowseNodeId() != null) {
            _hashCode += getBrowseNodeId().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getChildren() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getChildren());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getChildren(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAncestors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAncestors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAncestors(), i);
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
        new org.apache.axis.description.TypeDesc(BrowseNode.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">BrowseNode"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("browseNodeId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "BrowseNodeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("children");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Children"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "BrowseNode"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ancestors");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Ancestors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "BrowseNode"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
