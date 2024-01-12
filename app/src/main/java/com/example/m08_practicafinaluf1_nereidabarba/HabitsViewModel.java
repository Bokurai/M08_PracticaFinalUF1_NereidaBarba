package com.example.m08_practicafinaluf1_nereidabarba;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class HabitsViewModel extends AndroidViewModel {

    private HabitRepository habitRepository;

    private LiveData<List<Habit>> hbLiveData;

    MutableLiveData<Habit> selectedHabit = new MutableLiveData<>();

    public HabitsViewModel(@NonNull Application application) {
        super(application);

        habitRepository = new HabitRepository(application);
        hbLiveData = habitRepository.obtener();
    }

    LiveData<List<Habit>> obtener() {
        return hbLiveData;
    }

    void insertar(Habit habit) {
        habitRepository.insertar(habit);
    }

    void eliminar(Habit habit) {
        habitRepository.eliminar(habit);
    }

    void actualizar(Habit habit) {
        habit.setChecked(!habit.isChecked());
        Log.d("ViewModel", "Actualizar habit: " + habit.getId() + ", isChecked: " + habit.isChecked());
        habitRepository.actualizar(habit);
    }

    void select(Habit habit) {
        selectedHabit.setValue(habit);
    }

    MutableLiveData<Habit> getSelectedHabit() {
        return selectedHabit;
    }

    // Método para obtener el título del hábito seleccionado
    String getSelectedHabitTitle() {
        Habit habit = selectedHabit.getValue();
        return habit != null ? habit.getTitle() : "";
    }
}
