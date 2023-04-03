package com.example.crudd.model;

import java.util.Date;

public class Credit{
    private int id ;
    private String date ;
    private String montant ;
    private int Id_cli ;

    public Credit() {
    }

    public Credit(int id, String date, String montant, int id_cli) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.Id_cli = id_cli;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public void setId_cli(int id_cli) {
        this.Id_cli = id_cli;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getMontant() {
        return montant;
    }

    public int getId_cli() {
        return Id_cli;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", date=" + date +
                ", montant='" + montant + '\'' +
                ", Id_cli=" + Id_cli +
                '}';
    }

}
