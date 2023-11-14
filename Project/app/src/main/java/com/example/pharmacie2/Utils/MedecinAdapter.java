package com.example.pharmacie2.Utils;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmacie2.Data.Entities.Medecin;
import com.example.pharmacie2.R;

import java.util.List;

public class MedecinAdapter extends RecyclerView.Adapter<MedecinAdapter.MedecinHolderView>{
    private List<Medecin> medecinList;
    private MedecinAdapter.OnDeleteClickListener onDeleteClickListener;
    public interface OnDeleteClickListener {
        void onDeleteClick(Medecin medecin);
    }
    public MedecinAdapter(List<Medecin> medecinList, MedecinAdapter.OnDeleteClickListener onDeleteClickListener) {
        this.medecinList = medecinList;
        this.onDeleteClickListener = onDeleteClickListener;


    }

    @NonNull
    @Override
    public MedecinAdapter.MedecinHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medecin_item, parent, false);
        return new MedecinAdapter.MedecinHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedecinHolderView holder, int position) {
        Medecin medecin  = medecinList.get(position);
        holder.textViewNomMedecin.setText(Html.fromHtml("<b>" + medecin.getNom() + "</b>"));

        holder.buttonDelete.setTag(medecin);
        holder.buttonDelete.setOnClickListener(view -> {
            // Retrieve the user from the tag
            Medecin medecinToDelete = (Medecin) view.getTag();
            onDeleteClickListener.onDeleteClick(medecinToDelete);
        });

    }



    @Override
    public int getItemCount() {
        return medecinList.size();
    }

    public class MedecinHolderView extends RecyclerView.ViewHolder {
        TextView textViewNomMedecin;
        TextView textViewNumeroMedecin;
        ImageButton buttonDelete;

        public MedecinHolderView(@NonNull View itemView) {
            super(itemView);
            textViewNomMedecin = itemView.findViewById(R.id.textViewNom);
            textViewNumeroMedecin = itemView.findViewById(R.id.textViewNum);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }

    // Add a method to update the list in the adapter
    public void updateList(List<Medecin> newList) {
        medecinList = newList;
        notifyDataSetChanged();
    }
}
