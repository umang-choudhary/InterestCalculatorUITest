package com.learntodroid.interestcalculator.viewmodel;

import com.learntodroid.interestcalculator.model.FinancialResult;
import com.learntodroid.interestcalculator.repositories.FinancialResultRepository;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<FinancialResult>> results;
    private FinancialResultRepository repo;

    public void init() {
        if (results != null) {
            return;
        }
        repo = FinancialResultRepository.getInstance();
        results = repo.getResults();
    }

    public int calculateTotalDeposits(int initialDeposit, int monthlyDeposit, int term) {
        int totalDeposits = initialDeposit + (term * 12 * monthlyDeposit);
        return totalDeposits;
    }

    public double calculateTotalInterestPaid(int i, int m, double rate, int term) {
//        int savings = initialDeposit + monthlyDeposit;
//        double interestPaid = 0;
//        for (int year = 0; year < term; year++) {
//            for (int month = 0; month < 12; month++) {
//                savings += monthlyDeposit;
//                interestPaid += (savings * ((rate/100)/12));
//            }
//        }
//        return interestPaid;
        // https://www.thebalance.com/calculate-interest-on-savings-315753
        double r = (rate/100)/12;
        int n = 12 * term;
        // FV = Pmt x (((1 + r) ^ n) – 1)/r)
        double totalPaid = (i + m) * ((Math.pow(1 + r, n) - 1) / r);
        double interestPaid = totalPaid - calculateTotalDeposits(i, m, term);
        return interestPaid;

    }

    public void calculateResults(int initialDeposit, int monthlyDeposit, double rate, int term) {
        int totalDeposits = calculateTotalDeposits(initialDeposit, monthlyDeposit, term);
        double totalInterest = calculateTotalInterestPaid(initialDeposit, monthlyDeposit, rate, term);
        double totalSavings = totalDeposits + totalInterest;

        List<FinancialResult> currentResults = results.getValue();
        currentResults.add(0, new FinancialResult("Total Savings", totalSavings));
        currentResults.add(0, new FinancialResult("Total Interest", totalInterest));
        currentResults.add(0, new FinancialResult("Total Deposits", totalDeposits));
        results.postValue(currentResults);
    }

    public MutableLiveData<List<FinancialResult>> getResults() {
        return results;
    }
}
