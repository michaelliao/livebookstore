/**
 * VariationSummary.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.amazon.ws;

public class VariationSummary  implements java.io.Serializable {
    private com.amazon.ws.Price lowestPrice;

    private com.amazon.ws.Price highestPrice;

    private com.amazon.ws.Price lowestSalePrice;

    private com.amazon.ws.Price highestSalePrice;

    private java.lang.String singleMerchantId;

    public VariationSummary() {
    }

    public VariationSummary(
           com.amazon.ws.Price lowestPrice,
           com.amazon.ws.Price highestPrice,
           com.amazon.ws.Price lowestSalePrice,
           com.amazon.ws.Price highestSalePrice,
           java.lang.String singleMerchantId) {
           this.lowestPrice = lowestPrice;
           this.highestPrice = highestPrice;
           this.lowestSalePrice = lowestSalePrice;
           this.highestSalePrice = highestSalePrice;
           this.singleMerchantId = singleMerchantId;
    }


    /**
     * Gets the lowestPrice value for this VariationSummary.
     * 
     * @return lowestPrice
     */
    public com.amazon.ws.Price getLowestPrice() {
        return lowestPrice;
    }


    /**
     * Sets the lowestPrice value for this VariationSummary.
     * 
     * @param lowestPrice
     */
    public void setLowestPrice(com.amazon.ws.Price lowestPrice) {
        this.lowestPrice = lowestPrice;
    }


    /**
     * Gets the highestPrice value for this VariationSummary.
     * 
     * @return highestPrice
     */
    public com.amazon.ws.Price getHighestPrice() {
        return highestPrice;
    }


    /**
     * Sets the highestPrice value for this VariationSummary.
     * 
     * @param highestPrice
     */
    public void setHighestPrice(com.amazon.ws.Price highestPrice) {
        this.highestPrice = highestPrice;
    }


    /**
     * Gets the lowestSalePrice value for this VariationSummary.
     * 
     * @return lowestSalePrice
     */
    public com.amazon.ws.Price getLowestSalePrice() {
        return lowestSalePrice;
    }


    /**
     * Sets the lowestSalePrice value for this VariationSummary.
     * 
     * @param lowestSalePrice
     */
    public void setLowestSalePrice(com.amazon.ws.Price lowestSalePrice) {
        this.lowestSalePrice = lowestSalePrice;
    }


    /**
     * Gets the highestSalePrice value for this VariationSummary.
     * 
     * @return highestSalePrice
     */
    public com.amazon.ws.Price getHighestSalePrice() {
        return highestSalePrice;
    }


    /**
     * Sets the highestSalePrice value for this VariationSummary.
     * 
     * @param highestSalePrice
     */
    public void setHighestSalePrice(com.amazon.ws.Price highestSalePrice) {
        this.highestSalePrice = highestSalePrice;
    }


    /**
     * Gets the singleMerchantId value for this VariationSummary.
     * 
     * @return singleMerchantId
     */
    public java.lang.String getSingleMerchantId() {
        return singleMerchantId;
    }


    /**
     * Sets the singleMerchantId value for this VariationSummary.
     * 
     * @param singleMerchantId
     */
    public void setSingleMerchantId(java.lang.String singleMerchantId) {
        this.singleMerchantId = singleMerchantId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VariationSummary)) return false;
        VariationSummary other = (VariationSummary) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.lowestPrice==null && other.getLowestPrice()==null) || 
             (this.lowestPrice!=null &&
              this.lowestPrice.equals(other.getLowestPrice()))) &&
            ((this.highestPrice==null && other.getHighestPrice()==null) || 
             (this.highestPrice!=null &&
              this.highestPrice.equals(other.getHighestPrice()))) &&
            ((this.lowestSalePrice==null && other.getLowestSalePrice()==null) || 
             (this.lowestSalePrice!=null &&
              this.lowestSalePrice.equals(other.getLowestSalePrice()))) &&
            ((this.highestSalePrice==null && other.getHighestSalePrice()==null) || 
             (this.highestSalePrice!=null &&
              this.highestSalePrice.equals(other.getHighestSalePrice()))) &&
            ((this.singleMerchantId==null && other.getSingleMerchantId()==null) || 
             (this.singleMerchantId!=null &&
              this.singleMerchantId.equals(other.getSingleMerchantId())));
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
        if (getLowestPrice() != null) {
            _hashCode += getLowestPrice().hashCode();
        }
        if (getHighestPrice() != null) {
            _hashCode += getHighestPrice().hashCode();
        }
        if (getLowestSalePrice() != null) {
            _hashCode += getLowestSalePrice().hashCode();
        }
        if (getHighestSalePrice() != null) {
            _hashCode += getHighestSalePrice().hashCode();
        }
        if (getSingleMerchantId() != null) {
            _hashCode += getSingleMerchantId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VariationSummary.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">VariationSummary"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lowestPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "LowestPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Price"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("highestPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "HighestPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Price"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lowestSalePrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "LowestSalePrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Price"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("highestSalePrice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "HighestSalePrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Price"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("singleMerchantId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SingleMerchantId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
