package com.example.pesolve;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pesolve.databinding.FragmentTrasanctionBinding;


public class TrasanctionFragment extends Fragment {
    View view;
    FragmentTrasanctionBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentTrasanctionBinding.inflate(inflater, container, false);

        binding.expenseButton.setSelected(true);
        binding.incomeButton.setSelected(false);

        binding.expenseButton.setOnClickListener(v -> {
            binding.expenseButton.setSelected(true);
            binding.incomeButton.setSelected(false);
        });

        binding.incomeButton.setOnClickListener(v -> {
            binding.incomeButton.setSelected(true);
            binding.expenseButton.setSelected(false);

        });

        return binding.getRoot();


    }

}