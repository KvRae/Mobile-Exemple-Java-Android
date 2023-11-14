package com.example.pharmacie2.Data.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pharmacie2.Data.Dao.MedecinDao;
import com.example.pharmacie2.Data.Dao.MedicamentDao;
import com.example.pharmacie2.Data.Dao.UserDao;
import com.example.pharmacie2.Data.Entities.Medecin;
import com.example.pharmacie2.Data.Entities.Medicament;
import com.example.pharmacie2.Data.Entities.User;

@Database(entities = {User.class, Medicament.class, Medecin.class}, version = 1, exportSchema = false)

public abstract class PharmacyDB extends RoomDatabase {

    private static PharmacyDB instance;

    public abstract UserDao userDao();

    public abstract MedicamentDao medicamentDao();
    public abstract MedecinDao medecinDao();

    public static synchronized PharmacyDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            PharmacyDB.class,
                            "user_database,medicament_database,medecin_database"

                    )
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}