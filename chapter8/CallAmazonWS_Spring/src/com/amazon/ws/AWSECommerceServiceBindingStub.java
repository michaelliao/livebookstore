/**
 * AWSECommerceServiceBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.amazon.ws;

public class AWSECommerceServiceBindingStub extends org.apache.axis.client.Stub implements com.amazon.ws.AWSECommerceServicePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[19];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Help");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Help"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Help"), com.amazon.ws.Help.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">HelpResponse"));
        oper.setReturnClass(com.amazon.ws.HelpResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "HelpResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ItemSearch");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ItemSearch"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ItemSearch"), com.amazon.ws.ItemSearch.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ItemSearchResponse"));
        oper.setReturnClass(com.amazon.ws.ItemSearchResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ItemSearchResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ItemLookup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ItemLookup"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ItemLookup"), com.amazon.ws.ItemLookup.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ItemLookupResponse"));
        oper.setReturnClass(com.amazon.ws.ItemLookupResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ItemLookupResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("BrowseNodeLookup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "BrowseNodeLookup"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">BrowseNodeLookup"), com.amazon.ws.BrowseNodeLookup.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">BrowseNodeLookupResponse"));
        oper.setReturnClass(com.amazon.ws.BrowseNodeLookupResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "BrowseNodeLookupResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListSearch");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ListSearch"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ListSearch"), com.amazon.ws.ListSearch.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ListSearchResponse"));
        oper.setReturnClass(com.amazon.ws.ListSearchResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ListSearchResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListLookup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ListLookup"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ListLookup"), com.amazon.ws.ListLookup.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ListLookupResponse"));
        oper.setReturnClass(com.amazon.ws.ListLookupResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ListLookupResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CustomerContentSearch");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CustomerContentSearch"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CustomerContentSearch"), com.amazon.ws.CustomerContentSearch.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CustomerContentSearchResponse"));
        oper.setReturnClass(com.amazon.ws.CustomerContentSearchResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CustomerContentSearchResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CustomerContentLookup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CustomerContentLookup"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CustomerContentLookup"), com.amazon.ws.CustomerContentLookup.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CustomerContentLookupResponse"));
        oper.setReturnClass(com.amazon.ws.CustomerContentLookupResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CustomerContentLookupResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SimilarityLookup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SimilarityLookup"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SimilarityLookup"), com.amazon.ws.SimilarityLookup.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SimilarityLookupResponse"));
        oper.setReturnClass(com.amazon.ws.SimilarityLookupResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SimilarityLookupResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SellerLookup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SellerLookup"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerLookup"), com.amazon.ws.SellerLookup.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerLookupResponse"));
        oper.setReturnClass(com.amazon.ws.SellerLookupResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SellerLookupResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CartGet");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartGet"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartGet"), com.amazon.ws.CartGet.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartGetResponse"));
        oper.setReturnClass(com.amazon.ws.CartGetResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartGetResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CartCreate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartCreate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartCreate"), com.amazon.ws.CartCreate.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartCreateResponse"));
        oper.setReturnClass(com.amazon.ws.CartCreateResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartCreateResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CartAdd");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartAdd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartAdd"), com.amazon.ws.CartAdd.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartAddResponse"));
        oper.setReturnClass(com.amazon.ws.CartAddResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartAddResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CartModify");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartModify"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartModify"), com.amazon.ws.CartModify.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartModifyResponse"));
        oper.setReturnClass(com.amazon.ws.CartModifyResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartModifyResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CartClear");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartClear"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartClear"), com.amazon.ws.CartClear.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartClearResponse"));
        oper.setReturnClass(com.amazon.ws.CartClearResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartClearResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("TransactionLookup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "TransactionLookup"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">TransactionLookup"), com.amazon.ws.TransactionLookup.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">TransactionLookupResponse"));
        oper.setReturnClass(com.amazon.ws.TransactionLookupResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "TransactionLookupResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SellerListingSearch");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SellerListingSearch"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerListingSearch"), com.amazon.ws.SellerListingSearch.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerListingSearchResponse"));
        oper.setReturnClass(com.amazon.ws.SellerListingSearchResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SellerListingSearchResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SellerListingLookup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SellerListingLookup"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerListingLookup"), com.amazon.ws.SellerListingLookup.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerListingLookupResponse"));
        oper.setReturnClass(com.amazon.ws.SellerListingLookupResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SellerListingLookupResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("MultiOperation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "MultiOperation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">MultiOperation"), com.amazon.ws.MultiOperation.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">MultiOperationResponse"));
        oper.setReturnClass(com.amazon.ws.MultiOperationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "MultiOperationResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

    }

    public AWSECommerceServiceBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public AWSECommerceServiceBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public AWSECommerceServiceBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        addBindings0();
        addBindings1();
    }

    private void addBindings0() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>>>>Transaction>Shipments>Shipment>Packages>Package");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.TransactionShipmentsShipmentPackagesPackage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>>>Transaction>Shipments>Shipment>Packages");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.TransactionShipmentsShipmentPackagesPackage[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>>>>Transaction>Shipments>Shipment>Packages>Package");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Package");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>>>Transaction>Shipments>Shipment>ShipmentItems");
            cachedSerQNames.add(qName);
            cls = java.lang.Object[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "TransactionItemId");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>>CartModifyRequest>Items>Item>Action");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartModifyRequestItemsItemAction.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>>ItemAttributes>Languages>Language");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ItemAttributesLanguagesLanguage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>>Tracks>Disc>Track");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.TracksDiscTrack.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>>Transaction>Shipments>Shipment");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.TransactionShipmentsShipment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>Accessories>Accessory");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.AccessoriesAccessory.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>Arguments>Argument");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ArgumentsArgument.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>BrowseNode>Ancestors");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.BrowseNode[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "BrowseNode");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>BrowseNode>Children");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.BrowseNode[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "BrowseNode");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>CartAddRequest>Items>Item");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartAddRequestItemsItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>CartCreateRequest>Items>Item");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartCreateRequestItemsItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>CartModifyRequest>Items>Item");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartModifyRequestItemsItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>Customer>Location");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CustomerLocation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>Errors>Error");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ErrorsError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>HTTPHeaders>Header");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.HTTPHeadersHeader.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>ItemAttributes>Creator");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ItemAttributesCreator.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>ItemAttributes>ItemDimensions");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ItemAttributesItemDimensions.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>ItemAttributes>Languages");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ItemAttributesLanguagesLanguage[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>>ItemAttributes>Languages>Language");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Language");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>ItemAttributes>PackageDimensions");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ItemAttributesPackageDimensions.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>List>ListType");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ListListType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>ListmaniaLists>ListmaniaList");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ListmaniaListsListmaniaList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>OperationInformation>AvailableParameters");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Parameter");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>OperationInformation>AvailableResponseGroups");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ResponseGroup");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>OperationInformation>DefaultResponseGroups");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ResponseGroup");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>OperationInformation>RequiredParameters");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Parameter");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>ResponseGroupInformation>Elements");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Element");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>ResponseGroupInformation>ValidOperations");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Operation");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>SearchInside>Excerpt");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SearchInsideExcerpt.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>SearchResultsMap>SearchIndex");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SearchResultsMapSearchIndex.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>Seller>Location");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerLocation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>SellerFeedback>Feedback");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerFeedbackFeedback.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>SimilarProducts>SimilarProduct");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SimilarProductsSimilarProduct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>Tracks>Disc");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.TracksDiscTrack[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>>Tracks>Disc>Track");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Track");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>Transaction>Shipments");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.TransactionShipmentsShipment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>>Transaction>Shipments>Shipment");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Shipment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>Transaction>Totals");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.TransactionTotals.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>Transaction>TransactionItems");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.TransactionItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "TransactionItem");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>TransactionItem>ChildTransactionItems");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.TransactionItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "TransactionItem");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Accessories");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.AccessoriesAccessory[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>Accessories>Accessory");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Accessory");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Arguments");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ArgumentsArgument[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>Arguments>Argument");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Argument");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">AudienceRating");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.AudienceRating.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">BrowseNode");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.BrowseNode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">BrowseNodeLookup");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.BrowseNodeLookup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">BrowseNodeLookupResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.BrowseNodeLookupResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">BrowseNodes");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.BrowseNodes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Cart");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Cart.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartAdd");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartAdd.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartAddRequest>Items");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartAddRequestItemsItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>CartAddRequest>Items>Item");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartAddResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartAddResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartClear");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartClear.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartClearResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartClearResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartCreate");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartCreate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartCreateRequest>Items");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartCreateRequestItemsItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>CartCreateRequest>Items>Item");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartCreateResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartCreateResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartGet");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartGet.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartGetResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartGetResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartItems");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartItems.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartModify");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartModify.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartModifyRequest>Items");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartModifyRequestItemsItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>CartModifyRequest>Items>Item");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CartModifyResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartModifyResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Condition");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Condition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Customer");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Customer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CustomerContentLookup");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CustomerContentLookup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CustomerContentLookupResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CustomerContentLookupResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CustomerContentSearch");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CustomerContentSearch.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CustomerContentSearchResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CustomerContentSearchResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CustomerReviews");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CustomerReviews.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Customers");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Customers.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">DeliveryMethod");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.DeliveryMethod.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">EditorialReview");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.EditorialReview.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">EditorialReviews");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.EditorialReview[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "EditorialReview");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Errors");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ErrorsError[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>Errors>Error");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Error");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Help");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Help.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">HelpRequest>HelpType");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.HelpRequestHelpType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">HelpResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.HelpResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">HTTPHeaders");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.HTTPHeadersHeader[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>HTTPHeaders>Header");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Header");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Information");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Information.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Item");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Item.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ItemAttributes");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ItemAttributes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ItemLookup");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ItemLookup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ItemLookupRequest>IdType");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ItemLookupRequestIdType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ItemLookupResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ItemLookupResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Items");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Items.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ItemSearch");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ItemSearch.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ItemSearchResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ItemSearchResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">List");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.List.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ListItem");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ListItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ListLookup");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ListLookup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ListLookupRequest>ListType");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ListLookupRequestListType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ListLookupResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ListLookupResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ListmaniaLists");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ListmaniaListsListmaniaList[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>ListmaniaLists>ListmaniaList");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ListmaniaList");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Lists");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Lists.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ListSearch");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ListSearch.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ListSearchRequest>ListType");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ListSearchRequestListType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ListSearchResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ListSearchResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Merchant");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Merchant.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">MultiOperation");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.MultiOperation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">MultiOperationResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.MultiOperationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Offer");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Offer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings1() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">OfferAttributes");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.OfferAttributes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">OfferListing");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.OfferListing.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Offers");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Offers.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">OfferSummary");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.OfferSummary.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">OperationInformation");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.OperationInformation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">OperationRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.OperationRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">PromotionalTag");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.PromotionalTag.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Request");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Request.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ResponseGroupInformation");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ResponseGroupInformation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Review");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Review.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SavedForLaterItems");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SavedForLaterItems.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SearchInside");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SearchInside.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SearchResultsMap");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SearchResultsMapSearchIndex[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>SearchResultsMap>SearchIndex");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SearchIndex");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Seller");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Seller.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerFeedback");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerFeedbackFeedback[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>SellerFeedback>Feedback");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Feedback");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerListing");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerListing.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerListingLookup");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerListingLookup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerListingLookupRequest>IdType");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerListingLookupRequestIdType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerListingLookupResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerListingLookupResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerListings");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerListings.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerListingSearch");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerListingSearch.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerListingSearchRequest>OfferStatus");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerListingSearchRequestOfferStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerListingSearchRequest>ShipOption");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerListingSearchRequestShipOption.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerListingSearchResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerListingSearchResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerLookup");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerLookup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SellerLookupResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerLookupResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Sellers");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Sellers.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SimilarityLookup");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SimilarityLookup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SimilarityLookupRequest>SimilarityType");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SimilarityLookupRequestSimilarityType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SimilarityLookupResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SimilarityLookupResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SimilarProducts");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SimilarProductsSimilarProduct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>SimilarProducts>SimilarProduct");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SimilarProduct");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Tracks");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.TracksDiscTrack[][].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">>Tracks>Disc");
            qName2 = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Disc");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Transaction");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Transaction.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">TransactionItem");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.TransactionItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">TransactionLookup");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.TransactionLookup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">TransactionLookupResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.TransactionLookupResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Transactions");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Transactions.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Variations");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Variations.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">VariationSummary");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.VariationSummary.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Address");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Address.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "BrowseNodeLookupRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.BrowseNodeLookupRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartAddRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartAddRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartClearRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartClearRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartCreateRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartCreateRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartGetRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartGetRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartItem");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CartModifyRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CartModifyRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CustomerContentLookupRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CustomerContentLookupRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CustomerContentSearchRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.CustomerContentSearchRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "DecimalWithUnits");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.DecimalWithUnits.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "HelpRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.HelpRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Image");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Image.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ItemLookupRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ItemLookupRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ItemSearchRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ItemSearchRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ListLookupRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ListLookupRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ListSearchRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.ListSearchRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "NonNegativeIntegerWithUnits");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.NonNegativeIntegerWithUnits.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Price");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.Price.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SellerListingLookupRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerListingLookupRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SellerListingSearchRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerListingSearchRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SellerLookupRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SellerLookupRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SimilarityLookupRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.SimilarityLookupRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "StringWithUnits");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.StringWithUnits.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "TransactionLookupRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.ws.TransactionLookupRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.amazon.ws.HelpResponse help(com.amazon.ws.Help body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Help"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.HelpResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.HelpResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.HelpResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.ItemSearchResponse itemSearch(com.amazon.ws.ItemSearch body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ItemSearch"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.ItemSearchResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.ItemSearchResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.ItemSearchResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.ItemLookupResponse itemLookup(com.amazon.ws.ItemLookup body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ItemLookup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.ItemLookupResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.ItemLookupResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.ItemLookupResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.BrowseNodeLookupResponse browseNodeLookup(com.amazon.ws.BrowseNodeLookup body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "BrowseNodeLookup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.BrowseNodeLookupResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.BrowseNodeLookupResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.BrowseNodeLookupResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.ListSearchResponse listSearch(com.amazon.ws.ListSearch body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ListSearch"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.ListSearchResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.ListSearchResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.ListSearchResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.ListLookupResponse listLookup(com.amazon.ws.ListLookup body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ListLookup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.ListLookupResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.ListLookupResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.ListLookupResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.CustomerContentSearchResponse customerContentSearch(com.amazon.ws.CustomerContentSearch body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CustomerContentSearch"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.CustomerContentSearchResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.CustomerContentSearchResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.CustomerContentSearchResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.CustomerContentLookupResponse customerContentLookup(com.amazon.ws.CustomerContentLookup body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CustomerContentLookup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.CustomerContentLookupResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.CustomerContentLookupResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.CustomerContentLookupResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.SimilarityLookupResponse similarityLookup(com.amazon.ws.SimilarityLookup body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SimilarityLookup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.SimilarityLookupResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.SimilarityLookupResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.SimilarityLookupResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.SellerLookupResponse sellerLookup(com.amazon.ws.SellerLookup body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SellerLookup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.SellerLookupResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.SellerLookupResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.SellerLookupResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.CartGetResponse cartGet(com.amazon.ws.CartGet body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CartGet"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.CartGetResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.CartGetResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.CartGetResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.CartCreateResponse cartCreate(com.amazon.ws.CartCreate body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CartCreate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.CartCreateResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.CartCreateResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.CartCreateResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.CartAddResponse cartAdd(com.amazon.ws.CartAdd body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CartAdd"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.CartAddResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.CartAddResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.CartAddResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.CartModifyResponse cartModify(com.amazon.ws.CartModify body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CartModify"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.CartModifyResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.CartModifyResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.CartModifyResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.CartClearResponse cartClear(com.amazon.ws.CartClear body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CartClear"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.CartClearResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.CartClearResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.CartClearResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.TransactionLookupResponse transactionLookup(com.amazon.ws.TransactionLookup body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "TransactionLookup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.TransactionLookupResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.TransactionLookupResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.TransactionLookupResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.SellerListingSearchResponse sellerListingSearch(com.amazon.ws.SellerListingSearch body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SellerListingSearch"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.SellerListingSearchResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.SellerListingSearchResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.SellerListingSearchResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.SellerListingLookupResponse sellerListingLookup(com.amazon.ws.SellerListingLookup body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SellerListingLookup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.SellerListingLookupResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.SellerListingLookupResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.SellerListingLookupResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.amazon.ws.MultiOperationResponse multiOperation(com.amazon.ws.MultiOperation body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "MultiOperation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.ws.MultiOperationResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.ws.MultiOperationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.ws.MultiOperationResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
