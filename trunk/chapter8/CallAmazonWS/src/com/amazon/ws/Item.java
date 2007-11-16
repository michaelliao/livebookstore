/**
 * Item.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.amazon.ws;

public class Item  implements java.io.Serializable {
    private java.lang.String ASIN;

    private com.amazon.ws.ErrorsError[] errors;

    private java.lang.String detailPageURL;

    private java.lang.String salesRank;

    private com.amazon.ws.Image smallImage;

    private com.amazon.ws.Image mediumImage;

    private com.amazon.ws.Image largeImage;

    private com.amazon.ws.ItemAttributes itemAttributes;

    private com.amazon.ws.OfferSummary offerSummary;

    private com.amazon.ws.Offers offers;

    private com.amazon.ws.VariationSummary variationSummary;

    private com.amazon.ws.Variations variations;

    private com.amazon.ws.CustomerReviews customerReviews;

    private com.amazon.ws.EditorialReview[] editorialReviews;

    private com.amazon.ws.SimilarProductsSimilarProduct[] similarProducts;

    private com.amazon.ws.AccessoriesAccessory[] accessories;

    private com.amazon.ws.TracksDiscTrack[][] tracks;

    private com.amazon.ws.BrowseNodes browseNodes;

    private com.amazon.ws.ListmaniaListsListmaniaList[] listmaniaLists;

    private com.amazon.ws.SearchInside searchInside;

    private com.amazon.ws.PromotionalTag promotionalTag;

    public Item() {
    }

    public Item(
           java.lang.String ASIN,
           com.amazon.ws.ErrorsError[] errors,
           java.lang.String detailPageURL,
           java.lang.String salesRank,
           com.amazon.ws.Image smallImage,
           com.amazon.ws.Image mediumImage,
           com.amazon.ws.Image largeImage,
           com.amazon.ws.ItemAttributes itemAttributes,
           com.amazon.ws.OfferSummary offerSummary,
           com.amazon.ws.Offers offers,
           com.amazon.ws.VariationSummary variationSummary,
           com.amazon.ws.Variations variations,
           com.amazon.ws.CustomerReviews customerReviews,
           com.amazon.ws.EditorialReview[] editorialReviews,
           com.amazon.ws.SimilarProductsSimilarProduct[] similarProducts,
           com.amazon.ws.AccessoriesAccessory[] accessories,
           com.amazon.ws.TracksDiscTrack[][] tracks,
           com.amazon.ws.BrowseNodes browseNodes,
           com.amazon.ws.ListmaniaListsListmaniaList[] listmaniaLists,
           com.amazon.ws.SearchInside searchInside,
           com.amazon.ws.PromotionalTag promotionalTag) {
           this.ASIN = ASIN;
           this.errors = errors;
           this.detailPageURL = detailPageURL;
           this.salesRank = salesRank;
           this.smallImage = smallImage;
           this.mediumImage = mediumImage;
           this.largeImage = largeImage;
           this.itemAttributes = itemAttributes;
           this.offerSummary = offerSummary;
           this.offers = offers;
           this.variationSummary = variationSummary;
           this.variations = variations;
           this.customerReviews = customerReviews;
           this.editorialReviews = editorialReviews;
           this.similarProducts = similarProducts;
           this.accessories = accessories;
           this.tracks = tracks;
           this.browseNodes = browseNodes;
           this.listmaniaLists = listmaniaLists;
           this.searchInside = searchInside;
           this.promotionalTag = promotionalTag;
    }


    /**
     * Gets the ASIN value for this Item.
     * 
     * @return ASIN
     */
    public java.lang.String getASIN() {
        return ASIN;
    }


    /**
     * Sets the ASIN value for this Item.
     * 
     * @param ASIN
     */
    public void setASIN(java.lang.String ASIN) {
        this.ASIN = ASIN;
    }


    /**
     * Gets the errors value for this Item.
     * 
     * @return errors
     */
    public com.amazon.ws.ErrorsError[] getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this Item.
     * 
     * @param errors
     */
    public void setErrors(com.amazon.ws.ErrorsError[] errors) {
        this.errors = errors;
    }


    /**
     * Gets the detailPageURL value for this Item.
     * 
     * @return detailPageURL
     */
    public java.lang.String getDetailPageURL() {
        return detailPageURL;
    }


    /**
     * Sets the detailPageURL value for this Item.
     * 
     * @param detailPageURL
     */
    public void setDetailPageURL(java.lang.String detailPageURL) {
        this.detailPageURL = detailPageURL;
    }


    /**
     * Gets the salesRank value for this Item.
     * 
     * @return salesRank
     */
    public java.lang.String getSalesRank() {
        return salesRank;
    }


    /**
     * Sets the salesRank value for this Item.
     * 
     * @param salesRank
     */
    public void setSalesRank(java.lang.String salesRank) {
        this.salesRank = salesRank;
    }


    /**
     * Gets the smallImage value for this Item.
     * 
     * @return smallImage
     */
    public com.amazon.ws.Image getSmallImage() {
        return smallImage;
    }


    /**
     * Sets the smallImage value for this Item.
     * 
     * @param smallImage
     */
    public void setSmallImage(com.amazon.ws.Image smallImage) {
        this.smallImage = smallImage;
    }


    /**
     * Gets the mediumImage value for this Item.
     * 
     * @return mediumImage
     */
    public com.amazon.ws.Image getMediumImage() {
        return mediumImage;
    }


    /**
     * Sets the mediumImage value for this Item.
     * 
     * @param mediumImage
     */
    public void setMediumImage(com.amazon.ws.Image mediumImage) {
        this.mediumImage = mediumImage;
    }


    /**
     * Gets the largeImage value for this Item.
     * 
     * @return largeImage
     */
    public com.amazon.ws.Image getLargeImage() {
        return largeImage;
    }


    /**
     * Sets the largeImage value for this Item.
     * 
     * @param largeImage
     */
    public void setLargeImage(com.amazon.ws.Image largeImage) {
        this.largeImage = largeImage;
    }


    /**
     * Gets the itemAttributes value for this Item.
     * 
     * @return itemAttributes
     */
    public com.amazon.ws.ItemAttributes getItemAttributes() {
        return itemAttributes;
    }


    /**
     * Sets the itemAttributes value for this Item.
     * 
     * @param itemAttributes
     */
    public void setItemAttributes(com.amazon.ws.ItemAttributes itemAttributes) {
        this.itemAttributes = itemAttributes;
    }


    /**
     * Gets the offerSummary value for this Item.
     * 
     * @return offerSummary
     */
    public com.amazon.ws.OfferSummary getOfferSummary() {
        return offerSummary;
    }


    /**
     * Sets the offerSummary value for this Item.
     * 
     * @param offerSummary
     */
    public void setOfferSummary(com.amazon.ws.OfferSummary offerSummary) {
        this.offerSummary = offerSummary;
    }


    /**
     * Gets the offers value for this Item.
     * 
     * @return offers
     */
    public com.amazon.ws.Offers getOffers() {
        return offers;
    }


    /**
     * Sets the offers value for this Item.
     * 
     * @param offers
     */
    public void setOffers(com.amazon.ws.Offers offers) {
        this.offers = offers;
    }


    /**
     * Gets the variationSummary value for this Item.
     * 
     * @return variationSummary
     */
    public com.amazon.ws.VariationSummary getVariationSummary() {
        return variationSummary;
    }


    /**
     * Sets the variationSummary value for this Item.
     * 
     * @param variationSummary
     */
    public void setVariationSummary(com.amazon.ws.VariationSummary variationSummary) {
        this.variationSummary = variationSummary;
    }


    /**
     * Gets the variations value for this Item.
     * 
     * @return variations
     */
    public com.amazon.ws.Variations getVariations() {
        return variations;
    }


    /**
     * Sets the variations value for this Item.
     * 
     * @param variations
     */
    public void setVariations(com.amazon.ws.Variations variations) {
        this.variations = variations;
    }


    /**
     * Gets the customerReviews value for this Item.
     * 
     * @return customerReviews
     */
    public com.amazon.ws.CustomerReviews getCustomerReviews() {
        return customerReviews;
    }


    /**
     * Sets the customerReviews value for this Item.
     * 
     * @param customerReviews
     */
    public void setCustomerReviews(com.amazon.ws.CustomerReviews customerReviews) {
        this.customerReviews = customerReviews;
    }


    /**
     * Gets the editorialReviews value for this Item.
     * 
     * @return editorialReviews
     */
    public com.amazon.ws.EditorialReview[] getEditorialReviews() {
        return editorialReviews;
    }


    /**
     * Sets the editorialReviews value for this Item.
     * 
     * @param editorialReviews
     */
    public void setEditorialReviews(com.amazon.ws.EditorialReview[] editorialReviews) {
        this.editorialReviews = editorialReviews;
    }


    /**
     * Gets the similarProducts value for this Item.
     * 
     * @return similarProducts
     */
    public com.amazon.ws.SimilarProductsSimilarProduct[] getSimilarProducts() {
        return similarProducts;
    }


    /**
     * Sets the similarProducts value for this Item.
     * 
     * @param similarProducts
     */
    public void setSimilarProducts(com.amazon.ws.SimilarProductsSimilarProduct[] similarProducts) {
        this.similarProducts = similarProducts;
    }


    /**
     * Gets the accessories value for this Item.
     * 
     * @return accessories
     */
    public com.amazon.ws.AccessoriesAccessory[] getAccessories() {
        return accessories;
    }


    /**
     * Sets the accessories value for this Item.
     * 
     * @param accessories
     */
    public void setAccessories(com.amazon.ws.AccessoriesAccessory[] accessories) {
        this.accessories = accessories;
    }


    /**
     * Gets the tracks value for this Item.
     * 
     * @return tracks
     */
    public com.amazon.ws.TracksDiscTrack[][] getTracks() {
        return tracks;
    }


    /**
     * Sets the tracks value for this Item.
     * 
     * @param tracks
     */
    public void setTracks(com.amazon.ws.TracksDiscTrack[][] tracks) {
        this.tracks = tracks;
    }


    /**
     * Gets the browseNodes value for this Item.
     * 
     * @return browseNodes
     */
    public com.amazon.ws.BrowseNodes getBrowseNodes() {
        return browseNodes;
    }


    /**
     * Sets the browseNodes value for this Item.
     * 
     * @param browseNodes
     */
    public void setBrowseNodes(com.amazon.ws.BrowseNodes browseNodes) {
        this.browseNodes = browseNodes;
    }


    /**
     * Gets the listmaniaLists value for this Item.
     * 
     * @return listmaniaLists
     */
    public com.amazon.ws.ListmaniaListsListmaniaList[] getListmaniaLists() {
        return listmaniaLists;
    }


    /**
     * Sets the listmaniaLists value for this Item.
     * 
     * @param listmaniaLists
     */
    public void setListmaniaLists(com.amazon.ws.ListmaniaListsListmaniaList[] listmaniaLists) {
        this.listmaniaLists = listmaniaLists;
    }


    /**
     * Gets the searchInside value for this Item.
     * 
     * @return searchInside
     */
    public com.amazon.ws.SearchInside getSearchInside() {
        return searchInside;
    }


    /**
     * Sets the searchInside value for this Item.
     * 
     * @param searchInside
     */
    public void setSearchInside(com.amazon.ws.SearchInside searchInside) {
        this.searchInside = searchInside;
    }


    /**
     * Gets the promotionalTag value for this Item.
     * 
     * @return promotionalTag
     */
    public com.amazon.ws.PromotionalTag getPromotionalTag() {
        return promotionalTag;
    }


    /**
     * Sets the promotionalTag value for this Item.
     * 
     * @param promotionalTag
     */
    public void setPromotionalTag(com.amazon.ws.PromotionalTag promotionalTag) {
        this.promotionalTag = promotionalTag;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Item)) return false;
        Item other = (Item) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ASIN==null && other.getASIN()==null) || 
             (this.ASIN!=null &&
              this.ASIN.equals(other.getASIN()))) &&
            ((this.errors==null && other.getErrors()==null) || 
             (this.errors!=null &&
              java.util.Arrays.equals(this.errors, other.getErrors()))) &&
            ((this.detailPageURL==null && other.getDetailPageURL()==null) || 
             (this.detailPageURL!=null &&
              this.detailPageURL.equals(other.getDetailPageURL()))) &&
            ((this.salesRank==null && other.getSalesRank()==null) || 
             (this.salesRank!=null &&
              this.salesRank.equals(other.getSalesRank()))) &&
            ((this.smallImage==null && other.getSmallImage()==null) || 
             (this.smallImage!=null &&
              this.smallImage.equals(other.getSmallImage()))) &&
            ((this.mediumImage==null && other.getMediumImage()==null) || 
             (this.mediumImage!=null &&
              this.mediumImage.equals(other.getMediumImage()))) &&
            ((this.largeImage==null && other.getLargeImage()==null) || 
             (this.largeImage!=null &&
              this.largeImage.equals(other.getLargeImage()))) &&
            ((this.itemAttributes==null && other.getItemAttributes()==null) || 
             (this.itemAttributes!=null &&
              this.itemAttributes.equals(other.getItemAttributes()))) &&
            ((this.offerSummary==null && other.getOfferSummary()==null) || 
             (this.offerSummary!=null &&
              this.offerSummary.equals(other.getOfferSummary()))) &&
            ((this.offers==null && other.getOffers()==null) || 
             (this.offers!=null &&
              this.offers.equals(other.getOffers()))) &&
            ((this.variationSummary==null && other.getVariationSummary()==null) || 
             (this.variationSummary!=null &&
              this.variationSummary.equals(other.getVariationSummary()))) &&
            ((this.variations==null && other.getVariations()==null) || 
             (this.variations!=null &&
              this.variations.equals(other.getVariations()))) &&
            ((this.customerReviews==null && other.getCustomerReviews()==null) || 
             (this.customerReviews!=null &&
              this.customerReviews.equals(other.getCustomerReviews()))) &&
            ((this.editorialReviews==null && other.getEditorialReviews()==null) || 
             (this.editorialReviews!=null &&
              java.util.Arrays.equals(this.editorialReviews, other.getEditorialReviews()))) &&
            ((this.similarProducts==null && other.getSimilarProducts()==null) || 
             (this.similarProducts!=null &&
              java.util.Arrays.equals(this.similarProducts, other.getSimilarProducts()))) &&
            ((this.accessories==null && other.getAccessories()==null) || 
             (this.accessories!=null &&
              java.util.Arrays.equals(this.accessories, other.getAccessories()))) &&
            ((this.tracks==null && other.getTracks()==null) || 
             (this.tracks!=null &&
              java.util.Arrays.equals(this.tracks, other.getTracks()))) &&
            ((this.browseNodes==null && other.getBrowseNodes()==null) || 
             (this.browseNodes!=null &&
              this.browseNodes.equals(other.getBrowseNodes()))) &&
            ((this.listmaniaLists==null && other.getListmaniaLists()==null) || 
             (this.listmaniaLists!=null &&
              java.util.Arrays.equals(this.listmaniaLists, other.getListmaniaLists()))) &&
            ((this.searchInside==null && other.getSearchInside()==null) || 
             (this.searchInside!=null &&
              this.searchInside.equals(other.getSearchInside()))) &&
            ((this.promotionalTag==null && other.getPromotionalTag()==null) || 
             (this.promotionalTag!=null &&
              this.promotionalTag.equals(other.getPromotionalTag())));
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
        if (getASIN() != null) {
            _hashCode += getASIN().hashCode();
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
        if (getDetailPageURL() != null) {
            _hashCode += getDetailPageURL().hashCode();
        }
        if (getSalesRank() != null) {
            _hashCode += getSalesRank().hashCode();
        }
        if (getSmallImage() != null) {
            _hashCode += getSmallImage().hashCode();
        }
        if (getMediumImage() != null) {
            _hashCode += getMediumImage().hashCode();
        }
        if (getLargeImage() != null) {
            _hashCode += getLargeImage().hashCode();
        }
        if (getItemAttributes() != null) {
            _hashCode += getItemAttributes().hashCode();
        }
        if (getOfferSummary() != null) {
            _hashCode += getOfferSummary().hashCode();
        }
        if (getOffers() != null) {
            _hashCode += getOffers().hashCode();
        }
        if (getVariationSummary() != null) {
            _hashCode += getVariationSummary().hashCode();
        }
        if (getVariations() != null) {
            _hashCode += getVariations().hashCode();
        }
        if (getCustomerReviews() != null) {
            _hashCode += getCustomerReviews().hashCode();
        }
        if (getEditorialReviews() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEditorialReviews());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEditorialReviews(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSimilarProducts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSimilarProducts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSimilarProducts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAccessories() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccessories());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccessories(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTracks() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTracks());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTracks(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBrowseNodes() != null) {
            _hashCode += getBrowseNodes().hashCode();
        }
        if (getListmaniaLists() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListmaniaLists());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListmaniaLists(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSearchInside() != null) {
            _hashCode += getSearchInside().hashCode();
        }
        if (getPromotionalTag() != null) {
            _hashCode += getPromotionalTag().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Item.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Item"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ASIN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ASIN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("detailPageURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "DetailPageURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesRank");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SalesRank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smallImage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SmallImage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Image"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mediumImage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "MediumImage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Image"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("largeImage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "LargeImage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Image"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemAttributes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ItemAttributes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ItemAttributes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offerSummary");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "OfferSummary"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">OfferSummary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Offers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Offers"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("variationSummary");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "VariationSummary"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">VariationSummary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("variations");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Variations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Variations"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerReviews");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "CustomerReviews"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">CustomerReviews"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editorialReviews");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "EditorialReviews"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">EditorialReviews"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("similarProducts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SimilarProducts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SimilarProducts"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accessories");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Accessories"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Accessories"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tracks");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "Tracks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">Tracks"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("browseNodes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "BrowseNodes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">BrowseNodes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listmaniaLists");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "ListmaniaLists"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">ListmaniaLists"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchInside");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "SearchInside"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">SearchInside"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("promotionalTag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", "PromotionalTag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.amazon.com/AWSECommerceService/2005-03-23", ">PromotionalTag"));
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
