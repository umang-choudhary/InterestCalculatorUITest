package com.learntodroid.interestcalculator.views;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.learntodroid.interestcalculator.R;
import com.learntodroid.interestcalculator.adapters.ResultsAdapter;
import com.learntodroid.interestcalculator.model.FinancialResult;
import com.learntodroid.interestcalculator.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel viewModel;

    private RecyclerView recyclerView;
    private ResultsAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupCalculator();

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        viewModel.init();

        viewModel.getResults().observe(this, new Observer<List<FinancialResult>>() {
            @Override
            public void onChanged(List<FinancialResult> financialResults) {
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.activity_main_recycler_view);
        recyclerViewAdapter = new ResultsAdapter(this, viewModel.getResults().getValue());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void setupCalculator() {
        final EditText initialDepositEditText = ((TextInputLayout) findViewById(R.id.activity_main_initial_deposit)).getEditText();
        final EditText monthlyDepositEditText = ((TextInputLayout) findViewById(R.id.activity_main_monthly_deposit)).getEditText();
        final EditText interestRateEditText = ((TextInputLayout) findViewById(R.id.activity_main_interest_rate)).getEditText();
        final EditText termEditText = ((TextInputLayout) findViewById(R.id.activity_main_term)).getEditText();

        initialDepositEditText.setText("20000");
        monthlyDepositEditText.setText("250");
        interestRateEditText.setText("2");
        termEditText.setText("5");

        findViewById(R.id.activity_main_calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int initialDeposit = Integer.parseInt(initialDepositEditText.getText().toString());
                int monthlyDeposit = Integer.parseInt(monthlyDepositEditText.getText().toString());
                int rate = Integer.parseInt(interestRateEditText.getText().toString());
                int term = Integer.parseInt(termEditText.getText().toString());
                viewModel.calculateResults(initialDeposit, monthlyDeposit, rate, term);
            }
        });
    }
}
