/**
 * OperationRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.amazon.ws;

public class OperationRequest  implements java.io.Serializable {
    private com.amazon.ws.HTTPHeadersHeader[] HTTPHeaders;

    private java.lang.String requestId;

    private com.amazon.ws.ArgumentsArgument[] arguments;

    private com.amazon.ws.ErrorsError[] errors;

    private java.lang.Float requestProcessingTime;

    public OperationRequest() {
    }

    public OperationRequest(
           com.amazon.ws.HTTPHeadersHeader[] HTTPHeaders,
           java.lang.String requestId,
           com.amazon.ws.ArgumentsArgument[] arguments,
           com.amazon.ws.ErrorsError[] errors,
           java.lang.Float requestProcessingTime) {
           this.HTTPHeaders = HTTPHeaders;
           this.requestId = requestId;
           this.arguments = arguments;
           this.errors = errors;
           this.requestProcessingTime = requestProcessingTime;
    }


    /**
     * Gets the HTTPHeaders value for this OperationRequest.
     * 
     * @return HTTPHeaders
     */
    public com.amazon.ws.HTTPHeadersHeader[] getHTTPHeaders() {
        return HTTPHeaders;
    }


    /**
     * Sets the HTTPHeaders value for this OperationRequest.
     * 
     * @param HTTPHeaders
     */
    public void setHTTPHeaders(com.amazon.ws.HTTPHeadersHeader[] HTTPHeaders) {
        this.HTTPHeaders = HTTPHeaders;
    }


    /**
     * Gets the requestId value for this OperationRequest.
     * 
     * @return requestId
     */
    public java.lang.String getRequestId() {
        return requestId;
    }


    /**
     * Sets the requestId value for this OperationRequest.
     * 
     * @param requestId
     */
    public void setRequestId(java.lang.String requestId) {
        this.requestId = requestId;
    }


    /**
     * Gets the arguments value for this OperationRequest.
     * 
     * @return arguments
     */
    public com.amazon.ws.ArgumentsArgument[] getArguments() {
        return arguments;
    }


    /**
     * Sets the arguments value for this OperationRequest.
     * 
     * @param arguments
     */
    public void setArguments(com.amazon.ws.ArgumentsArgument[] arguments) {
        this.arguments = arguments;
    }


    /**
     * Gets the errors value for this OperationRequest.
     * 
     * @return errors
     */
    public com.amazon.ws.ErrorsError[] getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this OperationRequest.
     * 
     * @param errors
     */
    public void setErrors(com.amazon.ws.ErrorsError[] errors) {
        this.errors = errors;
    }


    /**
     * Gets the requestProcessingTime value for this OperationRequest.
     * 
     * @return requestProcessingTime
     */
    public java.lang.Float getRequestProcessingTime() {
        return requestProcessingTime;
    }


    /**
     * Sets the requestProcessingTime value for this OperationRequest.
     * 
     * @param requestProcessingTime
     */
    public void setRequestProcessingTime(java.lang.Float requestProcessingTime) {
        this.requestProcessingTime = requestProcessingTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OperationRequest)) return false;
        OperationRequest other = (OperationRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.HTTPHeaders==null && other.getHTTPHeaders()==null) || 
             (this.HTTPHeaders!=null &&
              java.util.Arrays.equals(this.HTTPHeaders, other.getHTTPHeaders()))) &&
            ((this.requestId==null && other.getRequestId()==null) || 
             (this.requestId!=null &&
              this.requestId.equals(other.getRequestId()))) &&
            ((this.arguments==null && other.getArguments()==null) || 
             (this.arguments!=null &&
              java.util.Arrays.equals(this.arguments, other.getArguments()))) &&
            ((this.errors==null && other.getErrors()==null) || 
             (this.errors!=null &&
              java.util.Arrays.equals(this.errors, other.getErrors()))) &&
            ((this.requestProcessingTime==null && other.getRequestProcessingTime()==null) || 
             (this.requestProcessingTime!=null &&
              this.requestProcessingTime.equals(other.getRequestProcessingTime())));
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
        if (getHTTPHeaders() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHTTPHeaders());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHTTPHeaders(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRequestId() != null) {
            _hashCode += getRequestId().hashCode();
        }
        if (getArguments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArguments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArguments(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getErrors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getErrors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getErrors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRequestProcessingTime() != null) {
            _hashCode += getRequestProcessingTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OperationRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">OperationRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("HTTPHeaders");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "HTTPHeaders"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">HTTPHeaders"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "RequestId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arguments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Arguments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Arguments"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errors");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Errors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Errors"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestProcessingTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "RequestProcessingTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
