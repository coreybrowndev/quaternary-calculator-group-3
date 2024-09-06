package com.quaternary_group3.QuaternaryCalculator.service;

import java.util.stream.DoubleStream;
public class Calculator {
    public Calculator() {}

    public static int addition(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    public static int square(int a) {return a*a;}

    public static int square_root(int a, int base) {
        int base10 = Integer.parseInt(Integer.toString(a), base);
        double sqrt = Math.sqrt(base10);
        String sqrtBase4 = Integer.toString((int) sqrt, base);

        return Integer.parseInt(sqrtBase4, base);
    }

    //Number from base 4 converted to base 10
    //or number from base 10 converted to base 4
    public static String conversion (String number, int sBase, int dBase) {
        return Integer.toString(Integer.parseInt(number, sBase), dBase);
    }
}

