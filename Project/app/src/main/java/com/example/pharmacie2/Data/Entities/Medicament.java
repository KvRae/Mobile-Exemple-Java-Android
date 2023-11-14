package com.example.pharmacie2.Data.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "medicaments")
public class Medicament {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nom;
    private String description;
    private String fabricant;
    private double prix;
    private int quantiteEnStock;

    public Medicament() {
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }


    public Medicament(String nom, String description, String fabricant, double prix, int quantiteEnStock) {
        this.nom = nom;
        this.description = description;
        this.fabricant = fabricant;
        this.prix = prix;
        this.quantiteEnStock = quantiteEnStock;
    }
}
