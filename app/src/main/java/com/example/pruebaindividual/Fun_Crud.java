package com.example.pruebaindividual;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
// se crea la clase crud para tomar los objetos de la clase producto y definirlo y agregarlos a la base de datos
public class Fun_Crud {
    // se define las variables
    private BaseDeDatos baseDeDatos;
    private SQLiteDatabase db;
    private ContentValues valores= new ContentValues();
    // se instancia con la clase base de datos y se crea el objeto base de datos
    public Fun_Crud(Context context){
        baseDeDatos = new BaseDeDatos(context);

    }
    // se crea el metodo para insertar datos en la tabla base de datos
    public void insertar(Producto producto) {
        db = baseDeDatos.getWritableDatabase();
        valores.clear();
        valores.put("NOMBRE",producto.getNombre());
        valores.put("PRECIO", producto.getPrecio());
        db.insert("productos", null, valores);

    }

    public ArrayList cargaNombres(){
        ArrayList<String> datosTabla = new ArrayList<>();
        db = baseDeDatos.getWritableDatabase();
        // seleccionar los campos de la base de dato para agregar a la lista
        Cursor registros = db.rawQuery("SELECT * FROM productos", null);
        if (registros.moveToFirst()){
            do {
                datosTabla.add(registros.getString(0) + "    -      $ " + String.valueOf(registros.getString(1)));
            }while(registros.moveToNext());
        }

        return datosTabla;
    }
}
