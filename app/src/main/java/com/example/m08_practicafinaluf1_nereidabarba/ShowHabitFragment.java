package com.example.m08_practicafinaluf1_nereidabarba;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.m08_practicafinaluf1_nereidabarba.databinding.FragmentShowHabitBinding;

public class ShowHabitFragment extends Fragment {
    private FragmentShowHabitBinding binding;
    private HabitsViewModel habitsViewModel;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentShowHabitBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        habitsViewModel = new ViewModelProvider(requireActivity()).get(HabitsViewModel.class);

        habitsViewModel.selectedHabit.observe(getViewLifecycleOwner(), new Observer<Habit>() {
            @Override
            public void onChanged(Habit habit) {
                binding.titleshowhabit.setText(habit.getTitle());
                setupCheckBoxes(habit);
                habitsViewModel.actualizar(habit);
            }
        });
    }

    private void setupCheckBoxes(Habit habit) {
        CompoundButton.OnCheckedChangeListener checkBoxListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int day = getDayFromCheckBoxId(buttonView.getId());
                habit.setDaySelected(day, isChecked);
                habitsViewModel.actualizar(habit);
            }
        };

        binding.mondayCheckBox.setOnCheckedChangeListener(checkBoxListener);
        binding.tuesdayCheckBox.setOnCheckedChangeListener(checkBoxListener);
        binding.wednesdayCheckBox.setOnCheckedChangeListener(checkBoxListener);
        binding.thursdayCheckBox.setOnCheckedChangeListener(checkBoxListener);
        binding.fridayCheckBox.setOnCheckedChangeListener(checkBoxListener);
        binding.saturdayCheckBox.setOnCheckedChangeListener(checkBoxListener);
        binding.sundayCheckBox.setOnCheckedChangeListener(checkBoxListener);


        binding.mondayCheckBox.setChecked(habit.isDaySelected(0));
        binding.tuesdayCheckBox.setChecked(habit.isDaySelected(1));
        binding.wednesdayCheckBox.setChecked(habit.isDaySelected(2));
        binding.thursdayCheckBox.setChecked(habit.isDaySelected(3));
        binding.fridayCheckBox.setChecked(habit.isDaySelected(4));
        binding.saturdayCheckBox.setChecked(habit.isDaySelected(5));
        binding.sundayCheckBox.setChecked(habit.isDaySelected(6));
    }

    private int getDayFromCheckBoxId(int checkBoxId) {
        if (checkBoxId == R.id.mondayCheckBox) {
            return 0;
        } else if (checkBoxId == R.id.tuesdayCheckBox) {
            return 1;
        } else if (checkBoxId == R.id.wednesdayCheckBox) {
            return 2;
        } else if (checkBoxId == R.id.thursdayCheckBox) {
            return 3;
        } else if (checkBoxId == R.id.fridayCheckBox) {
            return 4;
        } else if (checkBoxId == R.id.saturdayCheckBox) {
            return 5;
        } else if (checkBoxId == R.id.sundayCheckBox) {
            return 6;
        } else {
            return -1;
        }
    }
}