package com.learntodroid.interestcalculator.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.learntodroid.interestcalculator.R;
import com.learntodroid.interestcalculator.model.FinancialResult;

import java.text.NumberFormat;
import java.util.List;

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
        ((ResultsViewHolder) viewHolder).description.setText(results.get(i).getDescription());

        NumberFormat format = NumberFormat.getCurrencyInstance();
        ((ResultsViewHolder) viewHolder).result.setText(format.format(results.get(i).getResult()));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    static class ResultsViewHolder extends RecyclerView.ViewHolder {
        public TextView description, result;

        public ResultsViewHolder(@NonNull View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.recyclerview_item_description);
            result = itemView.findViewById(R.id.recyclerview_item_result);
        }
    }
}
