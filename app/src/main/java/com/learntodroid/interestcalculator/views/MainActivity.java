package com.learntodroid.interestcalculator.views;

import android.os.Bundle;
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

        recyclerView = findViewById(R.id.activity_main_recycler_view);

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
        recyclerViewAdapter = new ResultsAdapter(this, viewModel.getResults().getValue());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
