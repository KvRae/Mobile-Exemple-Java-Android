package com.example.pharmacie2.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pharmacie2.Data.Dao.MedicamentDao;
import com.example.pharmacie2.Data.Dao.UserDao;
import com.example.pharmacie2.Data.Database.PharmacyDB;
import com.example.pharmacie2.Data.Entities.Medicament;
import com.example.pharmacie2.Data.Entities.User;
import com.example.pharmacie2.R;

public class addMedicamentActivity extends AppCompatActivity {
    ImageView backBtn;
    ImageButton saveMedButton;
    private EditText editTextName ;
    private EditText editTextDesc ;
    private EditText editTextFab;
    private EditText editTextPrix;
    private EditText editTextQt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicament);
        backBtn = findViewById(R.id.imageViewCalendrier);
        saveMedButton = findViewById(R.id.saveMed);
        editTextName = findViewById(R.id.NameM);
        editTextDesc = findViewById(R.id.description);
        editTextFab = findViewById(R.id.fabrication);
        editTextPrix = findViewById(R.id.prix);
        editTextQt = findViewById(R.id.QT);


        backBtn.setOnClickListener(e -> {
            Intent intent = new Intent(this, PharmacyActivity.class);
            startActivity(intent);
            Toast.makeText(this, "main", Toast.LENGTH_SHORT).show();
            finish();
        });
        saveMedButton.setOnClickListener(v -> {
            String nom = editTextName.getText().toString().trim();
            String description = editTextDesc.getText().toString().trim();
            String fabricant = editTextFab.getText().toString().trim();
            Double prix = Double.valueOf(editTextPrix.getText().toString().trim());
            int quantiteEnStock = Integer.parseInt(editTextQt.getText().toString().trim());
            Intent intent = new Intent(this, PharmacyActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "Added",Toast.LENGTH_SHORT).show();

            new MedTask().execute(nom, description, fabricant, String.valueOf(prix), String.valueOf(quantiteEnStock));
        });

}
    private class MedTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            String nom = params[0];
            String description = params[1];
            String fabricant = params[2];
            Double prix = Double.valueOf(params[3]);
            int quantiteEnStock = Integer.parseInt(params[4]);

            PharmacyDB medicamentDatabase = PharmacyDB.getInstance(getApplicationContext());
            MedicamentDao medicamentDao = medicamentDatabase.medicamentDao();


            // Create a new Medicament and insert into the database
            Medicament newMedicament = new Medicament(nom, description, fabricant, prix, quantiteEnStock);
            medicamentDao.insertMedicament(newMedicament);

            return true; // Medicament added successfully
        }
    }
}
