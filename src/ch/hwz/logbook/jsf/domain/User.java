package ch.hwz.logbook.jsf.domain;

import java.security.Principal;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class User
{
	@Inject
	private Principal currentUser;
	

    public String getUsername()
    {
    	return this.currentUser.toString();
    }
    
    public Principal getCurrentUser()
    {
    	return this.currentUser;
    }
    
    public String logout()
    {
      FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
      return "/index.xhtml?faces-redirect=true";
    }

}