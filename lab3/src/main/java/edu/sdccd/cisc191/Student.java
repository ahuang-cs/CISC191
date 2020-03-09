package edu.sdccd.cisc191;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<Infection> infectionHistory;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.infectionHistory = new ArrayList<>();
    }

    public List<Disease> getContagiousDiseasesByDay(int day) {
        List<Disease> diseases = new ArrayList<>();
        // TODO: fill this out

        return diseases;
    }

    public boolean isAbsentOnDay(int day) {
        // TODO: fill this out

        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Infection> getInfectionHistory() {
        return infectionHistory;
    }

    public void setInfectionHistory(List<Infection> infectionHistory) {
        this.infectionHistory = infectionHistory;
    }
}
