package fr.bz.jsfajax.bean;

import fr.bz.jsfajax.dao.DAOFactory;
import fr.bz.jsfajax.metier.Couleur;

import fr.bz.jsfajax.metier.Pays;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudItem;
import org.primefaces.model.tagcloud.TagCloudModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Named("paysBean")
@SessionScoped
public class PaysBean implements Serializable {
    private List<Pays> allPays;

    @PostConstruct
    private void init() {
        allPays = DAOFactory.getPaysDAO().getAll();
        if (allPays == null) {
            allPays = new ArrayList<>(DAOFactory.getPaysDAO().getAll()); // Assurez-vous que la liste n'est jamais nulle
        }
    }

    public List<Pays> getAllPays() {
        return allPays;
    }

    public void setAllPays(List<Pays> allPays) {
        this.allPays = allPays;
    }
}
