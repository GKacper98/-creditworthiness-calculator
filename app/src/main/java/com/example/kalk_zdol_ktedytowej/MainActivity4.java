package com.example.kalk_zdol_ktedytowej;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {



    database k, db;
    Button b4;
    EditText edt4,edt5,edt6,edt7,edt8;
    ImageButton iib1,iib2,iib3,iib4, iib5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main4);

        b4=findViewById(R.id.b4);
        edt4 = findViewById(R.id.edt4);
        edt5 = findViewById(R.id.edt5);
        edt6 = findViewById(R.id.edt6);
        edt7 = findViewById(R.id.edt7);
        edt8 = findViewById(R.id.edt8);

        iib1 = findViewById(R.id.iib1);
        iib2 = findViewById(R.id.iib2);
        iib3 = findViewById(R.id.iib3);
        iib4 = findViewById(R.id.iib4);
        iib5 = findViewById(R.id.iib5);


        iib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Podaj miesięczne dochody (na rękę). Posiadanie tej informacji umożliwi wstępną ocenę Twojej zdolności kredytowej." +
                        " Banki uwzględniając poziom wynagrodzenia, określają maksymalną kwotę udzielanego kredytu przygotowując oferty kredytowe dla klientów.";

                TextView textView = new TextView(getApplicationContext());
                textView.setTextColor(Color.WHITE);
                textView.setText(message);
                textView.setPadding(40, 20, 20, 20);

                PopupWindow popupWindow = new PopupWindow(textView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setFocusable(true);

                Drawable backgroundDrawable = getResources().getDrawable(R.drawable.dymek_szary);
                popupWindow.setBackgroundDrawable(backgroundDrawable);
                popupWindow.showAsDropDown(iib1);
            }
        });

        ImageButton iib2 = findViewById(R.id.iib2);
        iib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Podaj liczbę osób na utrzymaniu, wliczając siebie. Ma to wpływ na Twoją zdolność kredytową. Wyższe koszty utrzymania członków rodziny " +
                        "lub innych osób negatywnie wpływają na dostępne środki dla przyszłego kredytobiorcy, co oznacza mniejszą możliwość spłaty raty kredytowej.";

                TextView textView = new TextView(getApplicationContext());
                textView.setTextColor(Color.WHITE);
                textView.setText(message);
                textView.setPadding(40, 20, 20, 20);

                PopupWindow popupWindow = new PopupWindow(textView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setFocusable(true);

                Drawable backgroundDrawable = getResources().getDrawable(R.drawable.dymek_szary);
                popupWindow.setBackgroundDrawable(backgroundDrawable);
                popupWindow.showAsDropDown(iib2);
            }
        });

        ImageButton iib3 = findViewById(R.id.iib3);
        iib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Podaj sumę miesięcznych wydatków w Twoim gospodarstwie domowym, takich jak czynsz/najem, rachunki za prąd, gaz i telewizję." +
                        "Ma to duży wpływ na Twoją zdolność kredytową." +
                        "Wyższe koszty funkcjonowania gospodarstwa domowego negatywnie wpływają na dostępne środki dla przyszłego kredytobiorcy," +
                        "co oznacza mniejszą możliwość spłaty raty kredytowej.";

                TextView textView = new TextView(getApplicationContext());
                textView.setTextColor(Color.WHITE);
                textView.setText(message);
                textView.setPadding(40, 20, 20, 20);

                PopupWindow popupWindow = new PopupWindow(textView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setFocusable(true);

                Drawable backgroundDrawable = getResources().getDrawable(R.drawable.dymek_szary);
                popupWindow.setBackgroundDrawable(backgroundDrawable);
                popupWindow.showAsDropDown(iib3);
            }
        });

        ImageButton iib4 = findViewById(R.id.iib4);
        iib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Podaj obecne spłacane raty kredytów (np. kredyt gotówkowy, samochodowy, ratalny, hipoteczny). " +
                        "To informacja jest ważna dla Twojej zdolności kredytowej. Zbyt duże obciążenie budżetu domowego przez już istniejące raty " +
                        "kredytowe może negatywnie wpływać na możliwość uzyskania kolejnego kredytu.";

                TextView textView = new TextView(getApplicationContext());
                textView.setTextColor(Color.WHITE);
                textView.setText(message);
                textView.setPadding(40, 20, 20, 20);

                PopupWindow popupWindow = new PopupWindow(textView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setFocusable(true);

                Drawable backgroundDrawable = getResources().getDrawable(R.drawable.dymek_szary);
                popupWindow.setBackgroundDrawable(backgroundDrawable);
                popupWindow.showAsDropDown(iib4);
            }
        });

        ImageButton iib5 = findViewById(R.id.iib5);
        iib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Podaj inne zobowiązania (alimenty, pożyczki chwilówki, długi konsumenckie itp.) " +
                        "Ta informacja jest ważna dla Twojej zdolności kredytowej.Zbyt duże obciążenie budżetu domowego przez już istniejące zobowiązania" +
                        "kredytowe może negatywnie wpływać na możliwość uzyskania kolejnego kredytu.";

                TextView textView = new TextView(getApplicationContext());
                textView.setTextColor(Color.WHITE);
                textView.setText(message);
                textView.setPadding(40, 20, 20, 20);

                PopupWindow popupWindow = new PopupWindow(textView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setFocusable(true);

                Drawable backgroundDrawable = getResources().getDrawable(R.drawable.dymek_szary);
                popupWindow.setBackgroundDrawable(backgroundDrawable);
                popupWindow.showAsDropDown(iib5);
            }
        });


        db=new database(this);
        k=new database(this);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dochodInput = edt4.getText().toString();
                String osobyInput = edt5.getText().toString();
                String wydatkiInput = edt6.getText().toString();
                String raty2Input = edt7.getText().toString();
                String zobowiazaniaInput = edt8.getText().toString();

                int dochod = 0;
                int osoby = 0;
                int wydatki = 0;
                int raty2 = 0;
                int zobowiazania = 0;

                if (!dochodInput.isEmpty() && !osobyInput.isEmpty() && !wydatkiInput.isEmpty() && !raty2Input.isEmpty() && !zobowiazaniaInput.isEmpty()) {
                    dochod = Integer.parseInt(dochodInput);
                    osoby = Integer.parseInt(osobyInput);
                    wydatki = Integer.parseInt(wydatkiInput);
                    raty2 = Integer.parseInt(raty2Input);
                    zobowiazania = Integer.parseInt(zobowiazaniaInput);

                    if (dochod == 0) {
                        Toast.makeText(MainActivity4.this, "Pole łączny dochód nie może przyjmować wartości 0!", Toast.LENGTH_SHORT).show();
                    } else if (osoby == 0) {
                        Toast.makeText(MainActivity4.this, "Pole ilość osób nie może przyjmować wartości 0!", Toast.LENGTH_SHORT).show();
                    } else if (wydatki == 0) {
                        Toast.makeText(MainActivity4.this, "Pole miesięczne wydatki nie może przyjmować wartości 0!", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!raty2Input.isEmpty()) {
                            raty2 = Integer.parseInt(raty2Input);
                        }
                        if (!zobowiazaniaInput.isEmpty()) {
                            zobowiazania = Integer.parseInt(zobowiazaniaInput);
                        }

                        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
                        String uzytkownicy_login = sharedPreferences.getString("login", "");
                        String id_id = sharedPreferences.getString("id", "");

                        int asd = (((dochod - wydatki - raty2 - zobowiazania) / 2) / osoby);


                        ArrayList<ModalContact2> data3 = k.fetchData2();
                        int zdolnosc = 0;

                        for (int x = 0; x < data3.size(); x++)
                            zdolnosc = asd * data3.get(x).raty;

                        boolean i = k.insert_data2(dochod, osoby, wydatki, raty2, zobowiazania, zdolnosc, uzytkownicy_login, id_id);
                        if (i) {
                            Toast.makeText(MainActivity4.this, "Dobrze", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                            intent.putExtra("id_id", id_id);
                            ArrayList<ModalContact> data2 = k.fetchData();
                            for (int j = 0; j < data2.size(); j++)
                                    intent.putExtra("key", data2.get(j).zdolnosc);

                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity4.this, "Nie dobrze", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    if (dochodInput.isEmpty()) {
                        Toast.makeText(MainActivity4.this, "Pole łączny dochód nie może być puste", Toast.LENGTH_SHORT).show();
                    }
                    if (osobyInput.isEmpty()) {
                        Toast.makeText(MainActivity4.this, "Pole ilość osóby nie może być puste", Toast.LENGTH_SHORT).show();
                    }
                    if (wydatkiInput.isEmpty()) {
                        Toast.makeText(MainActivity4.this, "Pole miesięczne wydatki nie może być puste", Toast.LENGTH_SHORT).show();
                    }
                    if (raty2Input.isEmpty()) {
                        Toast.makeText(MainActivity4.this, "Pole obecne raty nie może być puste", Toast.LENGTH_SHORT).show();
                    }
                    if (zobowiazaniaInput.isEmpty()) {
                        Toast.makeText(MainActivity4.this, "Pole inne zobowiązania nie może być puste", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Nie możesz wrócić do poprzedniej aktywności, uzupełnij formularz!", Toast.LENGTH_SHORT).show();
        // lub możesz użyć innego komponentu do wyświetlenia komunikatu, np. AlertDialog
    }
}