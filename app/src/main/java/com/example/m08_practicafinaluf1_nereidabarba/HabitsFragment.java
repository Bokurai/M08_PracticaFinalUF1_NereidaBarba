package com.example.m08_practicafinaluf1_nereidabarba;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m08_practicafinaluf1_nereidabarba.databinding.FragmentHabitsBinding;
import com.example.m08_practicafinaluf1_nereidabarba.databinding.FragmentHomeBinding;


public class HabitsFragment extends Fragment {

    private FragmentHabitsBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentHabitsBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}