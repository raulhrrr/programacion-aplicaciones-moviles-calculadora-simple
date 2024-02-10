package com.parcial.programacion_aplicaciones_moviles_calculadora_simple;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArithmeticOperationsTest {

    private ArithmeticOperations arithmeticOperations;

    @Before
    public void setUp() {
        arithmeticOperations = new ArithmeticOperations();
    }

    @Test
    public void sum() {
        arithmeticOperations.setNum1(1.0f);
        arithmeticOperations.setNum2(2.0f);
        assertEquals(3.0f, arithmeticOperations.sum(), 0.0f);
    }

    @Test
    public void subtract() {
        arithmeticOperations.setNum1(1.0f);
        arithmeticOperations.setNum2(2.0f);
        assertEquals(-1.0f, arithmeticOperations.subtract(), 0.0f);
    }

    @Test
    public void multiply() {
        arithmeticOperations.setNum1(1.0f);
        arithmeticOperations.setNum2(2.0f);
        assertEquals(2.0f, arithmeticOperations.multiply(), 0.0f);
    }

    @Test
    public void multiplyRecursively() {
        assertEquals(15.0f, arithmeticOperations.multiplyRecursively(3f, 5f), 0.0f);
    }

    @Test
    public void factorial() {
        assertEquals(120, arithmeticOperations.factorial(5, 1));
    }

    @Test
    public void fibonacci() {
        assertEquals("0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55", arithmeticOperations.fibonacci(0, 10));
    }

    @Test
    public void divide() {
        arithmeticOperations.setNum1(1.0f);
        arithmeticOperations.setNum2(2.0f);
        assertEquals(0.5f, arithmeticOperations.divide(), 0.0f);
    }
}