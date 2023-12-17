package com.example.m08_practicafinaluf1_nereidabarba;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.m08_practicafinaluf1_nereidabarba.databinding.FragmentNewHabitBinding;


public class NewHabitFragment extends Fragment {

    public static final String TAG = "NewHabitFragment";

    private FragmentNewHabitBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNewHabitBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newHabit();
            }
        });
        return view;
    }

    private void newHabit() {
        String nameHabit = binding.nombre.getText().toString().trim();

        if (!nameHabit.isEmpty()) {

            Habit newHabit = new Habit(nameHabit);

            HabitsViewModel habitsViewModel = new ViewModelProvider(requireActivity()).get(HabitsViewModel.class);
            habitsViewModel.insertar(newHabit);

        } else {
            Toast.makeText(requireContext(), "Please enter a habit name", Toast.LENGTH_SHORT).show();
        }
    }


}