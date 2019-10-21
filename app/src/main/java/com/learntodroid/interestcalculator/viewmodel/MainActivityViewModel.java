package com.learntodroid.interestcalculator.viewmodel;

import com.learntodroid.interestcalculator.model.FinancialResult;
import com.learntodroid.interestcalculator.repositories.FinancialResultRepository;
import com.learntodroid.interestcalculator.util.CalculatorUtil;

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

    public void calculateResults(double initialDeposit, double monthlyDeposit, double rate, int term) {
        CalculatorUtil calc = new CalculatorUtil();
        double totalDeposits = calc.calculateTotalDeposits(initialDeposit, monthlyDeposit, term);
        double totalInterest = calc.calculateTotalInterestPaid(initialDeposit, monthlyDeposit, rate, term);
        double totalSavings = calc.calculateTotalSavings(totalDeposits, totalInterest);

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
