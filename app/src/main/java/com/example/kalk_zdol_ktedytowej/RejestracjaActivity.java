package com.example.kalk_zdol_ktedytowej;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.kalk_zdol_ktedytowej.databinding.ActivityRejestracjaBinding;

public class RejestracjaActivity extends AppCompatActivity {


    ActivityRejestracjaBinding binding;
    database o;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRejestracjaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        o = new database(this);
        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = binding.signupLogin.getText().toString();
                String haslo = binding.signupPassword.getText().toString();
                String potwierdzHaslo = binding.signupConfirm.getText().toString();
                if(login.equals("")||haslo.equals("")||potwierdzHaslo.equals(""))
                    Toast.makeText(RejestracjaActivity.this, "Wszystkie pola są obowiązkowe!", Toast.LENGTH_SHORT).show();
                else{
                    if(haslo.equals(potwierdzHaslo)){
                        Boolean checkUserLogin = o.checkLogin(login);
                        if(checkUserLogin == false){
                            Boolean insert = o.insert_data3(login, haslo);
                            if(insert == true){
                                Toast.makeText(RejestracjaActivity.this, "Rejestracja udana!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LogowanieActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RejestracjaActivity.this, "Rejestracja nieudana!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(RejestracjaActivity.this, "Użytkownik istnieje, prosze o zalogowanie się!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RejestracjaActivity.this, "Niepoprawne haslo!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RejestracjaActivity.this, LogowanieActivity.class);
                startActivity(intent);
            }
        });
    }
}