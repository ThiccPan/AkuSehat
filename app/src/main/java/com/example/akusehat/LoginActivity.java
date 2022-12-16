package com.example.akusehat;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth mAuth;
    private EditText email, password;
    private Button masuk;
    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        masuk = findViewById(R.id.masuk);
        register = findViewById(R.id.register);
        mAuth = FirebaseAuth.getInstance();
        masuk.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.masuk:
                login();
                break;
            case R.id.register:
                register();
                break;
            default:
                break;
        }
    }

    private void register() {
        Intent registerIntent = new Intent(this, RegisterActivity.class);
        startActivity(registerIntent);
    }

    private void login() {
        String emailInput = email.getText().toString();
        String passwordInput = password.getText().toString();
        mAuth.signInWithEmailAndPassword(emailInput,passwordInput)
                .addOnSuccessListener(authResult -> {
                    Log.d(TAG, "login: Successfull");
                    nextActivity(true, "Login berhasil!");
                })
                .addOnFailureListener(authResult -> {
                    Log.d(TAG, "login: failed");
                    nextActivity(false, "Login gagal, pastikan email dan password benar!");
                });
    }

    private void nextActivity(boolean isSuccess, String message) {
        Toast.makeText(LoginActivity.this,message, Toast.LENGTH_SHORT).show();
        if (isSuccess) {
            Intent intent = new Intent(this, InsertVaksinActivity.class);
            startActivity(intent);
        }
    }
}