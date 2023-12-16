package com.example.m08_practicafinaluf1_nereidabarba;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;
@Entity
public class Habit {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private int frequency;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getFrequency() {
        return frequency;
    }

    public Habit(int id, String title, String description, int frequency) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.frequency = frequency;
    }

}
