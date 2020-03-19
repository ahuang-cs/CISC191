package edu.sdccd.cisc191;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<Disease> diseaseHistory;
    private char health = 'O';

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.diseaseHistory = new ArrayList<>();
        this.health = 'O';
    }

    /**
     * Return Student's disease list.
     * @param day the day the student's diseases are requested
     *
     */
    public List<Disease> getContagiousDiseasesByDay(int day) {
       // List<Disease> diseases = new ArrayList<>();

        //get current infection history
        //List<Infection> current = this.getInfectionHistory();

        //grab diseases and return
        //for (int count = 0; count < current.size(); count++) {
            //diseases.add(current.getDisease());
        //}
        return diseaseHistory;
    }

    /**
     * Add disease to Student's previous disease list . It is added at the end of the list.
     * @param dis the non-null card to be added.
     * @throws NullPointerException if the parameter c is null.
     */
    public void addDiseaseHistory(Disease dis){
        if (dis == null)
            throw new NullPointerException("Can't add disease to Student's history.");
        diseaseHistory.add(dis);
    }

    /**
     * This method checks to see if a student is absent because of health status
     * and returns false if student is present in class
     * @param day
     * @return
     */
    public boolean isAbsentOnDay(int day) {
        //if Student is absent('-'), dying('/'), or dead(':'), return true
        if(this.getHealth() == '-' || this.getHealth() == '/' || this.getHealth() == ':'){
            return true;
        }
        return false;
    }
    public char getHealth() {return health;}

    public void setHealth(char newHealth){ this.health = newHealth;}

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

    public List<Disease> getDiseaseHistory() {
        return diseaseHistory;
    }

    public void setDiseaseHistory(List<Disease> diseaseHistory) {
        this.diseaseHistory = diseaseHistory;
    }
}
