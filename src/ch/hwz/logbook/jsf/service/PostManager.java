package ch.hwz.logbook.jsf.service;

import java.util.Date;

import javax.inject.Named;

import ch.hwz.logbook.jsf.domain.Post;
import ch.hwz.logbook.jsf.domain.User;

/**
 * A manager class for {@link Post}s which performs business logic.
 * 
 * @author Siebe Joris Jochems
 * 
 */
@Named
public class PostManager
{
    /**
     * Create and connect a post to a user. This method also sets the date of
     * the {@link Post} to the current date/time.
     * 
     * @param post The {@link Post} to create.
     * @param user The {@link User} that is the author of the {@link Post}.
     */
    public void create(Post post, User user)
    {
        post.setDate(new Date());
        user.getPosts().add(post);
    }
}
