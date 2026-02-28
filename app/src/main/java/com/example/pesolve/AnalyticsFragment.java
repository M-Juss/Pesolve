package com.example.pesolve;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pesolve.databinding.FragmentAnalyticsBinding;

public class AnalyticsFragment extends Fragment {

    FragmentAnalyticsBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        binding = FragmentAnalyticsBinding.inflate(inflater, container, false);









        return binding.getRoot();
    }
}