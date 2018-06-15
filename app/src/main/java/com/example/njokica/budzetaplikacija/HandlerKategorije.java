package com.example.njokica.budzetaplikacija;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class HandlerKategorije extends SQLiteOpenHelper  {


    public static final String DATABASE_NAME = "Kategorije";

    //tablica Kategorija
    public static final String TABLICA_KATEGORIJA = "Kategorija";
    public static final String RED_sifra_kategorije = "sifra_kategorije";
    public static final String RED_naziv_kategorije = "naziv_kategorije";

    public HandlerKategorije(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db2 = this.getReadableDatabase();
    }

    public void onCreate(SQLiteDatabase db2) {
        db2.execSQL("CREATE TABLE " + TABLICA_KATEGORIJA + "(sifra_kategorije INTEGER PRIMARY KEY AUTOINCREMENT, naziv_kategorije STRING)");
    }

    public void onUpgrade(SQLiteDatabase db2, int oldVersion, int newVersion) {
        db2.execSQL("DROP TABLE IF EXISTS " + TABLICA_KATEGORIJA);

        onCreate(db2);

    }


    public boolean addData2(String item){
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RED_naziv_kategorije, item);


        Log.d(DATABASE_NAME, "dodaj podatke: dodavanje" + item + " u " + TABLICA_KATEGORIJA);
        long result_kategorija = db2.insert(TABLICA_KATEGORIJA, null, contentValues);

        if(result_kategorija == -1){
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData2(){
        SQLiteDatabase db2 = this.getWritableDatabase();
        String query2 = "SELECT * FROM " + TABLICA_KATEGORIJA;
        Cursor data2 = db2.rawQuery(query2, null);
        return data2;
    }


    public List<String> getAllKategorije(){
        List<String> kategorije = new ArrayList<String>();

        SQLiteDatabase db2 = this.getReadableDatabase();
        String query2 = "SELECT * FROM " + TABLICA_KATEGORIJA;
        Cursor data2 = db2.rawQuery(query2, null);

        if(data2.moveToFirst()){
            do {
                kategorije.add(data2.getString(1));
            }while (data2.moveToNext());

        }

        data2.close();
        db2.close();

        return kategorije;
    }


    public boolean deleteData2(){
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.remove(TABLICA_KATEGORIJA);



        long result_kategorija = db2.delete(TABLICA_KATEGORIJA, null, null);

        if(result_kategorija == -1){
            return false;
        } else {
            return true;
        }
    }
    public Cursor delete2(){
        SQLiteDatabase db2 = this.getWritableDatabase();
        String query2 = "DELETE FROM " + TABLICA_KATEGORIJA;

        Cursor data2 = db2.rawQuery(query2, null);
        return data2;
    }


}
