package example.chapter8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amazon.ws.*;

public class Main {

    private static final String ACCESS_KEY = "1GY19EPMN1B149YS3VR2";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        AmazonService service = (AmazonService)context.getBean("amazonWebService");

        ItemSearch itemSearch = new ItemSearch();
        ItemSearchRequest request = new ItemSearchRequest();
        itemSearch.setSubscriptionId(ACCESS_KEY);

        request.setResponseGroup(new String [] {"Small"} );
        request.setSearchIndex("Books");
        request.setKeywords("j2ee");
        itemSearch.setRequest ( new ItemSearchRequest [] { request } );
        ItemSearchResponse response = service.itemSearch(itemSearch);
        if(response==null)
            throw new RuntimeException("Server Error - no response recieved!");

        Items[] itemsArray = response.getItems();
        if(itemsArray==null)
            throw new RuntimeException("Server Error - empty response!");

        if(itemsArray[0].getRequest().getErrors()!=null)
            throw new RuntimeException(itemsArray [0].getRequest().getErrors()[0].getMessage());

        for(Items items : itemsArray) {
            if(items!=null) {
                System.out.println("TotalPages " + items.getTotalPages());
                System.out.println("TotalResults " + items.getTotalResults());
                /**********************************************************
                 * Items::Item
                 **********************************************************/
                Item[] itemArray = items.getItem();
                if(itemArray!=null) {
                    for(Item item : itemArray) {
                        if(item!=null) {
                            /**********************************************************
                             * Item::ItemAttributes
                             **********************************************************/
                            ItemAttributes itemAttributes = item.getItemAttributes();
                            if(itemAttributes!=null) {
                                System.out.println("\nTitle: " + itemAttributes.getTitle());
                                StringBuffer authors = new StringBuffer();
                                String[] authorArray = itemAttributes.getAuthor();
                                if(authorArray != null) {
                                    for(String author : authorArray) {
                                        authors.append(author).append(", ");
                                    }
                                }
                                System.out.println(authors.toString());
                            }
                        }
                    }
                }
            }
        } 
    }
}
