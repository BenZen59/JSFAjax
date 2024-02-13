package fr.bz.jsfajax.bean;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Sample login bean for JSF
 */
@Named("loginBean")
@ViewScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
    private String requete;
    @Inject
    FacesContext facesContext;
    @Inject
    ExternalContext externalContext;

    private String originalURI;

    @PostConstruct
    public void init() {
        originalURI = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);

        String originalQuery = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_QUERY_STRING);
        originalURI = originalURI.substring(originalURI.indexOf("/faces"));
        if (originalQuery != null) {
            originalURI += "?" + originalQuery;
        }
    }

    public String login() {

        try {
            // Get the current servlet request from the ExternalContext
            HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
            // Do login from the container (will call login module)
            request.login(username, password);
            return originalURI;
        } catch ( ServletException  servletException ) {
            //servletException.printStackTrace();
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Une erreur s'est produite : Login failed", null));
           facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Une erreur s'est produite : Login failed", null));
            //Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, servletException);
            return "/login/error.xhtml";
        }

    }
}
