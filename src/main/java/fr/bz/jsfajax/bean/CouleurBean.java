package fr.bz.jsfajax.bean;

import fr.bz.jsfajax.dao.DAOFactory;
import fr.bz.jsfajax.metier.Couleur;

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

@Named("couleurBean")
@SessionScoped
public class CouleurBean implements Serializable {
    private List<Couleur> allCouleurs;
    private Couleur couleurSelected;
    private TagCloudModel model;

    @PostConstruct
    private void init() {
        allCouleurs = DAOFactory.getCouleurDAO().getAll();
        if (allCouleurs == null) {
            allCouleurs = new ArrayList<>(DAOFactory.getCouleurDAO().getAll()); // Assurez-vous que la liste n'est jamais nulle
        }
        model = new DefaultTagCloudModel();
        Random random = new Random();
        for (Couleur couleur : allCouleurs) {
            int frequence = random.nextInt(4) + 1;
            model.addTag(new DefaultTagCloudItem(couleur.getNomCouleur(), frequence));
        }
    }

    public List<Couleur> getAllCouleurs() {
        return allCouleurs;
    }

    public void setAllCouleurs(List<Couleur> allCouleurs) {
        this.allCouleurs = allCouleurs;
    }

    public List<Couleur> getCouleurs() {
        return allCouleurs;
    }

    public Couleur getCouleurSelected() {
        return couleurSelected;
    }

    public void setCouleurSelected(Couleur couleurSelected) {
        this.couleurSelected = couleurSelected;
    }

    public String getOnColorSelect() {
        return couleurSelected.getNomCouleur();
    }

    public TagCloudModel getModel() {
        return model;
    }

    public void onSelect(SelectEvent<TagCloudItem> event) {
        TagCloudItem item = event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", item.getLabel());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
