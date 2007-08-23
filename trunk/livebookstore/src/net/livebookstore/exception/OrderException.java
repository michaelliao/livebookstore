package net.livebookstore.exception;

/**
 * This exception is thrown when submit order with some error.
 * 
 * @author Xuefeng
 */
public class OrderException extends ApplicationException {

    private static final long serialVersionUID = 1801797405740514395L;

    public OrderException(String message) {
        super(message);
    }
}
