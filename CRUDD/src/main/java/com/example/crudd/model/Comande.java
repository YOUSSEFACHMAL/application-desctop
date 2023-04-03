package com.example.crudd.model;

public class Comande {
    private Integer id ;
    private Integer id_cli ;
    private String Prix ;

    public Comande() {
    }

    public Comande(Integer id, Integer id_cli, String prix) {
        this.id = id;
        this.id_cli = id_cli;
        Prix = prix;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId_cli(Integer id_cli) {
        this.id_cli = id_cli;
    }

    public void setPrix(String prix) {
        Prix = prix;
    }

    public int getId() {
        return id;
    }

    public int getId_cli() {
        return id_cli;
    }

    public String getPrix() {
        return Prix;
    }

    @Override
    public String toString() {
        return "Comande{" +
                "id='" + id + '\'' +
                ", id_cli='" + id_cli + '\'' +
                ", Prix='" + Prix + '\'' +
                '}';
    }
}
