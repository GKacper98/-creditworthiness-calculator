package com.example.kalk_zdol_ktedytowej;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.kalk_zdol_ktedytowej.databinding.ActivityLogowanieBinding;

public class LogowanieActivity extends AppCompatActivity {


    ActivityLogowanieBinding binding;
    database o;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityLogowanieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        o = new database(this);
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String login = binding.loginLogin.getText().toString();
                String haslo = binding.loginPassword.getText().toString();
                if(login.equals("")||haslo.equals(""))
                    Toast.makeText(LogowanieActivity.this, "Wszystkie pola są obowiązkowe!", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkCredentials = o.checkLoginPassword(login, haslo);
                    Boolean isAdmin = o.checkAdminStatus(login);

                    if (checkCredentials && isAdmin) {
                        // Zalogowano jako administrator
                        Intent intent = new Intent(getApplicationContext(), PanelAdmin.class);
                        startActivity(intent);
                    } else if (checkCredentials) {
                        // Zalogowano jako zwykły użytkownik
                        Toast.makeText(LogowanieActivity.this, "Logowanie udane!", Toast.LENGTH_SHORT).show();

                        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("login", login);
                        editor.apply();

                        Intent intent = new Intent(getApplicationContext(), UserHome.class);
                        startActivity(intent);
                    } else {
                        // Niepoprawne dane logowania
                        Toast.makeText(LogowanieActivity.this, "Nieprawidłowe dane uwierzytelniające!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        binding.signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogowanieActivity.this, RejestracjaActivity.class);
                startActivity(intent);
            }
        });
    }
}