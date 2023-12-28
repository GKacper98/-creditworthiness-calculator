package com.example.kalk_zdol_ktedytowej;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PanelAdmin_Delete extends AppCompatActivity {

    database db;
    EditText edt2;
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_admin_delete);

        edt2= findViewById(R.id.edt2);
        b3= findViewById(R.id.b3);
        db=new database(this);




        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = edt2.getText().toString();

                if (db.checkLogin(username)) {
                    db.usun_uzytkownika(username);


                    Toast.makeText(getApplicationContext(), "Udało się usunąć użytkownika", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(getApplicationContext(), "Nie można usunąć - niepoprawna nazwa użytkownika", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}