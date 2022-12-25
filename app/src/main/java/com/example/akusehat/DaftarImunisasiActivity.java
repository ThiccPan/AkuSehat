package com.example.akusehat;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DaftarImunisasiActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView backBtnImun;
    private SearchView searchBar;
    private RecyclerView rv;
    private rvVaksinAdapter rvAdapter;
    private FloatingActionButton fab;

    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    ArrayList<Imunisasi> imunisasiArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_imunisasi);

        backBtnImun = findViewById(R.id.backbutton_imunisasi);
        fab = findViewById(R.id.newImunisasiBtn);
        backBtnImun.setOnClickListener(this);
        fab.setOnClickListener(this);

        searchBar = findViewById(R.id.search_bar_imunisasi);
        searchBar.clearFocus();
        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return false;
            }
        });

        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("vaksin");

        rv = findViewById(R.id.rvListVaksin);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        rvAdapter = new rvVaksinAdapter(this);
        rv.setAdapter(rvAdapter);
        
        loadData();



    }

    private void filterList(String s) {
        ArrayList<Imunisasi> filteredListImun = new ArrayList<>();
        for (Imunisasi imunisasi : imunisasiArrayList) {
            if (imunisasi.getNamaAnak().toLowerCase().contains(s.toLowerCase())) {
                filteredListImun.add(imunisasi);
            }
        }
        if (filteredListImun.isEmpty()) {
            Toast.makeText(this, "data imunisasi tidak ditemukan",Toast.LENGTH_SHORT).show();
        } else {
            rvAdapter.setFilteredList(filteredListImun);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.newImunisasiBtn) {
            Intent intentNewImun = new Intent(this, InsertVaksinActivity.class);
            startActivity(intentNewImun);
        } else if (view.getId() == R.id.backbutton_imunisasi) {
            finish();
        }
    }

    private Query get() {
        return databaseReference
                .child(mAuth.getUid())
                .orderByKey();
    }

    private void loadData() {
        get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                imunisasiArrayList = new ArrayList<>();
                for (DataSnapshot data : snapshot.getChildren()) {
                    Imunisasi imunisasi = data.getValue(Imunisasi.class);
                    imunisasiArrayList.add(imunisasi);
                }
                rvAdapter.setItems(imunisasiArrayList);
                rvAdapter.notifyDataSetChanged();
                Log.d(TAG, "onDataChange: loaddata dipanggil");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}