package com.example.pharmacie2.Data.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pharmacie2.Data.Entities.Medecin;

import java.util.List;

@Dao
public interface MedecinDao {

    @Insert
    long insertMedecin(Medecin medecin);

    @Update
    void updateMedecin(Medecin medecin);

    @Delete
    void deleteMedecin(Medecin medecin);

    @Query("SELECT * FROM medecins")
    List<Medecin> getAllMedecins();

    @Query("SELECT * FROM medecins WHERE id = :id")
    Medecin getMedecinById(int id);

}
