package com.example.pesolve;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pesolve.databinding.FragmentTrasanctionBinding;

public class TrasanctionFragment extends Fragment {

    private FragmentTrasanctionBinding binding;
    private StringBuilder amount = new StringBuilder();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTrasanctionBinding.inflate(inflater, container, false);


        binding.expenseButton.setSelected(true);
        binding.incomeButton.setSelected(false);

        binding.amountText.setText("0.00");

        binding.one.setOnClickListener(v -> appendNumber("1"));
        binding.two.setOnClickListener(v -> appendNumber("2"));
        binding.three.setOnClickListener(v -> appendNumber("3"));
        binding.four.setOnClickListener(v -> appendNumber("4"));
        binding.five.setOnClickListener(v -> appendNumber("5"));
        binding.six.setOnClickListener(v -> appendNumber("6"));
        binding.seven.setOnClickListener(v -> appendNumber("7"));
        binding.eigth.setOnClickListener(v -> appendNumber("8"));
        binding.nine.setOnClickListener(v -> appendNumber("9"));
        binding.zero.setOnClickListener(v -> appendNumber("0"));


        binding.point.setOnClickListener(v -> {
            if (!amount.toString().contains(".")) {
                appendNumber(".");
            }
        });

        binding.delete.setOnClickListener(v -> {
            amount.setLength(0);
            updateAmountDisplay();
        });


        binding.expenseButton.setOnClickListener(v -> {
            binding.expenseButton.setSelected(true);
            binding.incomeButton.setSelected(false);
        });


        binding.incomeButton.setOnClickListener(v -> {
            binding.incomeButton.setSelected(true);
            binding.expenseButton.setSelected(false);
        });

        binding.categoryPicker.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Category Picker", Toast.LENGTH_SHORT).show();
        });

        binding.datePicker.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Date Picker", Toast.LENGTH_SHORT).show();
        });

        return binding.getRoot();
    }

    private void appendNumber(String number) {
        amount.append(number);
        updateAmountDisplay();
    }

    private void updateAmountDisplay() {
        if (amount.length() == 0) {
            binding.amountText.setText("0.00");
        } else {
            binding.amountText.setText(amount.toString());
        }
    }

}