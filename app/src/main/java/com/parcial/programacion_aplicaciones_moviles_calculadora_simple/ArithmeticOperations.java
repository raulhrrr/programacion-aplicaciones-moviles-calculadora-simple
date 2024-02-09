package com.parcial.programacion_aplicaciones_moviles_calculadora_simple;

public class ArithmeticOperations {

    private Float num1, num2;

    public Float getNum1() {
        return num1;
    }

    public void setNum1(Float num1) {
        this.num1 = num1;
    }

    public Float getNum2() {
        return num2;
    }

    public void setNum2(Float num2) {
        this.num2 = num2;
    }

    public Float sum() {
        return num1 + num2;
    }

    public Float subtract() {
        return num1 - num2;
    }

    public Float multiply() {
        return num1 * num2;
    }

    public float multiplyRecursively(float multiplying, float multiplier) {
        if (multiplier > 0) return multiplying + multiplyRecursively(multiplying, multiplier - 1);
        if (multiplier < 0) return -multiplyRecursively(multiplying, -multiplier);
        return 0;
    }

    public Float divide() {
        return num1 / num2;
    }

}
