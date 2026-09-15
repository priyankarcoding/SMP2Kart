package com.example.smp2kart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Connect Java with XML
        setContentView(R.layout.activity_login);
        TextView tvSignup = findViewById(R.id.tvSignup);

        tvSignup.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginActivity.this,
                    SignupActivity.class
            );

            startActivity(intent);
        });

        // Connect XML components
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // Login button working
        btnLogin.setOnClickListener(v -> {

            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (email.isEmpty()) {
                etEmail.setError("Enter Email");
                etEmail.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                etPassword.setError("Enter Password");
                etPassword.requestFocus();
                return;
            }

            Toast.makeText(
                    LoginActivity.this,
                    "Login Successful",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}