package com.example.akusehat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton logOutBtn;
    LinearLayout cardImunisasi, cardProfil, cardAbout, cardArtikel;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // view declaration
        logOutBtn = findViewById(R.id.logout_button);
        cardImunisasi = findViewById(R.id.card_imunisasi);
        cardProfil = findViewById(R.id.card_profil);
        cardAbout = findViewById(R.id.card_about);
        cardArtikel = findViewById(R.id.card_artikel);

        mAuth = FirebaseAuth.getInstance();

        //set onclicklistener on view
        logOutBtn.setOnClickListener(this);
        cardImunisasi.setOnClickListener(this);
        cardProfil.setOnClickListener(this);
        cardAbout.setOnClickListener(this);
        cardArtikel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.card_imunisasi:
                Intent goImunisasi = new Intent(this, DaftarImunisasiActivity.class);
                startActivity(goImunisasi);
                break;
            case R.id.card_about:
                Intent goAbout = new Intent(this, AboutActivity.class);
                startActivity(goAbout);
                break;
            case R.id.logout_button:
                mAuth.signOut();
                finish();
        }
    }
}