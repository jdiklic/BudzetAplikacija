package com.example.njokica.budzetaplikacija;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class HandlerTrosak extends SQLiteOpenHelper  {

    public static final String DATABASE_NAME = "Troskovi";


    //tablica Trosak
    public static final String TABLICA_TROSAK = "Trosak";
    public static final String RED_sifra_troska = "sifra_troska";
    public static final String RED_naziv_troska= "naziv_troska";
    public static final String RED_iznos_troska = "iznos_troska";

    public HandlerTrosak(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db3 = this.getReadableDatabase();
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLICA_TROSAK + "(sifra_troska INTEGER PRIMARY KEY AUTOINCREMENT, naziv_troska DOUBLE, iznos_troska DOUBLE)");
    }

    public void onUpgrade(SQLiteDatabase db3, int oldVersion, int newVersion) {

        db3.execSQL("DROP TABLE IF EXISTS " + TABLICA_TROSAK);

        onCreate(db3);

    }


    public boolean addData3(String item){
        SQLiteDatabase db3 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RED_naziv_troska, item);

        Log.d(DATABASE_NAME, "dodaj podatke: dodavanje" + item + " u " + TABLICA_TROSAK);
        long result_trosak = db3.insert(TABLICA_TROSAK, null, contentValues);

        if(result_trosak == -1){
            return false;
        } else {
            return true;
        }
    }


    public boolean deleteData(){
        SQLiteDatabase db3 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.remove(RED_naziv_troska);



        long result_trosak = db3.delete(TABLICA_TROSAK, null, null);

        if(result_trosak == -1){
            return false;
        } else {
            return true;
        }
    }






    public Cursor getData3(){
        SQLiteDatabase db3 = this.getWritableDatabase();
//        String query3 = "DELETE FROM " + TABLICA_TROSAK;
        String query3 = "SELECT * FROM " + TABLICA_TROSAK;
        Cursor data3 = db3.rawQuery(query3, null);
        return data3;
    }

    public Cursor delete(){
        SQLiteDatabase db3 = this.getWritableDatabase();
        String query4 = "DELETE FROM " + TABLICA_TROSAK;

        Cursor data4 = db3.rawQuery(query4, null);
        return data4;
    }








}
