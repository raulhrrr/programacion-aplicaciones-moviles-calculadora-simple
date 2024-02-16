package com.parcial.programacion_aplicaciones_moviles_calculadora_simple;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private ArithmeticOperations arithmeticOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arithmeticOperations = new ArithmeticOperations();

        Button add = findViewById(R.id.add);
        Button subtract = findViewById(R.id.subtract);
        Button multiply = findViewById(R.id.multiply);
        Button divide = findViewById(R.id.divide);
        Button factorial = findViewById(R.id.factorial);
        Button fibonacci = findViewById(R.id.fibonacci);
        Button history = findViewById(R.id.mainHistory);

        add.setOnClickListener(this::onClickSum);
        subtract.setOnClickListener(this::onClickSubtract);
        multiply.setOnClickListener(this::onClickMultiply);
        divide.setOnClickListener(this::onClickDivide);
        factorial.setOnClickListener(this::onClickFactorial);
        fibonacci.setOnClickListener(this::onClickFibonacci);

        history.setOnClickListener(v -> startActivity(new Intent(this, MainHistory.class)));

    }

    @SuppressLint("SetTextI18n")
    public boolean getNumbers() {
        EditText txtNum1 = findViewById(R.id.num1);
        EditText txtNum2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);

        String s1 = txtNum1.getText().toString();
        String s2 = txtNum2.getText().toString();

        if (s1.equals("") && s2.equals("")) {
            result.setText("Ingrese los números necesarios para la operación");
            return false;
        }

        if (s1.equals("")) {
            result.setText("Ingrese el número 1");
            return false;
        }

        if (s2.equals("")) {
            result.setText("Ingrese el número 2");
            return false;
        }

        arithmeticOperations.setNum1(Float.parseFloat(s1));
        arithmeticOperations.setNum2(Float.parseFloat(s2));

        return true;
    }

    public void addCalculationInHistory(String operation) {
        ArithmeticOperations.addCalculation(
                String.format(
                        Locale.getDefault(),
                        "%f %s %f = %s",
                        arithmeticOperations.getNum1(),
                        operation,
                        arithmeticOperations.getNum2(),
                        result.getText()
                )
        );
    }

    @SuppressLint("SetTextI18n")
    public void onClickSum(View view) {

        if (getNumbers()) {
            result.setText(Float.toString(arithmeticOperations.sum()));
            addCalculationInHistory("+");
        }

    }

    @SuppressLint("SetTextI18n")
    public void onClickSubtract(View view) {

        if (getNumbers()) {
            result.setText(Float.toString(arithmeticOperations.subtract()));
            addCalculationInHistory("-");
        }

    }

    @SuppressLint("SetTextI18n")
    public void onClickMultiply(View view) {

        if (getNumbers()) {
            // result.setText(Float.toString(arithmeticOperations.multiply()));
            result.setText(Float.toString(arithmeticOperations.multiplyRecursively(
                    arithmeticOperations.getNum1(),
                    arithmeticOperations.getNum2()
            )));
            addCalculationInHistory("*");
        }

    }

    @SuppressLint("SetTextI18n")
    public void onClickFactorial(View view) {

        if (getNumbers()) {
            result.setText(Integer.toString(arithmeticOperations.factorial(
                    arithmeticOperations.getNum1().intValue(),
                    arithmeticOperations.getNum2().intValue()
            )));
            addCalculationInHistory("!");
        }

    }

    @SuppressLint("SetTextI18n")
    public void onClickFibonacci(View view) {

        if (getNumbers()) {
            result.setText(arithmeticOperations.fibonacci(
                    arithmeticOperations.getNum1().intValue(),
                    arithmeticOperations.getNum2().intValue()
            ));
            addCalculationInHistory("Fibonacci");
        }

    }

    @SuppressLint("SetTextI18n")
    public void onClickDivide(View view) {

        if (Objects.equals(arithmeticOperations.getNum2(), 0.0f)) {
            result.setText("No se puede dividir entre 0");
        }

        if (getNumbers() && !Objects.equals(arithmeticOperations.getNum2(), 0.0f)) {
            result.setText(Float.toString(arithmeticOperations.divide()));
            addCalculationInHistory("/");
        }

    }

}