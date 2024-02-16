package com.parcial.programacion_aplicaciones_moviles_calculadora_simple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_history);

        TextView historyResult = findViewById(R.id.historyResult);

        StringBuilder result = new StringBuilder();

        for (int i = ArithmeticOperations.getHistory().size() - 1; i >= 0; i--) {
            result.append(ArithmeticOperations.getHistory().get(i)).append("\n");
        }

        historyResult.setText(result.toString());

        Button main = findViewById(R.id.mainActivity);

        main.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));

    }
}