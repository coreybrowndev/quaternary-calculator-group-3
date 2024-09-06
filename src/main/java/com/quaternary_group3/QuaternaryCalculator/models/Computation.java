package com.quaternary_group3.QuaternaryCalculator.models;

import com.quaternary_group3.QuaternaryCalculator.utils.Operation;

public class Computation {

    private String operand1;
    private String operand2;
    private Operation operation;
    private int base;
    private int x;
    private String result;

    public Computation(String operand1, String operand2, Operation operation, int base, int x, String result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.base = base;
        this.x = x;
        this.result = result;
    }

    public String getOperand1() {
        return operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public String getOperation() {
        return operation.toString();
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = -1000000000;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}


