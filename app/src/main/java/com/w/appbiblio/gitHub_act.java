package com.w.appbiblio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class gitHub_act extends AppCompatActivity {

    private Spinner spinner;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_hub_act);

        spinner     = (Spinner)findViewById(R.id.spinner);
        textView    = (TextView)findViewById(R.id.textView);

        int farenheith      = 7000;
        int revival         = 22000;
        int el_alquimista   = 45000;
        int el_poder        = 88000;
        int despertar       = 156000;

        ArrayList<String> libros = new ArrayList<String>();
        libros.add("Farenheith");
        libros.add("Revival");
        libros.add("El Alquimista");
        libros.add("El Poder");
        libros.add("Despertar");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, libros);
        spinner.setAdapter(adapt);



        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> spn, android.view.View v, int posicion, long id) {
                        String libro = spinner.getSelectedItem().toString();
                        if(libro.equals("Farenheith"))
                        {
                            textView.setText("El valor de " + libro+ " " + farenheith);
                        }

                        if(libro.equals("Revival"))
                        {
                            textView.setText("El valor de " + libro+ " " + revival);
                        }

                        if(libro.equals("El Alquimista"))
                        {
                            textView.setText("El valor de " + libro+ " " + el_alquimista);
                        }

                        if(libro.equals("El Poder"))
                        {
                            textView.setText("El valor de " + libro+ " " + el_poder);
                        }

                        if(libro.equals("Despertar"))
                        {
                            textView.setText("El valor de " + libro+ " " + despertar);
                        }

                    }
                    public void onNothingSelected(AdapterView<?> spn) {
                    }
                });
    }
}