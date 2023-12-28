package com.example.kalk_zdol_ktedytowej;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class PanelAdmin_Users extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ParseItem2> parseItem22 = new ArrayList<>();
    ParseAdapter2 adapter;
    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_admin_users);


        db = new database(this);
        recyclerView = findViewById(R.id.recyclerView5);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ParseAdapter2(parseItem22, this);
        recyclerView.setAdapter(adapter);

        displaydata();


    }
    private ArrayList<ModalContact4> displaydata() {

        ArrayList<ModalContact4> data4 = db.fetchData4();

        if(data4.isEmpty()){
            Toast.makeText(PanelAdmin_Users.this,"Nie ma danych do przeglądnięcia!", Toast.LENGTH_SHORT).show();
            return null;
        }else{
            for (int i = 0; i < data4.size(); i++) {
                ModalContact4 modalContact4 = data4.get(i);


                String login = modalContact4.login;

                String haslo = modalContact4.haslo;

                parseItem22.add(new ParseItem2(login, haslo));

                Log.d("items", " login" + login + " haslo: " + haslo );
            }}
        return null;
    }
}