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
    }

    public boolean addStudent(int row, int seatInRow, Student student) {
        // TODO: populate students
        

        return false;
    }

    public void printRoom(int day) {
        // TODO: print out the room on this day
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
