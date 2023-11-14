package com.example.pharmacie2.Utils;

import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmacie2.Data.Entities.User;
import com.example.pharmacie2.R;
import com.example.pharmacie2.Views.Activities.UpdateUserActivity;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList;
    private OnDeleteClickListener onDeleteClickListener;

    public interface OnDeleteClickListener {
        void onDeleteClick(User user);
    }



    public UserAdapter(List<User> userList, OnDeleteClickListener onDeleteClickListener) {
        this.userList = userList;
        this.onDeleteClickListener = onDeleteClickListener;


    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.textViewName.setText(Html.fromHtml("<b>" + user.getEmail() + "</b>"));

        // Set the user as a tag for the update button
        holder.buttonUpdate.setTag(user);

        // Set onClickListener for the update button
        holder.buttonUpdate.setOnClickListener(view -> {
            User userToUpdate = (User) view.getTag();

            // Start the UpdateUserActivity with the user information
            Intent intent = new Intent(view.getContext(), UpdateUserActivity.class);
            intent.putExtra("userId", userToUpdate.getId());
            intent.putExtra("userEmail", userToUpdate.getEmail());
            intent.putExtra("userName", userToUpdate.getName());
            intent.putExtra("userPassword", userToUpdate.getPassword());
            view.getContext().startActivity(intent);
        });

        // Set the user as a tag for the delete button
        holder.buttonDelete.setTag(user);

        // Set onClickListener for the delete button
        holder.buttonDelete.setOnClickListener(view -> {
            User userToDelete = (User) view.getTag();
            onDeleteClickListener.onDeleteClick(userToDelete);
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        ImageButton buttonDelete;

        ImageButton buttonUpdate;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
            buttonUpdate = itemView.findViewById(R.id.buttonUpdate);
        }
    }

    // Add a method to update the list in the adapter
    public void updateList(List<User> newList) {
        userList = newList;
        notifyDataSetChanged();
    }
}


