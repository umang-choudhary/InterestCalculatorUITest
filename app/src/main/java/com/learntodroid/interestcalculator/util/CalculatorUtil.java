package com.learntodroid.interestcalculator.util;

public class CalculatorUtil {
    public CalculatorUtil() {

    }

    public double calculateTotalDeposits(double initialDeposit, double monthlyDeposit, double term) {
        double totalDeposits = initialDeposit + (term * 12 * monthlyDeposit);
        return totalDeposits;
    }

    public double calculateTotalInterestPaid(double initialDeposit, double monthlyDeposit, double rate, double term) {
        double savings = initialDeposit;
        double interestPaid = 0, interest;
        for (int year = 0; year < term; year++) {
            for (int month = 0; month < 12; month++) {
                interest = savings * ((rate/100)/12);
                savings += monthlyDeposit;
                interestPaid += interest;
                savings += interest;
            }
        }
        return interestPaid;
    }

    public double calculateTotalSavings(double totalDeposits, double totalInterest) {
        return totalDeposits + totalInterest;
    }
}
