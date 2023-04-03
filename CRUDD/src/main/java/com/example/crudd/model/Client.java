package com.example.crudd.model;

public class Client extends Credit {
    private Integer id ;
    private String nom;
    private String adresse;

    public Client() {
    }

    public Client(int id ,String nom, String adresse) {
        this.id = id ;
        this.nom = nom;
        this.adresse = adresse;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }


    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }


    public String getAdresse() {
        return adresse;
    }

    @Override
    public String toString() {
        return "Client{" +
                "Nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
