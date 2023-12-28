package com.example.kalk_zdol_ktedytowej;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;


public class PanelAdmin extends AppCompatActivity {


    database k;
    Button button10;
    Button button11;
    Button button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_admin);

        button10=findViewById(R.id.button10);
        button11=findViewById(R.id.button11);
        button12=findViewById(R.id.button12);

        k=new database(this);




        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PanelAdmin.this,PanelAdmin_Users.class);
                startActivity(intent);
            }
            });


        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                k.usun_wszystko();
                new MyAsyncTask().execute();

                }

            });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PanelAdmin.this,PanelAdmin_Delete.class);
                startActivity(intent);
            }
        });

        }


    private class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPostExecute(Void result) {


            Toast.makeText(PanelAdmin.this, "Zaktualizowano dane", Toast.LENGTH_SHORT).show();


        }

        @Override
        protected Void doInBackground(Void... voids) {

            try{
                String url="https://www.bankier.pl/smart/kredyty-hipoteczne";
                Document doc = Jsoup.connect(url).get();
                Elements data = doc.select("div.pane.pane-result");
                int size= data.size();

                for(int i=0; i < size; i++){
                    String imgBanku = data.select("div.pane__body-inner")
                            .select("img")
                            .eq(i)
                            .attr("src");

                    String RRSO = data.select("div.feature.aprc") //rrso
                            .select("div.value")
                            .eq(i)
                            .text().replace(',', '.').replace("%", "");

                    String prowzija = data.select("div.feature.commission") //prowizja
                            .select("div.value")
                            .eq(i)
                            .text().replace(',', '.').replace("%", "");

                    String oferta = data.select("div.pane__footer-button")//href_oferta
                            .select("a.details.event-dynamic-trigger")
                            .eq(i)
                            .attr("href");

                    String wklad = data.select("div.feature.own-contribution-min") //wklad wlasny
                            .select("div.value")
                            .eq(i)
                            .text().replace(',', '.').replace("%", "");

                    String marza = data.select("div.feature.markup") //marza
                            .select("div.value")
                            .eq(i)
                            .text().replace(',', '.').replace("%", "");


                    k.insert_data4(imgBanku, RRSO, prowzija, oferta, wklad, marza);

                    Log.d("items", "Bank_jpg: " +imgBanku+ " "+".RRSO: " +RRSO+ ". Prowizja: "+prowzija+". Oferta: "+oferta+". Wkład: "+wklad+ "Marża: " +marza);

                }


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}

