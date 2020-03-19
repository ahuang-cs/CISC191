package edu.sdccd.cisc191;

public class Room {
    private int id;
    private int name;
    private int rows;
    private int seatsPerRow;
    private Student[][] students;

    public Room(int id, int name, int rows, int seatsPerRow) {
        this.id = id;
        this.name = name;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.students = new Student[rows][seatsPerRow];
        //initialize the room of Students and set student IDs & default names
        for ( int row = 0; row < rows; row++ ) {
            for ( int col = 1; col < seatsPerRow; col++ ) {
                for(int sID = 0; sID < rows*seatsPerRow; sID++) {
                    students[row][col] = new Student(sID, "Unnamed");
                }
            }
        }
    }

    /**This method adds a Student to the room
     *
     * @param row the row in which the Student is to be added
     * @param seatInRow the seat in which the student is to be added
     * @param student the Student to be added to the room
     * @return
     */
    public boolean addStudent(int row, int seatInRow, Student student) {

        //add slot for new student and get current students
        Student [][] newStudents = new Student[this.getRows()][this.getSeatsPerRow()+1];
        Student [][] currStudents = this.getStudents();

        //input new student in requested seat
        newStudents[row][seatInRow] = student;

        //fill in the rest of the class room around new student
        for (int newRow = 0; newRow < this.getRows(); newRow++) {
            for (int col = 0; col < this.getSeatsPerRow(); col++) {

                //When new student's seat is reached collect current student and change their seat
                if(newStudents[newRow][col] == newStudents[row][seatInRow]) {

                }
                else
                    newStudents[newRow][col] = currStudents[newRow][col];

            }
        } return false;
    }

    /**Prints the health of Students in the room
     * on a given day.
     * @param day
     */
    public void printRoom(int day) {
        // TODO: print out the room on this day
        char[][] seats = new char[this.rows][this.seatsPerRow];
            //loop through all the rows and columns
            for (int row = 0; row < this.rows; row++) {
                for (int col = 0; col < this.seatsPerRow; col++) {
                    //get Student's current health
                    seats[row][col] = students[row][col].getHealth();
                    //Print results
                    System.out.println(seats[row][col]);
                }
                System.out.print(" ");
            }
                System.out.println("");
        }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public Student[][] getStudents() {
        return students;
    }

    public void setStudents(Student[][] students) {
        this.students = students;
    }
}
