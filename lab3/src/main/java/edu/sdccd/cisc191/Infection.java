package edu.sdccd.cisc191;

public class Infection {
    private Disease disease;
    private int dayInfected;

    public Infection(Disease disease, int dayInfected) {
        this.disease = disease;
        this.dayInfected = dayInfected;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public int getDayInfected() {
        return dayInfected;
    }

    public void setDayInfected(int dayInfected) {
        this.dayInfected = dayInfected;
    }
}
