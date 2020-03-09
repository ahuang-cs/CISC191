package edu.sdccd.cisc191;

public class Disease {
    private int id;
    private String name;
    private int dormantDays; // (contagious days)
    private int sickDays;    // (absent from class, returns healthy after duration)
    private boolean deathByAdjacentInRow;
    private boolean deathByReinfection;
    private int deathByPercentChance;

    public Disease(int id, String name, int dormantDays, int sickDays, boolean deathByAdjacentInRow, boolean deathByReinfection, int deathByPercentChance) {
        this.id = id;
        this.name = name;
        this.dormantDays = dormantDays;
        this.sickDays = sickDays;
        this.deathByAdjacentInRow = deathByAdjacentInRow;
        this.deathByReinfection = deathByReinfection;
        this.deathByPercentChance = deathByPercentChance;
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

    public int getDormantDays() {
        return dormantDays;
    }

    public void setDormantDays(int dormantDays) {
        this.dormantDays = dormantDays;
    }

    public int getSickDays() {
        return sickDays;
    }

    public void setSickDays(int sickDays) {
        this.sickDays = sickDays;
    }

    public boolean isDeathByAdjacentInRow() {
        return deathByAdjacentInRow;
    }

    public void setDeathByAdjacentInRow(boolean deathByAdjacentInRow) {
        this.deathByAdjacentInRow = deathByAdjacentInRow;
    }

    public boolean isDeathByReinfection() {
        return deathByReinfection;
    }

    public void setDeathByReinfection(boolean deathByReinfection) {
        this.deathByReinfection = deathByReinfection;
    }

    public int getDeathByPercentChance() {
        return deathByPercentChance;
    }

    public void setDeathByPercentChance(int deathByPercentChance) {
        this.deathByPercentChance = deathByPercentChance;
    }
}
