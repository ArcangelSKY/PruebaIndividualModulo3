package com.example.pruebaindividual;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // define las variables
    EditText tx_nombre, tx_precio;
     ListView listView;
     Button botonGrabar;

    public ArrayList<String> listaNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // se asigna el objeto con el objeto creado en actividad xml
        tx_nombre = (EditText)findViewById(R.id.editText_nombre);
        tx_precio = (EditText)findViewById(R.id.editText_precio);
        botonGrabar = (Button)findViewById(R.id.b_crear);
        listView = (ListView)findViewById((R.id.ListView));
        mostrar();
        // con el metodo del boton se crea una accion.
        botonGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tx_nombre.length() > 0 && tx_precio.length() > 0)
                {
                    Fun_Crud metodos_crud = new Fun_Crud( getApplicationContext());
                    Producto producto = new Producto();
                    producto.setNombre(tx_nombre.getText().toString());
                    producto.setPrecio(Integer.parseInt(tx_precio.getText().toString()));
                    metodos_crud.insertar(producto);
                    mostrar();
                }
            }
        });


    }
    // se crea el metodo para que muestre los datos en la listview
    public void mostrar(){
        Fun_Crud metodos_crud = new Fun_Crud( getApplicationContext());
        // al momento de cargar todos los datos a la lista
        listaNombre = metodos_crud.cargaNombres();
        // se aplica el adapter para mostrar la lista en el listview
        ArrayAdapter<String> adapater = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaNombre);
        // aca se aplica la instancia en el adapter para mostrar en el listview
        listView.setAdapter(adapater);
        limpiar();
    }
    // al momento de presionar el los objetos de texto genera una limpieza en los campos para volver a escribir datos
    public void limpiar(){
        tx_nombre.setText(null);
        tx_precio.setText(null);
    }
}

