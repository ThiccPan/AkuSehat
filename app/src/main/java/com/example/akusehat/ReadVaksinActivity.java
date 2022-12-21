package com.example.akusehat;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ReadVaksinActivity extends AppCompatActivity implements View.OnClickListener {
    Imunisasi currImunisasi;
    TextView namaAnakTV, umurAnakTV, tanggalLahirTV, jenisVaksinTV, tanggalVaksinTV, vaksinKeTV;
    ImageView previewImunisasiIV;
    Button editBtn, hapusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_vaksin);

        // form var initialization
        namaAnakTV = findViewById(R.id.readNamaAnak);
        umurAnakTV = findViewById(R.id.readUmurAnak);
        tanggalLahirTV = findViewById(R.id.valueTanggalLahir);
        jenisVaksinTV = findViewById(R.id.valueJenisVaksin);
        tanggalVaksinTV = findViewById(R.id.valueTanggalVaksin);
        vaksinKeTV = findViewById(R.id.valVaksinKe);

        // form btn initialization
        editBtn = findViewById(R.id.editVaksinBtn);
        hapusBtn = findViewById(R.id.hapusVaksinBtn);
        editBtn.setOnClickListener(this);
        hapusBtn.setOnClickListener(this);

        currImunisasi = getIntent().getParcelableExtra("data_imunisasi");

        namaAnakTV.setText(currImunisasi.getNamaAnak());
        umurAnakTV.setText(currImunisasi.getUmur() + " tahun");
        tanggalLahirTV.setText(currImunisasi.getHariLahir() + "/" + currImunisasi.getBulanLahir()
            + "/" + currImunisasi.getTahunLahir());
        jenisVaksinTV.setText(currImunisasi.getJenisVaksin());
        tanggalVaksinTV.setText(currImunisasi.getHariVaksin() + "/" + currImunisasi.getBulanVaksin()
                + "/" + currImunisasi.getTahunVaksin());
        Log.d(TAG, "onCreate: "+currImunisasi.getBulanVaksin());
        vaksinKeTV.setText(String.valueOf(currImunisasi.getVaksinKe()));


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.editVaksinBtn) {
            Intent intent = new Intent(this, InsertVaksinActivity.class);
            intent.putExtra("data_imunisasi",currImunisasi);
            startActivity(intent);
        } else if (view.getId() == R.id.hapusVaksinBtn) {
            hapusData();
        }
    }

    private void hapusData() {
    }
}