package com.example.kalk_zdol_ktedytowej;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;


public class ParseAdapter1 extends RecyclerView.Adapter<ParseAdapter1.ViewHolder>  {

    private SQLiteDatabase db;
    private ArrayList<ParseItem1> ParseItem11;
    private Context context;
    private SharedPreferences sharedPreferences;
    private int currentBatch;

    public ParseAdapter1(ArrayList<ParseItem1> ParseItem11, Context context) {
        this.ParseItem11 = ParseItem11;
        this.context = context;
        db = new database(context).getWritableDatabase();

        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

// Sprawdź, czy tabela informacje_kredytow2 istnieje i czy zawiera rekordy
        boolean isTableEmpty = isTableEmpty("informacje_kredytow2");

        if (isTableEmpty) {
            // Jeśli tabela jest pusta, zresetuj wartość currentBatch na 1
            currentBatch = 1;
            sharedPreferences.edit().putInt("currentBatch", currentBatch).apply();
        } else {
            currentBatch = sharedPreferences.getInt("currentBatch", 1);
        }

        updateData(ParseItem11);
    }

    private boolean isTableEmpty(String tableName) {
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + tableName, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int count = cursor.getInt(0);
                cursor.close();
                return count == 0;
            }
            cursor.close();
        }
        return true;
    }

    // Metoda do aktualizacji danych w adapterze
    public void updateData(ArrayList<ParseItem1> ParseItem11) {
        this.ParseItem11 = ParseItem11;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parse_item, parent, false);
        return new ViewHolder(view);
    }

    public interface OnItemClickListener {
        void onItemClicked();
    }
    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            ParseItem1 parseItem1 = ParseItem11.get(position);
            holder.id_id.setText(parseItem1.getId());
            holder.rrso_txt_id.setText(parseItem1.getRRSO());
            holder.prowizja_txt_id.setText(parseItem1.getProwizja());
            holder.wklad_txt_id.setText(parseItem1.getWklad());
            holder.marza_txt_id.setText(parseItem1.getMarza());
            holder.rata_txt_id.setText(parseItem1.getRata());
            holder.kwota_txt_id.setText(parseItem1.getKwota());
            Picasso.get().load(parseItem1.getImgBanku()).into(holder.imageView);

            holder.imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = parseItem1.getOferta();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);

                    if (listener != null) {
                        listener.onItemClicked();
                    }
                    
                    
                    int currentBatch = sharedPreferences.getInt("currentBatch", 1);
                    int idOffset = (currentBatch - 1) * 4;

                    ContentValues values = new ContentValues();
                    values.put("zatwierdz", "1");
                    String[] whereArgs = {String.valueOf(Integer.parseInt(parseItem1.getId()) + idOffset)};
                    db.update("informacje_kredytow2", values, "id=?", whereArgs);

                    Log.d("TAG", "Wartość ID: " + parseItem1.getId());

                    currentBatch++; // zwiększ bieżącą partię o 1

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("currentBatch", currentBatch);
                    editor.apply();

                    int a = currentBatch - 1;

                    Log.d("TAG", "Wartość currentBatch: " + a);

                    db.delete("informacje_kredytow2", "zatwierdz=?", new String[]{"0"});

                }
            });


            


        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }


    //db.update("informacje_kredytow2", values, null, null);
    //Log.d("TAG", "Wartość ID: " + parseItem1.getId());
    @Override
    public int getItemCount() {
        return ParseItem11.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id_id;
        ImageView imageView;
        TextView rrso_txt_id;
        TextView prowizja_txt_id;
        TextView wklad_txt_id;
        TextView marza_txt_id;
        TextView rata_txt_id;
        TextView kwota_txt_id;
        ImageButton imageButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id_id = itemView.findViewById(R.id.id_id);
            imageView = itemView.findViewById(R.id.imageView);
            rrso_txt_id = itemView.findViewById(R.id.rrso_txt_id);
            prowizja_txt_id = itemView.findViewById(R.id.prowizja_txt_id);
            wklad_txt_id = itemView.findViewById(R.id.wklad_txt_id);
            marza_txt_id = itemView.findViewById(R.id.marza_txt_id);
            imageButton = itemView.findViewById(R.id.imageButton);
            rata_txt_id = itemView.findViewById(R.id.rata_txt_id);
            kwota_txt_id = itemView.findViewById(R.id.kwota_txt_id);
        }
    }
}
