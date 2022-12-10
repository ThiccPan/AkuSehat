package com.example.akusehat;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class InsertVaksinActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    EditText namaAnak, umurAnak, tanggalLahir, tanggalVaksin;
    Button simpanVaksin, batalVaksin;
    ImageButton gambarVaksin;
    String jenisVaksin = "kosong";
    int vaksinKe = 0;

    // firebase component
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_vaksin);

        // form and button init
        namaAnak = findViewById(R.id.namaAnak);
        umurAnak = findViewById(R.id.umurAnak);
        tanggalLahir = findViewById(R.id.tanggalLahir);
        tanggalVaksin = findViewById(R.id.tanggalVaksin);
        simpanVaksin = findViewById(R.id.simpanVaksin);
        batalVaksin = findViewById(R.id.batalVaksin);
        gambarVaksin = findViewById(R.id.gambarVaksin);

        // jenisVaksin spinner init
        Spinner spinnerVaksin = (Spinner) findViewById(R.id.jenisVaksin);
        ArrayAdapter<CharSequence> adapterJenis = ArrayAdapter.createFromResource(this,
                R.array.jenis_vaksin, android.R.layout.simple_spinner_item);
        adapterJenis.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVaksin.setAdapter(adapterJenis);

        // vaksinKe spinner init
        Spinner spinnerJumlahVaksin = (Spinner) findViewById(R.id.vaksinKe);
        ArrayAdapter<CharSequence> adapterJumlah = ArrayAdapter.createFromResource(this,
                R.array.vaksin_ke, android.R.layout.simple_spinner_item);
        adapterJumlah.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJumlahVaksin.setAdapter(adapterJumlah);

        // firebase component init
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("vaksin");

        simpanVaksin.setOnClickListener(this);
        batalVaksin.setOnClickListener(this);
        tanggalLahir.setOnClickListener(this);
        tanggalVaksin.setOnClickListener(this);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int id = adapterView.getId();
        if (id == R.id.jenisVaksin) {
            jenisVaksin = adapterView.getItemAtPosition(i).toString();
            Log.d(TAG, "onItemSelected: " + jenisVaksin);
        } else if (id == R.id.vaksinKe) {
            vaksinKe = Integer.parseInt(adapterView.getItemAtPosition(i).toString());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.simpanVaksin) {
            uploadData();
        } else if (view.getId() == R.id.batalVaksin) {
            clearData();
        } else if (view.getId() == R.id.tanggalLahir) {
            showDatePicker(R.id.tanggalLahir);
        } else if (view.getId() == R.id.tanggalVaksin) {
            showDatePicker(R.id.tanggalVaksin);
        }
    }

    private void showDatePicker(int viewId) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(InsertVaksinActivity.this,
                (datePicker, year, month, dayOfMonth) -> {
            month += 1;
            String date = dayOfMonth+"/"+month+"/"+year;
            if (viewId == R.id.tanggalLahir) {
                tanggalLahir.setText(date);
            } else if (viewId == R.id.tanggalVaksin) {
                tanggalVaksin.setText(date);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void uploadData() {

    }

    private void clearData() {

    }
}