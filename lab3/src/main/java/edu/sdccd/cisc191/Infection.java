package edu.sdccd.cisc191;

public class Infection {
    private Disease disease;
    private int dayInfected;

    public Infection(Disease disease, int dayInfected) {
        this.disease = disease;
        this.dayInfected = dayInfected;
    }

    /**
     * Iterates through the seats and spreads infection if found
     *
     * @param classRoom the room in which the infections is to be spread
     * @return today's seating chart after infection
     */
    public char[][] processInfections(Room classRoom) {
        //get students in classroom
        Student[][] newStudents = classRoom.getStudents();
        //initiate char array to process the student's health
        char[][] newSeats = initSeats('.', classRoom.getRows(), classRoom.getSeatsPerRow());
        //get last day's infections and process
        for (int i = 0; i < classRoom.getRows(); i++) {
            for (int j = 0; j < classRoom.getSeatsPerRow(); j++) {
                if (newStudents[i][j].getHealth() == '-' || newStudents[i][j].getHealth() == '/') {
                    //change them and set to new day
                    newSeats[i][j] = getNextInfectedState(newStudents[i][j].getHealth(), newStudents[i] == newStudents[i]);
                    //Update student's health
                    newStudents[i][j].setHealth(newSeats[i][j]);
                    newStudents[i][j].addDiseaseHistory(this.getDisease());
                } else if (newStudents[i][j].getHealth() == 'X') {
                    //change them and set to new day
                    //Update student's health
                    newSeats[i][j] = getNextInfectedState(newStudents[i][j].getHealth(), newStudents[i] == newStudents[i]);
                    newStudents[i][j].setHealth(newSeats[i][j]);
                    newStudents[i][j].addDiseaseHistory(this.getDisease());

                    //change those around them, in surrounding grid, and set to new day
                    newSeats[i][j + 1] = getNextInfectedState(newStudents[i][j].getHealth(), newStudents[i] == newStudents[i]);
                    newSeats[i][j - 1] = getNextInfectedState(newStudents[i][j].getHealth(), newStudents[i] == newStudents[i]);
                    newSeats[i + 1][j] = getNextInfectedState(newStudents[i][j].getHealth(), newStudents[i + 1] == newStudents[i]);
                    newSeats[i - 1][j] = getNextInfectedState(newStudents[i][j].getHealth(), newStudents[i - 1] == newStudents[i]);
                    newSeats[i + 1][j + 1] = getNextInfectedState(newStudents[i][j].getHealth(), newStudents[i + 1] == newStudents[i]);
                    newSeats[i + 1][j - 1] = getNextInfectedState(newStudents[i][j].getHealth(), newStudents[i + 1] == newStudents[i]);
                    newSeats[i - 1][j - 1] = getNextInfectedState(newStudents[i][j].getHealth(), newStudents[i - 1] == newStudents[i]);
                    newSeats[i - 1][j + 1] = getNextInfectedState(newStudents[i][j].getHealth(), newStudents[i - 1] == newStudents[i]);

                    //Update student's health
                    newStudents[i][j + 1].setHealth(newSeats[i][j]);
                    newStudents[i][j - 1].setHealth(newSeats[i][j]);
                    newStudents[i + 1][j].setHealth(newSeats[i][j]);
                    newStudents[i - 1][j].setHealth(newSeats[i][j]);
                    newStudents[i + 1][j + 1].setHealth(newSeats[i][j]);
                    newStudents[i + 1][j - 1].setHealth(newSeats[i][j]);
                    newStudents[i - 1][j - 1].setHealth(newSeats[i][j]);
                    newStudents[i - 1][j + 1].setHealth(newSeats[i][j]);

                    //Update their disease history
                    newStudents[i][j+1].addDiseaseHistory(this.getDisease());
                    newStudents[i][j-1].addDiseaseHistory(this.getDisease());
                    newStudents[i+1][j].addDiseaseHistory(this.getDisease());
                    newStudents[i-1][j].addDiseaseHistory(this.getDisease());
                    newStudents[i+1][j+1].addDiseaseHistory(this.getDisease());
                    newStudents[i+1][j-1].addDiseaseHistory(this.getDisease());
                    newStudents[i-1][j-1].addDiseaseHistory(this.getDisease());
                    newStudents[i-1][j+1].addDiseaseHistory(this.getDisease());

                }
            }
        }

        // fill any seats that weren't processed
        for (int i = 0; i < classRoom.getRows(); i++) {
            for (int j = 0; j < classRoom.getSeatsPerRow(); j++) {
                if (newSeats[i][j] == '.') {
                    newSeats[i][j] = newStudents[i][j].getHealth();
                }
            }
        }
        return newSeats;
    }

    /**
     * Internal helper method to initialize an array of
     * chars that will be filled by Student's updated health status.
     *
     * @param initState the char to initialize the array to
     * @param rows      the room's count of rows
     * @param rowSeats  the room's seat per row
     * @return 4x10 two dimensional array of Os or healthy students
     */
    public static char[][] initSeats(char initState, int rows, int rowSeats) {
        char[][] seats = new char[4][10];
        //loop through all the rows and columns
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 10; col++) {
                //initialize all student's health to specified char
                seats[row][col] = initState;
            }

        }
        return seats;
    }


    /**
     * Handles the infection next state mapping
     *
     * @param curState  yesterday's state
     * @param inSameRow kills adjacent healthy neighbors
     * @return
     */
    public static char getNextInfectedState(char curState, boolean inSameRow) {
        switch (curState) {
            case 'O':       // if healthy, infect, if also in same row, dying
                return inSameRow ? '/' : 'X';
            case '/':       // if dying, die
                return ':';
            case 'X':       // if infected, stay home sick
                return '-';
            case '-':       // if absent, return healthy
                return 'O';
            default:        // if dead, stay dead
                return curState;
        }
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

