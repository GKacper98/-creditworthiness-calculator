package com.example.kalk_zdol_ktedytowej;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity6 extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<UserInfo> userInfos = new ArrayList<>();
    UserAdapter adapter;
    database db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        db = new database(this);
        recyclerView = findViewById(R.id.recyclerView4);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(userInfos, this);
        recyclerView.setAdapter(adapter);
        displaydata();


    }

    private ArrayList<ModalContact3> displaydata() {


        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String login = sharedPreferences.getString("login", "");


        ArrayList<ModalContact3> data3 = db.fetchData3(login);

        if(data3.isEmpty()){
            Toast.makeText(MainActivity6.this,"Nie ma danych do przeglądnięcia!", Toast.LENGTH_SHORT).show();
            return null;
        }else{
            for (int i = 0; i < data3.size(); i++) {
                ModalContact3 modalContact3 = data3.get(i);

                String id = modalContact3.id;
                String wybor = modalContact3.wybor;
                String kwota = modalContact3.kwota;
                String raty = modalContact3.raty;
                String data = modalContact3.data;
                String dochody = modalContact3.dochod;
                String osoby = modalContact3.osoby;
                String wydatki = modalContact3.wydatki;
                String raty2 = modalContact3.raty2;
                String zobowiazania = modalContact3.zobowiazania;
                String imageview3 = modalContact3.imageview3;
                String RRSO = modalContact3.RRSO;
                String wklad = modalContact3.wklad;
                String marza = modalContact3.marza;
                String prowizja = modalContact3.prowizja;
                String miesieczna = modalContact3.miesieczna;
                String kwota2 = modalContact3.kwota2;
                String zdolnosc = modalContact3.zdolnosc;

                userInfos.add(new UserInfo(id, wybor, kwota + " zł", raty + " mies.", data, dochody + " zł", osoby, wydatki + " zł", raty2 + " zł", zobowiazania + " zł", imageview3, RRSO + " %", wklad + " %", marza + " %", prowizja + " %", miesieczna + " zł", kwota2 + " zł", zdolnosc + " zł"));




                Log.d("items", " id" + id + " wybor: " + wybor + " kwota: " + kwota + ". raty: " + raty + " data: " + data+ ". dochody: " + dochody+ ". osoby: " + osoby+ ". raty2 : " + raty2 + ". wydatki: " + wydatki + ". zobowiazania: " + zobowiazania+ ". rrso: " + RRSO);
            }}

        return null;
    }

}



