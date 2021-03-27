package com.example.pruebaindividual;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;


public class BaseDeDatos extends SQLiteOpenHelper {
    // se crea la base de datos con la clase abstracta SQL
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Producto.db";

    public BaseDeDatos (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    // se crea la tabla productos con sus valores, metodo abstracto
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE productos (" +
                "NOMBRE TEXT NOT NULL," +
                "PRECIO INTEGER NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
