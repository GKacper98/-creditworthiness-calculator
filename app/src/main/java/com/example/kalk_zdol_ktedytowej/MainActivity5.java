package com.example.kalk_zdol_ktedytowej;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class MainActivity5 extends AppCompatActivity implements ParseAdapter1.OnItemClickListener  {

    RecyclerView recyclerView;
    ArrayList<ParseItem1> parseItem11 = new ArrayList<>(); //tworze nową instancję obiektu ArrayList o nazwie parseItem11, który będzie przechowywać elementy typu ParseItem1.
    ParseAdapter1 adapter;
    database db;
    database k;
    TextView getdata;

    ImageButton iib1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        db = new database(this);
        k = new database(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ParseAdapter1(parseItem11, this); // tworze nową instancję obiektu ParseAdapter1 i przypisuje go do zmiennej adapter. Konstruktor ParseAdapter1 przyjmuje dwa argumenty: parseItem11 i this
        recyclerView.setAdapter(adapter);
        displaydata();

        adapter.setOnItemClickListener(this);

        getdata = findViewById(R.id.textView5);
        Intent intent = getIntent();
        int data2 = intent.getIntExtra("key", 0);
        getdata.setText(Integer.toString(data2) +" zł");

        iib1 = findViewById(R.id.iib1);
        iib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Kalkulator kredytowy umożliwia wyznaczenie orientacyjnej kwoty kredytu, " +
                        "którą możesz otrzymać, uwzględniając zalecenia organu nadzoru finansowego oraz dane, " +
                        "które wprowadzisz. Jednakże, dokładna ocena twojej zdolności kredytowej zależy wyłącznie od banku " +
                        "i jest wykonywana na podstawie przedstawionych dokumentów i niezbędnych informacji.";

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


    }

    private ArrayList<ModalContact5> displaydata() {
        ArrayList<ModalContact5> data5 = db.fetchData5();
        ArrayList<ModalContact2> data2 = k.fetchData2();

        if (data5.isEmpty()) {
            Toast.makeText(MainActivity5.this, "Nie ma danych do przeglądnięcia!", Toast.LENGTH_SHORT).show();
            return null;
        } else {
            for (int i = 0; i < data5.size(); i++) {
                ModalContact5 modalContact5 = data5.get(i);
                String id = modalContact5.id;
                String imgBanku = modalContact5.imgBanku;
                String RRSO = modalContact5.RRSO;
                String prowizja = modalContact5.prowizja;
                String oferta = modalContact5.oferta;
                String wklad = modalContact5.wklad;
                String marza = modalContact5.marza;

                String rata = "";
                String kwota = "";

                for (int j = 0; j < data2.size(); j++) {
                    ModalContact2 modalContact2 = data2.get(j);
                    int a = modalContact2.raty;
                    double b = Double.valueOf(a);
                    int c = modalContact2.kwota;
                    double d = Double.valueOf(c);

                    // (kwota * RRSO/12)* RRSO/12^raty / rrso/12 * rrso/12^b


                    rata = String.valueOf(Math.round(Double.valueOf(d) * (0.01 * Double.valueOf(RRSO) / 12) * Math.pow(1 + (0.01 * Double.valueOf(RRSO) / 12), Double.valueOf(b)) / (((1 + (0.01 * Double.valueOf(RRSO) / 12)) * Math.pow(1 + (0.01 * Double.valueOf(RRSO) / 12), Double.valueOf(b)) - 1))));
                    kwota = String.valueOf(Math.round(Double.valueOf(rata.replace("zł", "")) * Double.valueOf(b)));


                }

                parseItem11.add(new ParseItem1(id, imgBanku, RRSO +"%", prowizja + "%", oferta, wklad + "%", marza + "%", rata + " zł", kwota + " zł"));
                SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
                String uzytkownicy_login = sharedPreferences.getString("login", "");
                //String id_id = sharedPreferences.getString("id", "");
                String zatwierdz = "0";

                int id_id = db.getLastUsedId();

                k.insert_data5(imgBanku, RRSO, prowizja, oferta, wklad, marza, rata, kwota, uzytkownicy_login, String.valueOf(id_id), zatwierdz);

            }
        }
        return null;
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Nie możesz wrócić do poprzedniej aktywności, wybierz interesującą ofertę!", Toast.LENGTH_SHORT).show();
        // lub możesz użyć innego komponentu do wyświetlenia komunikatu, np. AlertDialog
    }

    @Override
    public void onItemClicked() {
        finishAffinity();
    }
}

