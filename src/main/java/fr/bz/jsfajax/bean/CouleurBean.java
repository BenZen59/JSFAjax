package fr.bz.jsfajax.bean;

import fr.bz.jsfajax.dao.DAOFactory;
import fr.bz.jsfajax.metier.Couleur;


import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("couleurBean")
@ManagedBean
public class CouleurBean implements Serializable {
    private static ArrayList<Couleur> allCouleurs;
    private Couleur couleurSelected;

    @PostConstruct
    private void init() {
        allCouleurs = DAOFactory.getCouleurDAO().getAll();
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
}
