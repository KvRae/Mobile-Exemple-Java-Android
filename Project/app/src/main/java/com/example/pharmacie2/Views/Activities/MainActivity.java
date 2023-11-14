package com.example.pharmacie2.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pharmacie2.R;

public class MainActivity extends AppCompatActivity {

    ImageButton btnMed  ;
    ImageButton btnPha  ;
    ImageButton btnRec  ;
    ImageButton btnuser  ;
    ImageButton poweroff ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnMed = findViewById(R.id.medecinsB);
        btnPha = findViewById(R.id.pharmacyB);
        btnRec = findViewById(R.id.reclamationB);
        btnuser = findViewById(R.id.userB);
        poweroff = findViewById(R.id.PowerB);

        btnMed.setOnClickListener(
                e ->{
                    Intent intent = new Intent(this, MedecinActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "medecin",Toast.LENGTH_SHORT).show();
                }
        );
        btnPha.setOnClickListener(
                e ->{
                    Intent intent = new Intent(this, PharmacyActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "Pharmcy",Toast.LENGTH_SHORT).show();
                }
        );
        btnRec.setOnClickListener(
                e ->{
                    Intent intent = new Intent(this, ReclamationActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "Reclamation",Toast.LENGTH_SHORT).show();
                }
        );
        btnuser.setOnClickListener(
                e ->{
                    Intent intent = new Intent(this, UsersActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "All users",Toast.LENGTH_SHORT).show();
                }
        );
        poweroff.setOnClickListener(
                e ->{
                    Intent intent = new Intent(this, SignInActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "Good By",Toast.LENGTH_SHORT).show();
                }
        );
    }

}