package ch.hwz.logbook.jsf.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ch.hwz.logbook.jsf.domain.Post;
import ch.hwz.logbook.jsf.service.PostManager;

/**
 * Bean for creating new {@link Post}s.
 * 
 * @author Siebe Joris Jochems
 * 
 */
@Named
@RequestScoped
public class PostBean
{
    /**
     * A post to be created.
     */
    private Post newPost = new Post();
    /**
     * A manager class to create the post.
     */
    @Inject
    private PostManager postManager;
    /**
     * The session where the current user is stored.
     */
    @Inject
    private SessionBean sessionBean;

    public Post getNewPost()
    {
        return newPost;
    }

    public void setNewPost(Post newPost)
    {
        this.newPost = newPost;
    }

    /**
     * Create the {@link #newPost} using the {@link #postManager}.
     */
    public void createPost()
    {
        postManager.create(newPost, sessionBean.getCurrentUser());
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Post successfull!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
