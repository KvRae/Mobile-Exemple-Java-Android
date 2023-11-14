package com.example.pharmacie2.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pharmacie2.Data.Database.PharmacyDB;
import com.example.pharmacie2.Data.Entities.Medicament;
import com.example.pharmacie2.Data.Entities.User;
import com.example.pharmacie2.R;
import com.example.pharmacie2.Utils.MedicamentAdapter;
import com.example.pharmacie2.Utils.UserAdapter;

import java.util.List;

public class PharmacyActivity extends AppCompatActivity implements MedicamentAdapter.OnDeleteClickListener{
    ImageView backBtn ;
    ImageView AddM ;
    PharmacyDB db;
    private RecyclerView recyclerViewMed;
    private MedicamentAdapter medicamentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy);
        db = PharmacyDB.getInstance(this);
        recyclerViewMed = findViewById(R.id.recyclerView2);
        recyclerViewMed.setLayoutManager(new LinearLayoutManager(this));
        backBtn = findViewById(R.id.imageViewCalendrier);
        AddM = findViewById(R.id.AddMedi);
        new LoadMedTask(recyclerViewMed).execute();

        backBtn.setOnClickListener(
                e ->{
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "main",Toast.LENGTH_SHORT).show();
                    finish();
                }
        );
        AddM.setOnClickListener(
                e ->{
                    Intent intent = new Intent(this, addMedicamentActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "main",Toast.LENGTH_SHORT).show();
                    finish();
                }
        );
    }

    @Override
    public void onDeleteClick(Medicament medicament) {
        new DeleteMedTask().execute(medicament);
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


    private class LoadMedTask extends AsyncTask<Void, Void, List<Medicament>> {
        private RecyclerView recyclerView2;

        public LoadMedTask(RecyclerView recyclerView2) {
            this.recyclerView2 = recyclerView2;
        }


        @Override
        protected List<Medicament> doInBackground(Void... voids) {
            return db.medicamentDao().getAllMedicaments();
        }

        @Override
        protected void onPostExecute(List<Medicament> medicamentList) {
            medicamentAdapter = new MedicamentAdapter(medicamentList,PharmacyActivity.this);
            recyclerView2.setAdapter(medicamentAdapter);
            medicamentAdapter.updateList(medicamentList); // Update the adapter with the new list

        }



    }
    private class DeleteMedTask extends AsyncTask<Medicament, Void, Void> {
        @Override
        protected Void doInBackground(Medicament... medicaments) {
            // Perform delete operation on a background thread
            db.medicamentDao().deleteMedicament(medicaments[0]);
            return null;
        }
    }
}