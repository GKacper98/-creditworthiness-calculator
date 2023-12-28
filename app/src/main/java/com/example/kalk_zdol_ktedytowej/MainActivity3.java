package com.example.kalk_zdol_ktedytowej;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TooltipCompat;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {

    database g, db;
    Button b3;
    EditText edt1, edt2, edt3;
    ImageButton ib1, ib2, ib3, ib4;
    ImageButton iib1,iib2,iib3,iib4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main3);

        b3=findViewById(R.id.b3);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        ib1 = findViewById(R.id.ib1);
        ib2 = findViewById(R.id.ib2);
        ib3 = findViewById(R.id.ib3);
        ib4 = findViewById(R.id.ib4);
        iib1 = findViewById(R.id.iib1);
        iib2 = findViewById(R.id.iib2);
        iib3 = findViewById(R.id.iib3);
        iib4 = findViewById(R.id.iib4);

        ImageButton iib1 = findViewById(R.id.iib1);

        iib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Prosimy o podanie szacunkowej wartości nieruchomości," +
                        " którą planujesz kupić,wybudować lub zmodernizować. " +
                        "Ta informacja pomoże nam dopasować odpowiedni kredyt do Twoich potrzeb.";

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
                String message = "Prosimy o podanie ilości rat pożyczki w miesiącach." +
                        "Ta informacja pomoże nam dopasować odpowiedni kredyt do Twoich potrzeb.";

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
                String message = "Podaj dzień, który będzie dniem aktywności " +
                        "Twojego wyliczenia a nam pomoże to w utworzeniu dla Ciebie historii do poźniejszego wglądu.";

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
                String message = "Podaj jedno z możliwych czterech opcji przeznaczenia kredytu. \n" +
                        "Opcja 1: Kredyt na remont domu lub mieszkania\n" +
                        "Opcja 2: Kredyt na zakup domu lub mieszkania\n" +
                        "Opcja 3: Kredyt na budowę domu\n" +
                        "Opcja 4: Kredyt na zakup działki budowlanej\n" +
                        "Ta opcja pozwoli nam dostosować kredyt do twoich potrzeb";

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

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("pl", "PL"));
        String currentDate = dateFormat.format(calendar.getTime());
        edt3.setText(currentDate);

        edt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }

            private void showDatePickerDialog() {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity3.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                // Wybrana data zostanie ustawiona w edt3
                                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                                edt3.setText(selectedDate);
                            }
                        }, year, month, dayOfMonth);

                Locale.setDefault(new Locale("pl", "PL"));
                datePickerDialog.setTitle("Wybierz datę");

                datePickerDialog.show();
            }
        });



        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ib1.setSelected(true);
                ib2.setSelected(false);
                ib3.setSelected(false);
                ib4.setSelected(false);

                //ib1.setSelected(!ib1.isSelected());

            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ib1.setSelected(false);
                ib2.setSelected(true);
                ib3.setSelected(false);
                ib4.setSelected(false);

                //ib2.setSelected(!ib2.isSelected());

            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ib1.setSelected(false);
                ib2.setSelected(false);
                ib3.setSelected(true);
                ib4.setSelected(false);

                //ib3.setSelected(!ib3.isSelected());

            }
        });
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ib1.setSelected(false);
                ib2.setSelected(false);
                ib3.setSelected(false);
                ib4.setSelected(true);

                //ib4.setSelected(!ib4.isSelected());
            }
        });

        db=new database(this);
        g=new database(this);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String kwotaInput = edt1.getText().toString();
                String ratyInput = edt2.getText().toString();

                int kwota = 0;
                int raty = 0;

                if (!kwotaInput.isEmpty() && !ratyInput.isEmpty()) {
                    kwota = Integer.parseInt(kwotaInput);
                    raty = Integer.parseInt(ratyInput);

                    if (kwota == 0) {
                        Toast.makeText(MainActivity3.this, "Pole kwota nie może przyjmować wartości 0!", Toast.LENGTH_SHORT).show();
                    } else if (raty == 0) {
                        Toast.makeText(MainActivity3.this, "Pole ilość rat nie może przyjmować wartości 0!", Toast.LENGTH_SHORT).show();
                    } else {
                        String data = edt3.getText().toString();

                        String wybor = "";
                        if (ib1.isSelected()) {
                            wybor += "Kredyt na remont domu lub mieszkania";
                        }
                        if (ib2.isSelected()) {
                            wybor += "Kredyt na zakup domu lub mieszkania";
                        }
                        if (ib3.isSelected()) {
                            wybor += "Kredyt na budowę domu";
                        }
                        if (ib4.isSelected()) {
                            wybor += "Kredyt na zakup działki budowlanej";
                        }

                        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
                        String uzytkownicy_login = sharedPreferences.getString("login", "");

                        String id_id = sharedPreferences.getString("id", "");

                        boolean i = g.insert_data(wybor, kwota, raty, data, uzytkownicy_login, id_id);

                        if (i) {
                            Toast.makeText(MainActivity3.this, "Dobrze", Toast.LENGTH_SHORT).show();
                            String str = edt3.getText().toString();
                            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                            intent.putExtra("message_key", str);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity3.this, "Nie dobrze", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    if (kwotaInput.isEmpty()) {
                        Toast.makeText(MainActivity3.this, "Pole kwota kredytu nie może być puste!", Toast.LENGTH_SHORT).show();
                    }
                    if (ratyInput.isEmpty()) {
                        Toast.makeText(MainActivity3.this, "Pole ilość rat nie może być puste!", Toast.LENGTH_SHORT).show();
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