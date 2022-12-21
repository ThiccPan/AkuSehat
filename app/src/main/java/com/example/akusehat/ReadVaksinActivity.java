package com.example.akusehat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ReadVaksinActivity extends AppCompatActivity {
    Imunisasi currImunisasi;
    TextView namaAnakTV, umurAnakTV, tanggalLahirTV, jenisVaksinTV, tanggalVaksinTV, vaksinKeTV;
    ImageView previewImunisasiIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_vaksin);

        namaAnakTV = findViewById(R.id.readNamaAnak);
        umurAnakTV = findViewById(R.id.readUmurAnak);
        tanggalLahirTV = findViewById(R.id.valueTanggalLahir);
        jenisVaksinTV = findViewById(R.id.valueJenisVaksin);
        tanggalVaksinTV = findViewById(R.id.valueTanggalVaksin);
        vaksinKeTV = findViewById(R.id.valueVaksinKe);

        currImunisasi = getIntent().getParcelableExtra("data_imunisasi");

        namaAnakTV.setText(currImunisasi.getNamaAnak());
    }
}