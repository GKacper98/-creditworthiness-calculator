package com.example.kalk_zdol_ktedytowej;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ParseAdapter2 extends RecyclerView.Adapter<ParseAdapter2.ViewHolder>  {

    private ArrayList<ParseItem2> ParseItem22;
    private Context context;

    public ParseAdapter2(ArrayList<ParseItem2> ParseItem22, Context context){
        this.ParseItem22 = ParseItem22;
        this.context = context;
    }

    @NonNull
    @Override
    public ParseAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parse_item4, parent, false);

        return new ParseAdapter2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParseAdapter2.ViewHolder holder, int position) {
        try {
            ParseItem2 parseItem2 = ParseItem22.get(position);

            holder.login_id.setText(parseItem2.getLogin());
            holder.haslo_id.setText(parseItem2.getHaslo());

        }
        catch (IllegalArgumentException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {

        return ParseItem22.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView login_id;
        TextView haslo_id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            login_id = itemView.findViewById(R.id.login_id);
            haslo_id = itemView.findViewById(R.id.haslo_id);

        }
    }
}
