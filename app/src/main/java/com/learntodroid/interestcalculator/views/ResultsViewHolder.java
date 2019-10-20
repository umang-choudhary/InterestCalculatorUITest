package com.learntodroid.interestcalculator.views;

import android.view.View;
import android.widget.TextView;

import com.learntodroid.interestcalculator.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ResultsViewHolder extends RecyclerView.ViewHolder {
    public TextView period, result;

    public ResultsViewHolder(@NonNull View itemView) {
        super(itemView);

        period = itemView.findViewById(R.id.recyclerview_item_period);
        result = itemView.findViewById(R.id.recyclerview_item_result);
    }
}
