package ch.hwz.logbook.jsf.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ch.hwz.logbook.jsf.domain.User;

/**
 * A {@link SessionScoped} bean that is used for storing a user's session.
 * 
 * @author Siebe Joris Jochems
 * 
 */
@Named
@SessionScoped
public class SessionBean implements Serializable
{
    /**
     * A version number to satisfy the implementation of {@link Serializable}.
     */
    private static final long serialVersionUID = 1L;
    /**
     * The current active user.
     */
    private User currentUser;

    /**
     * @return The current active user.
     */
    public User getCurrentUser()
    {
        return currentUser;
    }

    /**
     * Set the current active {@link User}
     * 
     * @param currentUser The current active user.
     */
    public void setCurrentUser(User currentUser)
    {
        this.currentUser = currentUser;
    }
}
