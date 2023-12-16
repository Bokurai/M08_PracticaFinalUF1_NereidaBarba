package com.example.m08_practicafinaluf1_nereidabarba;

import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HabitRepository {
    Executor exec = Executors.newSingleThreadExecutor();
    private HabitsDatabase.HabitDao habitDao;

    public HabitRepository(Application application){
        habitDao = HabitsDatabase.obtenerInstancia(application).habitDao();
    }

    LiveData<List<Habit>> obtener(){
        return habitDao.obtener();
    }

    void insertar(Habit elemento){
        exec.execute(new Runnable() {
            @Override
            public void run() {
                habitDao.insertar(elemento);
            }
        });
    }

    void eliminar(Habit elemento) {
        exec.execute(new Runnable() {
            @Override
            public void run() {
                habitDao.eliminar(elemento);
            }
        });
    }

    public void actualizar(Habit elemento) {
        exec.execute(new Runnable() {
            @Override
            public void run() {
                habitDao.actualizar(elemento);
            }
        });
    }
}
