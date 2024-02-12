package fr.bz.jsfajax.metier;

import java.io.Serializable;

public class Couleur implements Serializable {
    private int idCouleur;
    private String nomCouleur;

    public Couleur() {

    }

    public Couleur(int idCouleur, String nomCouleur) {
        this.idCouleur = idCouleur;
        this.nomCouleur = nomCouleur;
    }

    public int getIdCouleur() {
        return idCouleur;
    }

    public void setIdCouleur(int idCouleur) {
        this.idCouleur = idCouleur;
    }

    public String getNomCouleur() {
        return nomCouleur;
    }

    public void setNomCouleur(String nomCouleur) {
        this.nomCouleur = nomCouleur;
    }

    @Override
    public String toString() {
        return nomCouleur;
    }

    public int getId() {
        return 0;
    }


}

