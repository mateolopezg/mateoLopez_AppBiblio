package com.w.appbiblio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView editTextNombre, editTextPassword;
    private Button btnLogin;
    private ProgressBar progressBarLogin;
    private ImageButton btnGitHub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre      = findViewById(R.id.editTextNombre);
        editTextPassword    = findViewById(R.id.editTextPassword);
        btnLogin            = findViewById(R.id.btnLogin);
        btnGitHub           = findViewById(R.id.btnGitHub);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTaskLogin(MainActivity.this).execute(editTextNombre.getText().toString(), editTextPassword.getText().toString(), 3000);
            }
        });
    }
}