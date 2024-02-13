package fr.bz.jsfajax.bean;

import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;

@Named("bean")
public class BeanAdmin {
    public String navigateToParamsPage(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if (request.isUserInRole("admin")) {
            return "/faces/user/params.xhtml?faces-redirect=true";
        } else {
            return "/faces/login/login.xhtml?faces-redirect=true";
        }
    }
}
