package com.example.akusehat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText email, password;
    private Button daftar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        daftar = findViewById(R.id.daftar);
        mAuth = FirebaseAuth.getInstance();
        daftar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.daftar) {
            daftar();
        } else {
            throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    private void daftar() {
        String emailInput = email.getText().toString();
        String passwordInput = password.getText().toString();
        mAuth.createUserWithEmailAndPassword(emailInput, passwordInput)
                .addOnSuccessListener(authResult -> {
                    nextActivity(true, "Daftar akun berhasil!");
                })
                .addOnFailureListener(authResult -> {
                    nextActivity(false, "Daftar akun gagal, coba lagi!");
                });
    }

    private void nextActivity(boolean isSuccess, String message) {
        Toast.makeText(RegisterActivity.this,message, Toast.LENGTH_SHORT).show();
        if (isSuccess) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
    }
}