package com.learntodroid.interestcalculator.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learntodroid.interestcalculator.R;
import com.learntodroid.interestcalculator.model.FinancialResult;
import com.learntodroid.interestcalculator.views.ResultsViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class ResultsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<FinancialResult> results;

    public ResultsAdapter(Context context, List<FinancialResult> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public ResultsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, viewGroup, false);
        ResultsViewHolder vh = new ResultsViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ((ResultsViewHolder) viewHolder).period.setText("Period: " + results.get(i).getPeriod());
        ((ResultsViewHolder) viewHolder).result.setText("Result: " + results.get(i).getResult());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
