package com.example.pharmacie2.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pharmacie2.Data.Database.PharmacyDB;
import com.example.pharmacie2.Data.Entities.Medecin;

import com.example.pharmacie2.R;
import com.example.pharmacie2.Utils.MedecinAdapter;


import java.util.List;


public class MedecinActivity extends AppCompatActivity implements MedecinAdapter.OnDeleteClickListener{
    ImageView backBtn ;
    ImageView AddM ;
    PharmacyDB db;
    private RecyclerView recyclerViewMed;
    private MedecinAdapter medecinAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medecin);
        db = PharmacyDB.getInstance(this);
        recyclerViewMed = findViewById(R.id.recyclerView3);
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
                    Intent intent = new Intent(this, AjouterMedecinActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "main",Toast.LENGTH_SHORT).show();
                    finish();
                }
        );
    }

    @Override
        public void onDeleteClick(Medecin medecin) {
            new DeleteMedTask().execute(medecin);
        }
        @Override
        public void onPointerCaptureChanged(boolean hasCapture) {
            super.onPointerCaptureChanged(hasCapture);
        }


        private class LoadMedTask extends AsyncTask<Void, Void, List<Medecin>> {
            private RecyclerView recyclerView3;

            public LoadMedTask(RecyclerView recyclerView3) {
                this.recyclerView3 = recyclerView3;
            }


            @Override
            protected List<Medecin> doInBackground(Void... voids) {
                return db.medecinDao().getAllMedecins();
            }

            @Override
            protected void onPostExecute(List<Medecin> medecinList) {
                medecinAdapter = new MedecinAdapter(medecinList,MedecinActivity.this);
                recyclerView3.setAdapter(medecinAdapter);
                medecinAdapter.updateList(medecinList); // Update the adapter with the new list

            }



        }


        private class DeleteMedTask extends AsyncTask<Medecin, Void, Void> {
        @Override
        protected Void doInBackground(Medecin... medecins) {
            // Perform delete operation on a background thread
            db.medecinDao().deleteMedecin(medecins[0]);
            return null;
        }
    }

}