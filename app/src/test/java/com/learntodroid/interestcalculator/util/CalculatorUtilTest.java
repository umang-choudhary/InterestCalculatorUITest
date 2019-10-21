package com.learntodroid.interestcalculator.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorUtilTest {

    @Test
    public void calculateTotalDeposits() {
        double initialDepositInput = 10000;
        double monthlyDepositInput = 100;
        double termInput = 10;
        double expected = 10000 + (100 * 12 * 10);
        double delta = 0.1;

        CalculatorUtil calc = new CalculatorUtil();
        double actual = calc.calculateTotalDeposits(initialDepositInput, monthlyDepositInput, termInput);

        assertEquals(expected, actual, delta);
    }

    @Test
    public void calculateTotalInterestPaid() {
        double initialDepositInput = 20000;
        double monthlyDepositInput = 250;
        double rateInput = 2;
        double termInput = 5;
        double expected = 2863.42;
        double delta = 0.01;

        CalculatorUtil calc = new CalculatorUtil();
        double actual = calc.calculateTotalInterestPaid(initialDepositInput, monthlyDepositInput, rateInput, termInput);

        assertEquals(expected, actual, delta);
    }

    @Test
    public void calculateTotalSavings() {
        double totalDepositsInput = 20000;
        double totalInterestInput = 10000;
        double expected = 30000;
        double delta = 0.1;

        CalculatorUtil calc = new CalculatorUtil();
        double actual = calc.calculateTotalSavings(totalDepositsInput, totalInterestInput);

        assertEquals(expected, actual, delta);

    }
}