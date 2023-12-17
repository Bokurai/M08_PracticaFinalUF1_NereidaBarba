package com.example.m08_practicafinaluf1_nereidabarba;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.time.LocalDate;

@Entity
public class Habit {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private int frequency;
    @ColumnInfo(name = "start_date")
    private LocalDate startDate;
    @ColumnInfo(name = "checked")
    private boolean checked;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public int getFrequency() {
        return frequency;
    }


    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Habit(int id, String title, int frequency, LocalDate startDate) {
        this.id = id;
        this.title = title;
        this.frequency = frequency;
        this.startDate = startDate;
    }

    public Habit(String title) {
        this.title = title;
    }
}
