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
//        setResults();

        MutableLiveData<List<FinancialResult>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    // hardcoded data
//    private void setResults() {
//        dataSet.add(new FinancialResult(1, 1000));
//        dataSet.add(new FinancialResult(2, 1005));
//        dataSet.add(new FinancialResult(3, 1010));
//    }
}
