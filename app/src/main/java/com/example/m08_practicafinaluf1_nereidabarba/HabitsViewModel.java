package com.example.m08_practicafinaluf1_nereidabarba;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class HabitsViewModel extends AndroidViewModel {

    private HabitRepository habitRepository;

    private LiveData<List<Habit>> hbLiveData;

    public HabitsViewModel(@NonNull Application application) {
        super(application);

        habitRepository = new HabitRepository(application);
        hbLiveData = habitRepository.obtener();;
    }

    LiveData<List<Habit>> obtener(){
        return hbLiveData;
    }

    void insertar(Habit habit){
        habitRepository.insertar(habit);
    }

    void eliminar(Habit habit){
        habitRepository.eliminar(habit);
    }

    void actualizar(Habit habit){
        habitRepository.actualizar(habit);
    }

}
