package example.chapter8;

import com.amazon.ws.*;

public interface AmazonService {

    public HelpResponse help(Help body);
    public ItemSearchResponse itemSearch(ItemSearch body);
    public ItemLookupResponse itemLookup(ItemLookup body);
    public BrowseNodeLookupResponse browseNodeLookup(BrowseNodeLookup body);
    public ListSearchResponse listSearch(ListSearch body);
    public ListLookupResponse listLookup(ListLookup body);
    public CustomerContentSearchResponse customerContentSearch(CustomerContentSearch body);
    public CustomerContentLookupResponse customerContentLookup(CustomerContentLookup body);
    public SimilarityLookupResponse similarityLookup(SimilarityLookup body);
    public SellerLookupResponse sellerLookup(SellerLookup body);
    public CartGetResponse cartGet(CartGet body);
    public CartAddResponse cartAdd(CartAdd body);
    public CartCreateResponse cartCreate(CartCreate body);
    public CartModifyResponse cartModify(CartModify body);
    public CartClearResponse cartClear(CartClear body);
    public TransactionLookupResponse transactionLookup(TransactionLookup body);
    public SellerListingSearchResponse sellerListingSearch(SellerListingSearch body);
    public SellerListingLookupResponse sellerListingLookup(SellerListingLookup body);
    public MultiOperationResponse multiOperation(MultiOperation body);

}
