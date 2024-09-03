package com.quaternary_group3.QuaternaryCalculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    int x = Integer.parseInt("212", 4);
    int y = Integer.parseInt("32", 4);

    @Test
    void addition() {
        assertEquals("310", Integer.toString(Calculator.addition(x, y), 4));
    }

    @Test
    void subtract() {
        assertEquals("120", Integer.toString(Calculator.subtract(x, y), 4));
    }

    @Test
    void multiply() {
        assertEquals("20110", Integer.toString(Calculator.multiply(x, y), 4));
    }

    @Test
    void divide() {
        int divY = Integer.parseInt("2", 4);
        assertEquals("103", Integer.toString(Calculator.divide(x, divY), 4));
    }
}