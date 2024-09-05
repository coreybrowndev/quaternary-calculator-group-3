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
        int x = Integer.parseInt(computation.getOperand1(), computation.getBase());
        int y = Integer.parseInt(computation.getOperand2(), computation.getBase());

        //handle the case where one of the numbers are greater than 3 when the base

        try {
            // Convert the operation string to the enum
            Operation operation = Operation.valueOf(computation.getOperation().toUpperCase());

            // Perform the operation based on the enum value
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
        } catch (IllegalArgumentException e) {
            result.setResult("Invalid operation");
        }

        return result;
    }
}
