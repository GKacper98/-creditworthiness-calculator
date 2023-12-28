package com.example.kalk_zdol_ktedytowej;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {

    private static final String Baza_danych="Baza_danych.db";

    public database(@Nullable Context context) {
        super(context, Baza_danych, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String a="create table dane_o_kredycie(id integer primary key AUTOINCREMENT, wybor text,kwota integer,raty integer,data text, uzytkownicy_login text, foreign key(uzytkownicy_login) references uzytkownicy(login) ON UPDATE CASCADE ON DELETE CASCADE)";
        String b="create table dane_o_kliencie(id integer primary key AUTOINCREMENT, dochod text,osoby integer,wydatki integer, raty2 integer, zobowiazania integer, zdolnosc integer, uzytkownicy_login text, foreign key(uzytkownicy_login) references uzytkownicy(login) ON UPDATE CASCADE ON DELETE CASCADE)";
        String c="create table uzytkownicy(login text UNIQUE PRIMARY KEY , haslo text)";
        String d="create table informacje_kredytow(id integer primary key AUTOINCREMENT, imgBanku text, RRSO text, prowizja text, oferta text, wklad text, marza text)";
        String e="create table informacje_kredytow2(id integer primary key AUTOINCREMENT, imgBanku text, RRSO text, prowizja text, oferta text, wklad text, marza text, rata text, kwota text, uzytkownicy_login text, zatwierdz text, id_id text, FOREIGN KEY(id_id) REFERENCES dane_o_kredycie(id), foreign key(uzytkownicy_login) references uzytkownicy(login) ON UPDATE CASCADE ON DELETE CASCADE)";

        sqLiteDatabase.execSQL(a);
        sqLiteDatabase.execSQL(b);
        sqLiteDatabase.execSQL(c);
        sqLiteDatabase.execSQL(d);
        sqLiteDatabase.execSQL(e);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists dane_o_kredycie");
        sqLiteDatabase.execSQL("drop table if exists dane_o_kliencie");
        sqLiteDatabase.execSQL("drop table if exists uzytkownicy");
        sqLiteDatabase.execSQL("drop table if exists informacje_kredytow");
        sqLiteDatabase.execSQL("drop table if exists informacje_kredytow2");
        onCreate(sqLiteDatabase);

    }

    public boolean insert_data(String wybor, int kwota, int raty, String data, String uzytkownicy_login, String id_id)
    {

        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("wybor", wybor);
        c.put("kwota", kwota);
        c.put("raty", raty);
        c.put("data", data);
        c.put("uzytkownicy_login", uzytkownicy_login);


        long r=db.insert("dane_o_kredycie",null,c);
        if(r==-1)
            return false;
        else
            return true;
    }

    public boolean insert_data2(int dochod, int osoby, int wydatki, int raty2, int zobowiazania, int zdolnosc, String uzytkownicy_login, String id_id)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("dochod", dochod);
        c.put("osoby", osoby);
        c.put("wydatki", wydatki);
        c.put("raty2", raty2);
        c.put("zobowiazania", zobowiazania);
        c.put("zdolnosc", zdolnosc);
        c.put("uzytkownicy_login", uzytkownicy_login);


        long r=db.insert("dane_o_kliencie",null,c);
        if(r==-1)
            return false;
        else
            return true;
    }

    public Boolean insert_data3(String login, String haslo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("login", login);
        c.put("haslo", haslo);
        long result = db.insert("uzytkownicy", null, c);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insert_data4(String imgBanku, String RRSO, String prowizja, String oferta, String wklad, String marza)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("imgBanku", imgBanku);
        c.put("RRSO", RRSO);
        c.put("prowizja", prowizja);
        c.put("oferta", oferta);
        c.put("wklad", wklad);
        c.put("marza", marza);

        long r=db.insert("informacje_kredytow",null,c);
        if(r==-1)
            return false;
        else
            return true;
    }

    public boolean insert_data5(String imgBanku, String RRSO, String prowizja, String oferta, String wklad, String marza, String rata, String kwota, String uzytkownicy_login, String id_id, String zatwierdz) {
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues c = new ContentValues();
            c.put("imgBanku", imgBanku);
            c.put("RRSO", RRSO);
            c.put("prowizja", prowizja);
            c.put("oferta", oferta);
            c.put("wklad", wklad);
            c.put("marza", marza);
            c.put("rata", rata);
            c.put("kwota", kwota);
            c.put("uzytkownicy_login", uzytkownicy_login);
            c.put("id_id", id_id);
            c.put("zatwierdz", zatwierdz);


            long r = db.insert("informacje_kredytow2", null, c);
            if (r == -1)
                return false;
            else
                return true;
        }
    }


    public Boolean checkLogin(String login){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from uzytkownicy where login = ?", new String[]{login});
        if(cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkLoginPassword(String login, String haslo){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from uzytkownicy where login = ? and haslo = ?", new String[]{login, haslo});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkAdminStatus(String login){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM uzytkownicy WHERE login = ? AND haslo = ?", new String[]{login, "admin1"});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }


    public ArrayList<ModalContact> fetchData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM dane_o_kliencie",null);
        ArrayList<ModalContact> arrayList = new ArrayList<>();

        while (cursor.moveToNext()){
            ModalContact modelContact = new ModalContact();

            modelContact.id = cursor.getInt(0);
            modelContact.dochod = cursor.getInt(1);
            modelContact.osoby = cursor.getInt(2);
            modelContact.wydatki = cursor.getInt(3);
            modelContact.raty2 = cursor.getInt(4);
            modelContact.zobowiazania = cursor.getInt(5);
            modelContact.zdolnosc = cursor.getInt(6);

            arrayList.add(modelContact);
        }
        return arrayList;
    }

    public ArrayList<ModalContact2> fetchData2(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM dane_o_kredycie",null);
        ArrayList<ModalContact2> arrayList2 = new ArrayList<>();

        while (cursor.moveToNext()){
            ModalContact2 modelContact2 = new ModalContact2();
            modelContact2.id = cursor.getInt(0);
            modelContact2.wybor= cursor.getInt(1);
            modelContact2.kwota = cursor.getInt(2);
            modelContact2.raty = cursor.getInt(3);
            modelContact2.data = cursor.getInt(4);
            arrayList2.add(modelContact2);

        }
        return arrayList2;
    }


    public ArrayList<ModalContact3> fetchData3(String login){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT dane_o_kredycie.id, dane_o_kredycie.wybor, dane_o_kredycie.kwota, dane_o_kredycie.raty, dane_o_kredycie.data, " +
                "dane_o_kliencie.dochod, dane_o_kliencie.osoby, dane_o_kliencie.wydatki, dane_o_kliencie.raty2, dane_o_kliencie.zobowiazania, " +
                "informacje_kredytow2.imgBanku, informacje_kredytow2.RRSO, informacje_kredytow2.wklad, informacje_kredytow2.marza, informacje_kredytow2.prowizja, " +
                "informacje_kredytow2.rata, informacje_kredytow2.kwota, dane_o_kliencie.zdolnosc " +
                "FROM dane_o_kredycie " +
                "INNER JOIN dane_o_kliencie ON dane_o_kredycie.id = dane_o_kliencie.id " +
                "INNER JOIN informacje_kredytow2 ON dane_o_kredycie.id = informacje_kredytow2.id_id " +
                "WHERE dane_o_kliencie.uzytkownicy_login = ? " , new String[]{login},null);

        ArrayList<ModalContact3> arrayList3 = new ArrayList<>();


        arrayList3.clear();


        while (cursor.moveToNext()) {

            ModalContact3 modelContact3 = new ModalContact3();
            modelContact3.id= cursor.getString(0);
            modelContact3.wybor= cursor.getString(1);
            modelContact3.kwota = cursor.getString(2);
            modelContact3.raty= cursor.getString(3);
            modelContact3.data= cursor.getString(4);
            modelContact3.dochod= cursor.getString(5);
            modelContact3.osoby= cursor.getString(6);
            modelContact3.wydatki= cursor.getString(7);
            modelContact3.raty2= cursor.getString(8);
            modelContact3.zobowiazania= cursor.getString(9);
            modelContact3.imageview3= cursor.getString(10);
            modelContact3.RRSO= cursor.getString(11);
            modelContact3.wklad= cursor.getString(12);
            modelContact3.marza= cursor.getString(13);
            modelContact3.prowizja= cursor.getString(14);
            modelContact3.miesieczna= cursor.getString(15);
            modelContact3.kwota2= cursor.getString(16);
            modelContact3.zdolnosc = cursor.getString(17);
            arrayList3.add(modelContact3);
        }
        return arrayList3;
    }

    public ArrayList<ModalContact4> fetchData4(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM uzytkownicy",null);
        ArrayList<ModalContact4> arrayList4 = new ArrayList<>();

        while (cursor.moveToNext()) {

            ModalContact4 modelContact4 = new ModalContact4();

            modelContact4.login= cursor.getString(0);
            modelContact4.haslo= cursor.getString(1);

            arrayList4.add(modelContact4);
        }
        return arrayList4;
    }

    public ArrayList<ModalContact5> fetchData5(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM informacje_kredytow",null);
        ArrayList<ModalContact5> arrayList5 = new ArrayList<>();

        while (cursor.moveToNext()) {

            ModalContact5 modelContact5 = new ModalContact5();
            modelContact5.id= cursor.getString(0);
            modelContact5.imgBanku= cursor.getString(1);
            modelContact5.RRSO= cursor.getString(2);
            modelContact5.prowizja= cursor.getString(3);
            modelContact5.oferta= cursor.getString(4);
            modelContact5.wklad= cursor.getString(5);
            modelContact5.marza= cursor.getString(6);
            arrayList5.add(modelContact5);
        }
        return arrayList5;
    }

    public void usun_wszystko() {
        SQLiteDatabase db = getWritableDatabase();
        String tableName = "informacje_kredytow";
        db.delete(tableName, null, null);
        db.close();
    }

    public void usun_uzytkownika(String username) {
        SQLiteDatabase db = getWritableDatabase();

        String deleteCreditQuery = "DELETE FROM dane_o_kredycie WHERE uzytkownicy_login = '" + username + "'";
        db.execSQL(deleteCreditQuery);

        String deleteClientQuery = "DELETE FROM dane_o_kliencie WHERE uzytkownicy_login = '" + username + "'";
        db.execSQL(deleteClientQuery);

        String deleteClient2Query = "DELETE FROM informacje_kredytow2 WHERE uzytkownicy_login = '" + username + "'";
        db.execSQL(deleteClient2Query);

        String deleteUsers = "DELETE FROM uzytkownicy WHERE login = '" + username + "'";
        db.execSQL(deleteUsers);

        db.close();

    }


    public int getLastUsedId() {
        SQLiteDatabase db = this.getReadableDatabase();
        int lastUsedId = 0;

        String query = "SELECT id FROM dane_o_kredycie ORDER BY id DESC LIMIT 1";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            int idColumnIndex = cursor.getColumnIndex("id");
            if (idColumnIndex >= 0) {
                lastUsedId = cursor.getInt(idColumnIndex);
            } else {
                // Handle the case when the column "id" is not found
            }
        }

        cursor.close();
        db.close();

        return lastUsedId;
    }

    public void update(String informacje_kredytow2, ContentValues values, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(informacje_kredytow2, values, whereClause, whereArgs);
        db.close();
    }



}


