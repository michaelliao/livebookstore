package net.livebookstore.dao.hibernate;

import java.util.List;

import net.livebookstore.domain.*;

import net.livebookstore.dao.CommentDao;

/**
 * Implementation of CommentDao.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="commentDao"
 */
public class CommentDaoImpl extends GenericHibernateDao<Comment> implements CommentDao {

    public CommentDaoImpl() {
        super(Comment.class);
    }

    @SuppressWarnings("unchecked")
    public List<Comment> queryComments(Book book, Page page) {
        return queryForList(
                "select count(*) from Comment as c where c.book=?",
                "select c from Comment as c where c.book=? order by c.createdDate desc",
                new Object[] {book},
                page
        );
    }

    @Override
    public void create(final Comment comment) {
        // check if already rated:
        Long ratingCount = (Long)queryForObject(
                "select count(*) from Comment as c where c.book=? and c.account=?",
                new Object[] {comment.getBook(), comment.getAccount()}
        );
        boolean alreadyRated = ratingCount.longValue()>0;
        hibernateTemplate.save(comment);
        if(alreadyRated)
            return;
        // update book's average rating and rating count:
        Long sum = (Long)queryForObject(
                "select sum(c.rating) from Comment as c where c.book=?",
                new Object[] {comment.getBook()}
        ); 
        Long count = (Long)queryForObject(
                "select count(*) from Comment as c where c.book=?",
                new Object[] {comment.getBook()}
        );
        Book book = comment.getBook();
        book.setRating(sum.intValue());
        book.setRatingCount(count.intValue());
        hibernateTemplate.update(book);
    }

    /**
     * DO NOT allow update comment.
     */
    @Override
    public void update(Comment t) {
        throw new UnsupportedOperationException();
    }

}
