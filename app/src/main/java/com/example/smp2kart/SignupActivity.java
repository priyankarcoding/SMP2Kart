package com.example.smp2kart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText etName;
    EditText etEmail;
    EditText etPassword;
    EditText etConfirmPassword;

    Button btnSignup;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        // Connect XML components
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        btnSignup = findViewById(R.id.btnSignup);
        tvLogin = findViewById(R.id.tvLogin);


        // Sign Up Button
        btnSignup.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String confirmPassword =
                    etConfirmPassword.getText().toString().trim();


            // Check Name
            if (name.isEmpty()) {

                etName.setError("Enter your name");
                etName.requestFocus();

                return;
            }


            // Check Email
            if (email.isEmpty()) {

                etEmail.setError("Enter your email");
                etEmail.requestFocus();

                return;
            }


            // Check Password
            if (password.isEmpty()) {

                etPassword.setError("Enter password");
                etPassword.requestFocus();

                return;
            }


            // Password length
            if (password.length() < 6) {

                etPassword.setError(
                        "Password must be at least 6 characters"
                );

                etPassword.requestFocus();

                return;
            }


            // Check Confirm Password
            if (confirmPassword.isEmpty()) {

                etConfirmPassword.setError(
                        "Confirm your password"
                );

                etConfirmPassword.requestFocus();

                return;
            }


            // Check passwords match
            if (!password.equals(confirmPassword)) {

                etConfirmPassword.setError(
                        "Passwords do not match"
                );

                etConfirmPassword.requestFocus();

                return;
            }


            // Success
            Toast.makeText(
                    SignupActivity.this,
                    "Account Created Successfully",
                    Toast.LENGTH_SHORT
            ).show();


            // Go to Login
            Intent intent = new Intent(
                    SignupActivity.this,
                    LoginActivity.class
            );

            startActivity(intent);

            finish();
        });


        // Login Button
        tvLogin.setOnClickListener(v -> {

            Intent intent = new Intent(
                    SignupActivity.this,
                    LoginActivity.class
            );

            startActivity(intent);

            finish();
        });
    }
}