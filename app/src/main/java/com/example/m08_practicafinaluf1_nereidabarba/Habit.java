package com.example.m08_practicafinaluf1_nereidabarba;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Habit {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habit habit = (Habit) o;
        return id == habit.id && frequency == habit.frequency && Objects.equals(title, habit.title) && Objects.equals(description, habit.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, frequency);
    }

    @NonNull
    @Override
    public String toString() {
        return "Habit{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", frequency=" + frequency +
                '}';
    }


}
