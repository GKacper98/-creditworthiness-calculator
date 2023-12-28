package com.example.kalk_zdol_ktedytowej;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserHome extends AppCompatActivity {

    Button button10;
    Button button11;
    TextView textView31;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        textView31=findViewById(R.id.textView31);
        button10=findViewById(R.id.button10);
        button11=findViewById(R.id.button11);

        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String login = sharedPreferences.getString("login", "");


        textView31.setText("Witaj " +login +" sprawdź swoją historie,");

        //Sprawdź swoją historie,

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(UserHome.this,MainActivity6.class);
                startActivity(intent);
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(UserHome.this,MainActivity3.class);
                startActivity(intent);
            }
        });

    }
}