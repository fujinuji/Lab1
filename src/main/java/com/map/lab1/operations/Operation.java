package com.map.lab1.operations;

public enum Operation {
    ADD("+"), MULTIPLY("*"), DIVISION("/"), SUBTRACTION("-");

    private final String sign;

    Operation(String sign) {
        this.sign = sign;
    }

    public static Operation value(String sign) {
        for(Operation operation : values()) {
            if(operation.sign.equals(sign)) {
                return operation;
            }
        }

        return null;
    }
}
