package com.example.pharmacie2.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pharmacie2.R;

public class ReclamationActivity extends AppCompatActivity {
    ImageView backBtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamation);
        backBtn = findViewById(R.id.imageViewCalendrier);


        backBtn.setOnClickListener(
                e ->{
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "main",Toast.LENGTH_SHORT).show();
                    finish();
                }
        );
    }
}