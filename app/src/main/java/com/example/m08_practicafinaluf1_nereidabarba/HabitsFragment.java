package com.example.m08_practicafinaluf1_nereidabarba;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m08_practicafinaluf1_nereidabarba.databinding.FragmentHabitsBinding;
import com.example.m08_practicafinaluf1_nereidabarba.databinding.ViewholderHabitBinding;

import java.util.ArrayList;
import java.util.List;

public class HabitsFragment extends Fragment {

    private FragmentHabitsBinding binding;
    private HabitsViewModel habitsViewModel;
    private HabitsAdapter habitsAdapter;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentHabitsBinding.inflate(inflater, container, false)).getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        habitsViewModel = new ViewModelProvider(this).get(HabitsViewModel.class);
        navController = Navigation.findNavController(view);

        RecyclerView recyclerView = binding.habitRV;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        habitsAdapter = new HabitsAdapter();
        recyclerView.setAdapter(habitsAdapter);
        binding.addHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_habitsFragment_to_newHabitFragment);
            }
        });


        habitsViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<Habit>>() {
            @Override
            public void onChanged(List<Habit> habits) {
                habitsAdapter.setHBList(habits);
            }
        });
    }

    class HabitsAdapter extends RecyclerView.Adapter<HabitViewHolder> {
        private List<Habit> hbList;

        public HabitsAdapter() {
            this.hbList = new ArrayList<>();
        }

        @NonNull
        @Override
        public HabitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new HabitViewHolder(ViewholderHabitBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull HabitViewHolder viewHolder, int position){
          Habit habit = hbList.get(position);

          viewHolder.binding.weekdayViewholder.setText(habit.title);

          viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  habitsViewModel.select(habit);
                  navController.navigate(R.id.action_habitsFragment_to_showHabitFragment);
              }
          });
        }

        @Override
        public int getItemCount(){
            return hbList != null ? hbList.size() : 0;
        }

        public void setHBList(List<Habit> habits) {
            this.hbList = habits;
            notifyDataSetChanged();
        }

        public Habit obtenerHabits(int position){
            return hbList.get(position);
        }

    }

    static class HabitViewHolder extends RecyclerView.ViewHolder{
        private final ViewholderHabitBinding binding;

        public HabitViewHolder(ViewholderHabitBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

    }
    }
