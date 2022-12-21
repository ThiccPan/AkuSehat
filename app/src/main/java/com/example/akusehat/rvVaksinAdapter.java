package com.example.akusehat;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rvVaksinAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    ArrayList<Imunisasi> imunisasiList = new ArrayList<>();

    public rvVaksinAdapter(Context context) {
        this.context = context;
    }

    public void setItems(ArrayList<Imunisasi> imunisasiList) {
        this.imunisasiList = imunisasiList;
    }

    public static class ImunisasiVH extends RecyclerView.ViewHolder {
        TextView namaVaksin;
        TextView namaAnak;
        TextView waktuVaksin;
        ConstraintLayout cardVaksin;
        public ImunisasiVH(@NonNull View itemView) {
            super(itemView);
            this.namaVaksin = itemView.findViewById(R.id.nama_vaksin_card);
            this.namaAnak = itemView.findViewById(R.id.nama_anak_card);
            this.waktuVaksin = itemView.findViewById(R.id.waktu_vaksin_card);
            this.cardVaksin = itemView.findViewById(R.id.layout_imunisasi);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(this.context)
                .inflate(R.layout.layout_imunisasi,parent,false);
        return new ImunisasiVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImunisasiVH imunisasiVH = (ImunisasiVH) holder;
        Imunisasi currImunisasi = imunisasiList.get(position);
        imunisasiVH.namaVaksin.setText(currImunisasi.getJenisVaksin());
        imunisasiVH.namaAnak.setText(currImunisasi.getNamaAnak());
        String tanggalVaksin = currImunisasi.getHariVaksin() + "/" + currImunisasi.getBulanVaksin() + "/"
                + currImunisasi.getTahunVaksin();
        imunisasiVH.waktuVaksin.setText(tanggalVaksin);

        imunisasiVH.cardVaksin.setOnClickListener(view -> {
            Intent goEdit = new Intent(this.context, ReadVaksinActivity.class);
            goEdit.putExtra("data_imunisasi",currImunisasi);
            this.context.startActivity(goEdit);
        });

    }

    @Override
    public int getItemCount() {
        return imunisasiList.size();
    }
}
