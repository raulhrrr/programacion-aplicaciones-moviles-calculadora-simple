package com.parcial.programacion_aplicaciones_moviles_calculadora_simple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainClean extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_clean);

        Button main = findViewById(R.id.mainActivity2);
        Button history = findViewById(R.id.mainHistory2);

        main.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
        history.setOnClickListener(v -> startActivity(new Intent(this, MainHistory.class)));

    }
}