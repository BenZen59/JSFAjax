package fr.bz.jsfajax.metier;

import java.io.Serializable;

public class Article implements Serializable {
    private int id;
    private String nomArticle;
    private float prixAchat;
    private int volume;
    private float titrage;
    private Marque marque;
    private Couleur couleur;
    private TypeBiere typeBiere;
    private Continent continent;
    private Pays pays;
    private int stock;

    public Article() {
        marque = new Marque();
        couleur = new Couleur();
        typeBiere = new TypeBiere();
        continent = new Continent();
        pays = new Pays();

    }

    public Article(int id, String nomArticle, float prixAchat, int volume, float titrage, Marque marque, Continent continent, Pays pays) {
        this.id = id;
        this.nomArticle = nomArticle;
        this.prixAchat = prixAchat;
        this.volume = volume;
        this.titrage = titrage;
        this.marque = marque;
        this.continent = continent;
        this.pays = pays;
    }

    public Article(int id, String nomArticle, float prixAchat, int volume, float titrage, Marque marque, Continent continent, Pays pays, Couleur couleur, TypeBiere typeBiere) {
        this.id = id;
        this.nomArticle = nomArticle;
        this.prixAchat = prixAchat;
        this.volume = volume;
        this.titrage = titrage;
        this.marque = marque;
        this.continent = continent;
        this.pays = pays;
        this.couleur = couleur;
        this.typeBiere = typeBiere;
    }

    public Article(int id, String nomArticle, int volume, float titrage) {
        this.id = id;
        this.nomArticle = nomArticle;
        this.volume = volume;
        this.titrage = titrage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public float getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public float getTitrage() {
        return titrage;
    }

    public void setTitrage(float titrage) {
        this.titrage = titrage;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public TypeBiere getTypeBiere() {
        return typeBiere;
    }

    public void setTypeBiere(TypeBiere typeBiere) {
        this.typeBiere = typeBiere;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
