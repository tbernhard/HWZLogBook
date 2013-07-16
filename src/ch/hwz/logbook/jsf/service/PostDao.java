package ch.hwz.logbook.jsf.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ch.hwz.logbook.jsf.model.Post;

@Stateless
public class PostDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new guest:
    public void persist(Post post) {
        em.persist(post);
    }
 
    // Retrieves all the guests:
    public List<Post> getAllGuests() {
        TypedQuery<Post> query = em.createQuery(
            "SELECT p FROM post p ORDER BY p.postID", Post.class);
        return query.getResultList();
    }
}
