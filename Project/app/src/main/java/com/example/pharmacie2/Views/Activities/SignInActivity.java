package com.example.pharmacie2.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pharmacie2.Data.Dao.UserDao;
import com.example.pharmacie2.Data.Database.PharmacyDB;
import com.example.pharmacie2.Data.Entities.User;
import com.example.pharmacie2.R;

public class SignInActivity extends AppCompatActivity {
    Button signInBtn;
    TextView createaccount ;

    private EditText editTextEmail;
    private EditText editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signInBtn = findViewById(R.id.buttonSignIn);
        createaccount = findViewById(R.id.createaccount);


        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        signInBtn.setOnClickListener(v -> {
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            new AuthenticateUserTask().execute(email, password);



        });
        createaccount.setOnClickListener(
                e -> {
                    Intent intent = new Intent(this, SignUpActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(this, "Welcome",Toast.LENGTH_SHORT).show();
                }
        );



    }

    private class AuthenticateUserTask extends AsyncTask<String, Void, User> {
        @Override
        protected User doInBackground(String... params) {
            String email = params[0];
            String password = params[1];
            return PharmacyDB.getInstance(getApplicationContext()).userDao().getUserByEmailAndPassword(email, password);
        }

        @Override
        protected void onPostExecute(User user) {
            if (user != null) {
                Toast.makeText(SignInActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                // User exists, proceed to MainActivity
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(SignInActivity.this, "User not found. Please check your email and password.", Toast.LENGTH_SHORT).show();
                // User not found, do not proceed to MainActivity
            }
        }

    }

}