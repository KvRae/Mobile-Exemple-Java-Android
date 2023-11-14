package com.example.pharmacie2.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pharmacie2.Data.Dao.MedecinDao;
import com.example.pharmacie2.Data.Database.PharmacyDB;
import com.example.pharmacie2.Data.Entities.Medecin;
import com.example.pharmacie2.R;

public class AjouterMedecinActivity extends AppCompatActivity {
    ImageView backBtn;
    ImageButton saveMedButton;
    private EditText editTextNom ;
    private EditText editTextPrenom ;
    private EditText editTextSpecialite;
    private EditText editTextEmail;
    private EditText editTextNumero ;
    private EditText editTextLocalisation ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_medecin);
        saveMedButton = findViewById(R.id.saveMed);
        editTextNom = findViewById(R.id.nomMedecin);
        editTextPrenom = findViewById(R.id.prenomMedecin);
        editTextSpecialite = findViewById(R.id.specialiteMedecin);
        editTextEmail = findViewById(R.id.emailMedecin);
        editTextNumero = findViewById(R.id.numeroMedecin);
        editTextLocalisation = findViewById(R.id.localisationMedecin);
        backBtn = findViewById(R.id.imageViewCalendrier);
        backBtn.setOnClickListener(e -> {
            Intent intent = new Intent(this, MedecinActivity.class);
            startActivity(intent);
            Toast.makeText(this, "main", Toast.LENGTH_SHORT).show();
            finish();
        });
     saveMedButton.setOnClickListener(v -> {
        String nom = editTextNom.getText().toString().trim();
        String prenom = editTextPrenom.getText().toString().trim();
        String specialite = editTextSpecialite.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        int numero = Integer.parseInt(editTextNumero.getText().toString().trim());
        String localisation = editTextLocalisation.getText().toString().trim();
        Intent intent = new Intent(this, MedecinActivity.class);
        startActivity(intent);
        finish();
        Toast.makeText(this, "Added",Toast.LENGTH_SHORT).show();

        new MedTask().execute(nom, prenom, specialite,email, String.valueOf(numero), localisation);
    });

}
private class MedTask extends AsyncTask<String, Void, Boolean> {
    @Override
    protected Boolean doInBackground(String... params) {
        String nom = params[0];
        String prenom = params[1];
        String specialite = params[2];
        String email = params[3];
        int numero = Integer.parseInt(params[4]);
        String localisation = params[5];


        PharmacyDB medecinDatabase = PharmacyDB.getInstance(getApplicationContext());
        MedecinDao medecinDao = medecinDatabase.medecinDao();


        // Create a new Medicament and insert into the database
        Medecin newMedicament = new Medecin(nom, prenom, specialite, email, numero,localisation);
        medecinDao.insertMedecin(newMedicament);

        return true; // Medicament added successfully
    }
}

}