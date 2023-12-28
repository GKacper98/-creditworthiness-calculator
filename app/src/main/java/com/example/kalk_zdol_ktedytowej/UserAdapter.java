package com.example.kalk_zdol_ktedytowej;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {


    private ArrayList<UserInfo> userInfos;
    private Context context;

    public UserAdapter(ArrayList<UserInfo> userInfos, Context context){
        this.userInfos = userInfos;
        this.context = context;
    }


    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parse_item3, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        try {
            UserInfo userInfo = userInfos.get(position);


            holder.id_id.setText(userInfo.getId());
            holder.wybor_id.setText(userInfo.getWybor());
            holder.kwota_id.setText(userInfo.getKwota());
            holder.raty_id.setText(userInfo.getRaty());
            holder.data_id.setText(userInfo.getData());
            holder.dochody_id.setText(userInfo.getDochody());
            holder.osoby_id.setText(userInfo.getOsoby());
            holder.wydatki_id.setText(userInfo.getWydatki());
            holder.raty2_id.setText(userInfo.getRaty2());
            holder.zobowiazania_id.setText(userInfo.getZobowiazania());
            Picasso.get().load(userInfo.getImageview3()).into(holder.imageview3);
            holder.rrso_id.setText(userInfo.getRRSO());
            holder.wklad_id.setText(userInfo.getWklad());
            holder.marza_id.setText(userInfo.getMarza());
            holder.prowizja_id.setText(userInfo.getProwizja());
            holder.miesieczna_id.setText(userInfo.getMiesieczna());
            holder.kwota2_id.setText(userInfo.getKwota2());
            holder.zdolnosc_id.setText(userInfo.getZdolnosc());



        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {

        return userInfos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView id_id;
        TextView wybor_id;
        TextView kwota_id;
        TextView raty_id;
        TextView data_id;
        TextView dochody_id;
        TextView osoby_id;
        TextView wydatki_id;
        TextView raty2_id;
        TextView zobowiazania_id;
        ImageView imageview3;
        TextView rrso_id;
        TextView wklad_id;
        TextView marza_id;
        TextView prowizja_id;
        TextView miesieczna_id;
        TextView kwota2_id;
        TextView zdolnosc_id;





        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id_id = itemView.findViewById(R.id.id_id);
            wybor_id = itemView.findViewById(R.id.wybor_id);
            kwota_id = itemView.findViewById(R.id.kwota_id);
            raty_id = itemView.findViewById(R.id.raty_id);
            data_id = itemView.findViewById(R.id.data_id);
            dochody_id = itemView.findViewById(R.id.dochody_id);
            osoby_id = itemView.findViewById(R.id.osoby_id);
            wydatki_id = itemView.findViewById(R.id.wydatki_id);
            raty2_id = itemView.findViewById(R.id.raty2_id);
            zobowiazania_id = itemView.findViewById(R.id.zobowiazania_id);
            imageview3 = itemView.findViewById(R.id.imageview3);
            rrso_id = itemView.findViewById(R.id.rrso_id);
            wklad_id = itemView.findViewById(R.id.wklad_id);
            marza_id = itemView.findViewById(R.id.marza_id);
            prowizja_id = itemView.findViewById(R.id.prowizja_id);
            miesieczna_id = itemView.findViewById(R.id.miesieczna_id);
            kwota2_id = itemView.findViewById(R.id.kwota2_id);
            zdolnosc_id= itemView.findViewById(R.id.zdolnosc_id);

        }
    }
}
