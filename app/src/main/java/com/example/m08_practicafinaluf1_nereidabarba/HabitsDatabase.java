package com.example.m08_practicafinaluf1_nereidabarba;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

public abstract class HabitsDatabase extends RoomDatabase {

    private static volatile HabitsDatabase INSDB;

    static HabitsDatabase obtenerInstancia(final Context context) {
        if (INSDB == null) {
            synchronized (HabitsDatabase.class) {
                if (INSDB == null) {
                    INSDB = Room.databaseBuilder(context,
                                   HabitsDatabase.class, "habits.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSDB;
    }

    @Override
    public void clearAllTables() {

    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration) {
        return null;
    }
}


