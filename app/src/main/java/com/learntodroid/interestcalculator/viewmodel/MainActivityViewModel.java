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

    public MutableLiveData<List<FinancialResult>> getResults() {
        return results;
    }
}
