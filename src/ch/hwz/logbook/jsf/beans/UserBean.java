package ch.hwz.logbook.jsf.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ch.hwz.logbook.jsf.domain.User;

/**
 * Bean for performing {@link User} related stuff.
 * 
 * @author Siebe Joris Jochems
 * 
 */
@Named
@RequestScoped
public class UserBean
{
    /**
     * A user that is to-be-created.
     */
    private User newUser = new User();
    /**
     * The session to store the user in.
     */
    @Inject
    private SessionBean sessionBean;

    public User getNewUser()
    {
        return newUser;
    }

    public void setNewUser(User newUser)
    {
        this.newUser = newUser;
    }

    /**
     * Store the {@link #newUser} in the {@link #sessionBean} and add a
     * {@link FacesMessage} to the {@link FacesContext}.
     */
    public void createUser()
    {
        sessionBean.setCurrentUser(newUser);
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("User created!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
