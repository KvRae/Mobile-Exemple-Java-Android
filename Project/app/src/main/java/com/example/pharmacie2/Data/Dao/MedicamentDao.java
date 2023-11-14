package com.example.pharmacie2.Data.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pharmacie2.Data.Entities.Medicament;

import java.util.List;

@Dao
public interface MedicamentDao {
    @Query("SELECT * FROM medicaments")
    List<Medicament> getAllMedicaments();

    @Query("SELECT * FROM medicaments WHERE id = :medicamentId")
    Medicament getMedicamentById(long medicamentId);


    @Insert
    void insertMedicament(Medicament medicament);

    @Delete
    void deleteMedicament(Medicament medicament);
}
