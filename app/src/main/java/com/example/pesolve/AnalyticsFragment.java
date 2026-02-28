package com.example.pesolve;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.pesolve.databinding.FragmentAnalyticsBinding;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.List;

public class AnalyticsFragment extends Fragment {

    private FragmentAnalyticsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAnalyticsBinding.inflate(inflater, container, false);

        setupPieChart();
        setupWeeklyBarChart();

        return binding.getRoot();
    }

    // ================= PIE CHART =================

    private void setupPieChart() {

        float income = 100412f;
        float expense = 80412f;

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(income, "Income"));
        entries.add(new PieEntry(expense, "Expense"));

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(
                Color.parseColor("#4CAF50"), // Green
                Color.parseColor("#F44336")  // Red
        );

        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(14f);

        PieData pieData = new PieData(dataSet);
        pieData.setValueFormatter(new PercentFormatter(binding.pieChart));

        binding.pieChart.setUsePercentValues(true);
        binding.pieChart.setData(pieData);

        binding.pieChart.getDescription().setEnabled(false);
        binding.pieChart.setEntryLabelColor(Color.WHITE);
        binding.pieChart.setEntryLabelTextSize(12f);

        binding.pieChart.setDrawHoleEnabled(true);
        binding.pieChart.setHoleRadius(60f);
        binding.pieChart.setTransparentCircleRadius(65f);

        binding.pieChart.setCenterText("Income vs Expense");
        binding.pieChart.setCenterTextColor(Color.WHITE);
        binding.pieChart.setCenterTextSize(16f);

        binding.pieChart.getLegend().setTextColor(Color.WHITE);

        binding.pieChart.animateY(1000, Easing.EaseInOutQuad);
        binding.pieChart.invalidate();
    }

    // ================= 7 DAY BAR CHART =================

    private void setupWeeklyBarChart() {

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 500f));  // Mon
        entries.add(new BarEntry(1f, 800f));  // Tue
        entries.add(new BarEntry(2f, 650f));  // Wed
        entries.add(new BarEntry(3f, 900f));  // Thu
        entries.add(new BarEntry(4f, 700f));  // Fri
        entries.add(new BarEntry(5f, 1200f)); // Sat
        entries.add(new BarEntry(6f, 400f));  // Sun

        BarDataSet dataSet = new BarDataSet(entries, "7 Day Spending");
        dataSet.setColor(Color.parseColor("#FF5252")); // Red for spending
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(10f);

        BarData barData = new BarData(dataSet);
        barData.setBarWidth(0.6f);

        binding.barChart.setData(barData); // Using your existing id

        // X Axis Labels
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        XAxis xAxis = binding.barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        xAxis.setGranularity(1f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setDrawGridLines(false);

        binding.barChart.getAxisLeft().setTextColor(Color.WHITE);
        binding.barChart.getAxisRight().setEnabled(false);

        binding.barChart.getDescription().setEnabled(false);
        binding.barChart.getLegend().setTextColor(Color.WHITE);

        binding.barChart.animateY(1000);
        binding.barChart.invalidate();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}