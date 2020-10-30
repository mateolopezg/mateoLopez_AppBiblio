package com.w.appbiblio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IComunicacion{

    private TextView editTextNombre, editTextPassword;
    private Button btnLogin;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre      = (TextView)findViewById(R.id.editTextNombre);
        editTextPassword    = (TextView)findViewById(R.id.editTextPassword);
        btnLogin            = (Button) findViewById(R.id.btnLogin);
        progressBar         = (ProgressBar)findViewById(R.id.progressBarLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTaskLogin(MainActivity.this).execute(editTextNombre.getText().toString(), editTextPassword.getText().toString(), 3000);
            }
        });
    }

    @Override
    public void toggleProgressBar(boolean status) {
        if (status){
            progressBar.setVisibility(View.VISIBLE);
        } else{
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void lanzarActividad(Class<?> tipoActividad) {
        Intent intent = new Intent(this, tipoActividad);
        startActivity(intent);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}