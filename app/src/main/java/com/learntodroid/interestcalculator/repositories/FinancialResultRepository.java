package com.learntodroid.interestcalculator.repositories;

import com.learntodroid.interestcalculator.model.FinancialResult;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class FinancialResultRepository {
    private static FinancialResultRepository instance;      // singleton pattern
    private ArrayList<FinancialResult> dataSet = new ArrayList<FinancialResult>();

    public static FinancialResultRepository getInstance() {
        if (instance == null) {
            instance = new FinancialResultRepository();
        }
        return instance;
    }

    public MutableLiveData<List<FinancialResult>> getResults() {
        MutableLiveData<List<FinancialResult>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }
}
