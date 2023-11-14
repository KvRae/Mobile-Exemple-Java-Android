package com.example.pharmacie2.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pharmacie2.Data.Database.PharmacyDB;
import com.example.pharmacie2.Data.Entities.User;
import com.example.pharmacie2.R;
import com.example.pharmacie2.Utils.UserAdapter;

import java.util.List;

public class UsersActivity extends AppCompatActivity implements UserAdapter.OnDeleteClickListener {

    ImageView backBtn;
    PharmacyDB db;
    private RecyclerView recyclerViewUsers;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        db = PharmacyDB.getInstance(this);
        backBtn = findViewById(R.id.imageViewCalendrier);
        recyclerViewUsers = findViewById(R.id.recyclerView);  // Change this line
        recyclerViewUsers.setLayoutManager(new LinearLayoutManager(this));
        new LoadUsersTask(recyclerViewUsers).execute();

        backBtn.setOnClickListener(
                e -> {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "main", Toast.LENGTH_SHORT).show();
                    finish();
                }
        );
    }

    @Override
    public void onDeleteClick(User user) {
        new DeleteUserTask().execute(user);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private class LoadUsersTask extends AsyncTask<Void, Void, List<User>> {
        private RecyclerView recyclerView;

        public LoadUsersTask(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
        }


        @Override
        protected List<User> doInBackground(Void... voids) {
            return db.userDao().getAllUsers();
        }


        @Override
        protected void onPostExecute(List<User> userList) {

            userAdapter = new UserAdapter(userList, UsersActivity.this);
            recyclerView.setAdapter(userAdapter);
        }
    }


    // Method to handle delete button click


    private class DeleteUserTask extends AsyncTask<User, Void, Void> {
        @Override
        protected Void doInBackground(User... users) {
            // Perform delete operation on a background thread
            db.userDao().delete(users[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            // After deletion, reload the users
            new LoadUsersTask(recyclerViewUsers).execute();
        }
    }





}