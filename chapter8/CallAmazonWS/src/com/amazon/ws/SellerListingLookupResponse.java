/**
 * SellerListingLookupResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.amazon.ws;

public class SellerListingLookupResponse  implements java.io.Serializable {
    private com.amazon.ws.OperationRequest operationRequest;

    private com.amazon.ws.SellerListings[] sellerListings;

    public SellerListingLookupResponse() {
    }

    public SellerListingLookupResponse(
           com.amazon.ws.OperationRequest operationRequest,
           com.amazon.ws.SellerListings[] sellerListings) {
           this.operationRequest = operationRequest;
           this.sellerListings = sellerListings;
    }


    /**
     * Gets the operationRequest value for this SellerListingLookupResponse.
     * 
     * @return operationRequest
     */
    public com.amazon.ws.OperationRequest getOperationRequest() {
        return operationRequest;
    }


    /**
     * Sets the operationRequest value for this SellerListingLookupResponse.
     * 
     * @param operationRequest
     */
    public void setOperationRequest(com.amazon.ws.OperationRequest operationRequest) {
        this.operationRequest = operationRequest;
    }


    /**
     * Gets the sellerListings value for this SellerListingLookupResponse.
     * 
     * @return sellerListings
     */
    public com.amazon.ws.SellerListings[] getSellerListings() {
        return sellerListings;
    }


    /**
     * Sets the sellerListings value for this SellerListingLookupResponse.
     * 
     * @param sellerListings
     */
    public void setSellerListings(com.amazon.ws.SellerListings[] sellerListings) {
        this.sellerListings = sellerListings;
    }

    public com.amazon.ws.SellerListings getSellerListings(int i) {
        return this.sellerListings[i];
    }

    public void setSellerListings(int i, com.amazon.ws.SellerListings _value) {
        this.sellerListings[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SellerListingLookupResponse)) return false;
        SellerListingLookupResponse other = (SellerListingLookupResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.operationRequest==null && other.getOperationRequest()==null) || 
             (this.operationRequest!=null &&
              this.operationRequest.equals(other.getOperationRequest()))) &&
            ((this.sellerListings==null && other.getSellerListings()==null) || 
             (this.sellerListings!=null &&
              java.util.Arrays.equals(this.sellerListings, other.getSellerListings())));
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
        if (getOperationRequest() != null) {
            _hashCode += getOperationRequest().hashCode();
        }
        if (getSellerListings() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSellerListings());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSellerListings(), i);
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
        new org.apache.axis.description.TypeDesc(SellerListingLookupResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerListingLookupResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operationRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "OperationRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">OperationRequest"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sellerListings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SellerListings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SellerListings"));
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
