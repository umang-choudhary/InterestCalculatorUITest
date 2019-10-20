package com.learntodroid.interestcalculator.model;

public class FinancialResult {
    private String description;
    private double result;

    public FinancialResult(String description, double result) {
        this.description = description;
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public double getResult() {
        return result;
    }
}
