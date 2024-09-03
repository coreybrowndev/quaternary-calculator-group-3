package com.quaternary_group3.QuaternaryCalculator.service;

public class ExampleUsage {

    Calculator calculator = new Calculator();

    //if base is 4
    // we need to ensure that the input doesn't contain a digit greater than 3, if so... we don't process and return error to user

    //user should be able to do operations on only one number



    //------------- Subtracting numbers based on the base provided ---------------------//

    //Base to return
    int baseForSubtraction = 4;

    int x = Integer.parseInt("212", baseForSubtraction);
    int y = Integer.parseInt("32", baseForSubtraction);

    //subtracting two numbers
    String res = Integer.toString(calculator.subtract(x, y), baseForSubtraction);

        System.out.prinf("This is subtraction done in base: %d - result:  %s", baseForSubtraction, res);

    //------------- Add numbers based on the base provided ---------------------//

    //Base to return
    int baseForAdd = 4;

    int xAdd = Integer.parseInt("131", baseForAdd);
    int yAdd = Integer.parseInt("223", baseForAdd);

    //subtracting two numbers
    String resAdd = Integer.toString(calculator.addition(xAdd, yAdd), baseForAdd);

        System.out.printf("\nThis is addition done in base: %d - result:  %s", baseForAdd, resAdd);

    //------------- Multiply numbers based on the base provided ---------------------//

    //Base to return
    int baseForMultiply = 4;

    int xMult = Integer.parseInt("232", baseForMultiply);
    int yMult = Integer.parseInt("131", baseForMultiply);

    //subtracting two numbers
    String resMult = Integer.toString(calculator.multiply(xMult, yMult), baseForMultiply);

    System.out.printf("\nThis is multiplication done in base: %d - result:  %s", baseForMultiply, resMult);

    //------------- Divide numbers based on the base provided ---------------------//

    //Base to return
    int baseForDivision = 4;

    int xDivision = Integer.parseInt("133", baseForDivision);
    int yDivision = Integer.parseInt("3", baseForDivision);

    //subtracting two numbers
    String resDivision = Integer.toString(calculator.divide(xDivision, yDivision), baseForDivision);

    System.out.printf("\nThis is division done in base: %d - result:  %s", baseForDivision, resDivision);

    //------------- Convert a number from one base to another --------------------//

    //number in base 4
    int n = 223;
    String num = Integer.toString(n);

    String baseConverted = calculator.conversion(num, 4, 10);

    //Number from base 4 converted to base 10
    System.out.printf("\nThis is the number in base 4: %d - converted to base 10: %s", n, baseConverted);
}
