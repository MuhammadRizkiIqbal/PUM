package com.example.pum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPassword, etPasswordConf;
    private Button btnRegister, btnLogin;

    private DatabaseReference database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inisialisasi elemen UI
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.password);
        etPasswordConf = findViewById(R.id.PasswordConf);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);

        // Inisialisasi referensi database Firebase
        database = FirebaseDatabase.getInstance().getReference("users");

        // Menangani tombol Register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = etName.getText().toString();
                String Email = etEmail.getText().toString();
                String Password = etPassword.getText().toString();
                String PasswordConf = etPasswordConf.getText().toString();

                if (Name.isEmpty() || Email.isEmpty() || Password.isEmpty() || PasswordConf.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ada Data Yang Masih Kosong!!", Toast.LENGTH_SHORT).show();
                } else {
                    // Simpan data ke Firebase
                    database.child(Name).child("Name").setValue(Name);
                    database.child(Name).child("Email").setValue(Email);
                    database.child(Name).child("Password").setValue(Password);
                    database.child(Name).child("PasswordConf").setValue(PasswordConf);

                    Toast.makeText(getApplicationContext(), "Register Berhasil!!", Toast.LENGTH_SHORT).show();

                    // Navigasi ke halaman login
                    Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                    finish();  // Sebaiknya panggil finish() untuk menutup RegisterActivity setelah pindah ke LoginActivity
                }
            }
        });

        // Menangani tombol Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lakukan tindakan login (misalnya, navigasi ke halaman login)
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}
