package com.example.crudd.model;

public class Produit {
    private String nom ;
    private String quantite ;
    private String type ;
    private String prix ;
    private int id ;
    public Produit() {
    }

    public Produit(int id,String nom,String type , String quantite, String prix) {
        this.id=id ;
        this.nom = nom;
        this.type = type;
        this.quantite = quantite;

        this.prix = prix;
    }
    public void setId(int id) {
        this.id=id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    public String getQuantite() {
        return quantite;
    }

    public String getType() {
        return type;
    }

    public String getPrix() {
        return prix ;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "nom='" + nom + '\'' +
                ", quantite='" + quantite + '\'' +
                ", type='" + type + '\'' +
                ", prix='" + prix + '\'' +
                '}';
    }
}
