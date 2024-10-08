package com.quaternary_group3.QuaternaryCalculator.controllers;

import com.quaternary_group3.QuaternaryCalculator.models.Computation;

import com.quaternary_group3.QuaternaryCalculator.service.Calculator;
import com.quaternary_group3.QuaternaryCalculator.service.ReturnType;
import com.quaternary_group3.QuaternaryCalculator.utils.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalculatorController {


    @PostMapping("/calculate")
    public ReturnType calculate(@RequestBody Computation computation) {
        ReturnType result = new ReturnType();

        //handle the case where one of the numbers are greater than 3 when the base

        try {
            // Convert the operation string to the enum
            Operation operation = Operation.valueOf(computation.getOperation().toUpperCase());

            if (operation == Operation.TOGGLE) {
                //toggle the base
                if(computation.getBase() == 10) {
                    result.setResult(Calculator.conversion(computation.getResult(), computation.getBase(), 4));
                } else {
                    result.setResult(Calculator.conversion(computation.getResult(), computation.getBase(), 10));
                }

                return result;
            }

            if ((operation == Operation.SQUARE || operation == Operation.SQUARE_ROOT) && computation.getX() != -10000000) {
                int x = computation.getX();
                switch (operation) {
                    //WE LEFT OFF HERE, FIX THE SQUARING PROCESS OF NUMBERS FOR BASE 4!!!!
                    case SQUARE:
                        int localBaseConversion = 0;
                        if (computation.getBase() == 4) {
                            localBaseConversion = Integer.parseInt(Integer.toString(x), 4);
                        } else {
                            localBaseConversion = Integer.parseInt(Integer.toString(x), 10);
                        }
                        result.setResult(Integer.toString(Calculator.square(localBaseConversion), computation.getBase()));
                        break;
                    case SQUARE_ROOT:
                        result.setResult(Integer.toString(Calculator.square_root(x, computation.getBase()), computation.getBase()));
                        break;
                    default:
                        result.setResult("Unsupported operation for single operand");
                }
            }else {
                int x = Integer.parseInt(computation.getOperand1(), computation.getBase());
                int y = Integer.parseInt(computation.getOperand2(), computation.getBase());

                switch (operation) {
                    case ADD:
                        result.setResult(Integer.toString(Calculator.addition(x, y), computation.getBase()));
                        break;
                    case SUBTRACT:
                        result.setResult(Integer.toString(Calculator.subtract(x, y), computation.getBase()));
                        break;
                    case MULTIPLY:
                        result.setResult(Integer.toString(Calculator.multiply(x, y), computation.getBase()));
                        break;
                    case DIVIDE:
                        result.setResult(Integer.toString(Calculator.divide(x, y), computation.getBase()));
                        break;
                    default:
                        result.setResult("Unsupported operation");
                }
            }
        } catch (IllegalArgumentException e) {
            result.setResult("Invalid operation");
        }

        return result;
    }
}
