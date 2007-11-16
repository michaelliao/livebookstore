package example.chapter8;

public class BookServiceImpl implements BookService {

    public Book[] search(String keyword) {
        if("j2ee".equalsIgnoreCase(keyword)) {
            return new Book[] {
                new Book("Core J2EE Patterns", "Dan Malks"),
                new Book("The J2EE Tutorial", "Bode Carson"),
                new Book("J2EE Design Patterns", "William Crawford"),
                new Book("J2EE Platform Web Services", "Ray Lai")
            };
        }
        return new Book[0];
    }

}
