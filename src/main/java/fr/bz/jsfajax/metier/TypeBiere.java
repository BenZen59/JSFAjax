package fr.bz.jsfajax.metier;

import java.io.Serializable;


public class TypeBiere implements Serializable {
    private int id;
    private String nomType;

    public TypeBiere() {

    }
    public TypeBiere(int id, String nomType) {
        this.id = id;
        this.nomType = nomType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }

    @Override
    public String toString() {
        return nomType;
    }

}
