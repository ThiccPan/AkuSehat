package com.example.akusehat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UpdateVaksinActivity extends AppCompatActivity {
    TextView judulHalaman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_vaksin);

        judulHalaman = findViewById(R.id.readUmurAnak);
        judulHalaman.setText("Edit Data Imunisasi");
    }
}