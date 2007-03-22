package net.livebookstore.business;

import java.io.Serializable;
import java.util.List;

import org.acegisecurity.annotation.Secured;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.livebookstore.domain.*;

/**
 * Core service interface for business logic. All data access operations 
 * like DAO are behind this service. Also this is the facade interactive 
 * with all controllers.
 * 
 * @author xuefeng
 */
@Transactional
public interface BusinessService {

    /**
     * Query Account's username, password and privilege for authentication.
     * 
     * @param username Username to login.
     * @return Account object but only username, password and privilege is 
     * available.
     */
    @Transactional(readOnly=true)
    Account queryUserDetails(String username);

    /**
     * Query a object by specified class name and id. If not found, a 
     * DataAccessException is thrown.
     * 
     * @param clazz Class for object, e.g., Book.class.
     * @param id Object's id.
     * @return The object loaded by DAO.
     */
    @Transactional(readOnly=true)
    Object query(Class clazz, Serializable id);

    /**
     * Query all accounts by page. Only "ROLE_ADMIN" role-based user can call 
     * this method, otherwise an AccessDeniedException is thrown.
     * 
     * @param page Page information.
     * @param asc Order by asc or desc.
     * @return List of Account objects.
     */
    @Transactional(readOnly=true)
    @Secured({"ROLE_ADMIN"})
    List<Account> queryAccounts(Page page, boolean asc);

    /**
     * Query specified book's comments by page.
     * 
     * @param book Book object that the comments belong to.
     * @param page Page information.
     * @return List of Comment objects.
     */
    @Transactional(readOnly=true)
    List<Comment> queryComments(Book book, Page page);

    /**
     * Query orders by page. Only "ROLE_ADMIN" role-based user can call 
     * this method, otherwise an AccessDeniedException is thrown.
     * 
     * @param page The page information.
     * @return List of Order objects.
     */
    @Transactional(readOnly=true)
    @Secured({"ROLE_ADMIN"})
    List<Order> queryOrders(Page page);

    /**
     * Query specified account's orders by page. Only current user can call 
     * this method, otherwise an AccessDeniedException is thrown.
     * 
     * @param account Account object that the orders belong to.
     * @param page Page information.
     * @return List of Order objects.
     */
    @Transactional(readOnly=true)
    @Secured({"ROLE_USER"})
    List<Order> queryOrders(Account account, Page page);

    /**
     * Query specified account's favorite books. Only current user can call 
     * this method, otherwise an AccessDeniedException is thrown.
     * 
     * @param account Account object that the favorites belong to.
     * @param page Page information.
     * @return List of Book objects.
     */
    @Transactional(readOnly=true)
    @Secured({"ROLE_USER"})
    List<Book> queryFavorite(Account account, Page page);

    /**
     * Query root Category object.
     * 
     * @return The root category object.
     */
    @Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
    Category queryRoot();

    /**
     * Query books belong to specified category.
     * 
     * @param c The Category object.
     * @param page Page information.
     * @return List of Book objects.
     */
    @Transactional(readOnly=true)
    List<Book> queryBooks(Category c, Page page);

    /**
     * Query top-sale books belong to specified category.
     * 
     * @param c The Category object.
     * @param max Max books.
     * @return List of Book objects.
     */
    @Transactional(readOnly=true)
    List<Book> queryTopSales(Category c, int max);

    /**
     * Add a Book to user's favorite list. Only current user can call 
     * this method, otherwise an AccessDeniedException is thrown.
     * 
     * @param account The Account object.
     * @param book The Book object.
     * @return True if added successfully, false if Book is already exist in 
     * user's favorite list.
     */
    @Secured({"ROLE_USER"})
    boolean createFavorite(Account account, Book book);

    /**
     * Do user registration and create a new Account object.
     * 
     * @param account The new Account object.
     */
    void createAccount(Account account);

    /**
     * Create a new Book object. Only "ROLE_ADMIN" role-based user can call 
     * this method, otherwise an AccessDeniedException is thrown.
     * 
     * @param book The new Book object.
     */
    @Secured({"ROLE_ADMIN"})
    void createBook(Book book);

    /**
     * Create a new Comment on specified book. Only current user can call 
     * this method, otherwise an AccessDeniedException is thrown.
     * 
     * @param comment The new Comment object which already contains a reference 
     * of Book object it belongs to.
     */
    @Secured({"ROLE_USER"})
    void createComment(Comment comment);

    /**
     * Create a new Category object. Only "ROLE_ADMIN" role-based user can call 
     * this method, otherwise an AccessDeniedException is thrown.
     * 
     * @param category The new Category object.
     * @param parentId Specify its parent's id.
     */
    @Secured({"ROLE_ADMIN"})
    void createCategory(Category category, Integer parentId);

    /**
     * Create a new Order. Only current user can call this method, 
     * otherwise an AccessDeniedException is thrown.
     * 
     * @param order The new Order object which already contains a reference of 
     * Account object it belongs to.
     * @param items The list of OrderItem to describe the order's each item.
     */
    @Secured({"ROLE_USER"})
    void createOrder(Order order, List<OrderItem> items);

    /**
     * Update an Account object. Only current user can call this method, 
     * otherwise an AccessDeniedException is thrown.
     * 
     * @param account The Account object.
     */
    @Secured({"ROLE_USER"})
    void updateAccount(Account account);

    /**
     * Update a Book object. Only "ROLE_ADMIN" role-based user can call 
     * this method, otherwise an AccessDeniedException is thrown.
     * 
     * @param book The Book object.
     */
    @Secured({"ROLE_ADMIN"})
    void updateBook(Book book);

    /**
     * Update a Category object. Only "ROLE_ADMIN" role-based user can call 
     * this method, otherwise an AccessDeniedException is thrown.
     * 
     * @param category The Category object.
     */
    @Secured({"ROLE_ADMIN"})
    void updateCategory(Category category);

    /**
     * Cancel an exist non-processing Order. Only current user can call 
     * this method, otherwise an AccessDeniedException is thrown.
     * 
     * @param order The Order object.
     */
    @Secured({"ROLE_USER"})
    void cancelOrder(Order order);

    /**
     * Process the Order. Only "ROLE_ADMIN" role-based user can call 
     * this method, otherwise an AccessDeniedException is thrown.
     * 
     * @param order The Order object.
     * @param newState Set new state of the Order object, such as 
     * Order.STATE_COMPLETE, Order.STATE_DELIVER.
     */
    @Secured({"ROLE_ADMIN"})
    void updateOrder(Order order, int newState);

    /**
     * Delete a Book, Category or Comment object. Only "ROLE_ADMIN" role-based 
     * user can call this method, otherwise an AccessDeniedException is thrown.
     * 
     * @param object Object to be deleted.
     */
    @Secured({"ROLE_ADMIN"})
    void delete(Object object);

    /**
     * Delete an Account's favorite book. Only current user can call 
     * this method, otherwise an AccessDeniedException is thrown.
     * 
     * @param account The Account object.
     * @param book The Book object.
     */
    @Secured({"ROLE_USER"})
    void deleteFavorite(Account account, Book book);

    /**
     * Change the account's password. Only current user can call 
     * this method, otherwise an AccessDeniedException is thrown.
     * 
     * @param username The current Account's username.
     * @param oldPassword The old password.
     * @param newPassword The new password.
     */
    @Secured({"ROLE_USER"})
    void changePassword(String username, String oldPassword, String newPassword);

}
