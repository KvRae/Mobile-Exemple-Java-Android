package com.example.pharmacie2.Data.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "medecins")
public class Medecin {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nom;
    private String prenom;
    private String specialite;
    private String email;
    private int numero;

    private String localisation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Medecin() {
    }

    public Medecin(int id) {
        this.id = id;
    }

    public Medecin(String nom, String prenom, String specialite, String email, int numero, String localisation) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.email = email;
        this.numero = numero;
        this.localisation = localisation;
    }
}
