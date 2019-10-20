package com.learntodroid.interestcalculator.model;

public class FinancialResult {
    private int period, result;

    public FinancialResult(int period, int result) {
        this.period = period;
        this.result = result;
    }

    public int getPeriod() {
        return period;
    }

    public int getResult() {
        return result;
    }
}
