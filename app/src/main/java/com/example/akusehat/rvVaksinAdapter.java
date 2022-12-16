package com.example.akusehat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rvVaksinAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    ArrayList<Imunisasi> imunisasiList = new ArrayList<>();

    public rvVaksinAdapter(Context context) {
        this.context = context;
    }

    public static class imunisasiVH extends RecyclerView.ViewHolder {

        public imunisasiVH(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(this.context)
                .inflate()
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
