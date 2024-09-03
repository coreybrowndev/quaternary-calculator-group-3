package com.quaternary_group3.QuaternaryCalculator.service;

public class Calculator {
    public Calculator() {}

    public int addition(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    //Number from base 4 converted to base 10
    //or number from base 10 converted to base 4
    public String conversion (String number, int sBase, int dBase) {
        return Integer.toString(Integer.parseInt(number, sBase), dBase);
    }
}

