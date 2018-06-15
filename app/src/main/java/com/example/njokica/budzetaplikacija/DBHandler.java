package com.example.njokica.budzetaplikacija;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;





public class DBHandler extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "BudzetApp.db";

    //tablica Budzet
    public static final String TABLICA_BUDZET = "budzet";
    public static final String RED_sifra_budzeta = "sifra_budzeta";
    public static final String RED_naziv_budzeta = "naziv_budzeta";
    public static final String RED_iznos_budzeta = "iznos_budzeta";





    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLICA_BUDZET + "(sifra_budzeta INTEGER PRIMARY KEY AUTOINCREMENT, iznos_budzeta DOUBLE, naziv_budzeta STRING)");

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLICA_BUDZET);
        onCreate(db);

    }

    public boolean addData(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RED_iznos_budzeta, item);

        Log.d(DATABASE_NAME, "dodaj podatke: dodavanje" + item + " u " + TABLICA_BUDZET);
        long result_budzet = db.insert(TABLICA_BUDZET, null, contentValues);

        if(result_budzet == -1){
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLICA_BUDZET;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

}
