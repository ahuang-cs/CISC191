package edu.sdccd.cisc191;

import java.util.Scanner;

public class lab3 {
    public static void main(String[] args) {
        try {
            //Ask use to choose random seat to infect
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a number between 1 and 4");
            int row = scanner.nextInt();
            System.out.println("Please enter a number between 1 and 10");
            int seat = scanner.nextInt();


            // initialize Disease
            Disease covid19 = new Disease(1, "Covid-19", 1, 1, true, false, 0);

            // initialize Room of Students
            Room classRoom = new Room(191, 200, 4, 10);


            // initialize day
            int day = 0;
            Infection test = new Infection(covid19, day);

            // infect first student
            Student[][] initialInfect = new Student[4][10];
            for ( int ro = 0; ro < 4; row++ ) {
                for (int col = 1; col < 10; col++) {
                    for (int sID = 0; sID < 4 * 10; sID++) {
                        initialInfect[row][col] = new Student(sID, "Unnamed");
                    }
                }
            }
            initialInfect = classRoom.getStudents();
            initialInfect[row][seat].setHealth('X');

            // loop on keypress: set Day, process Student infections, print class attendance seating chart
            do {
                classRoom.printRoom(day);
                test.processInfections(classRoom);
                day++;
            } while (scanner.nextLine() != null);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}


