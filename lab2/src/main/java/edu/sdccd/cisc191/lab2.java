package edu.sdccd.cisc191;

import java.util.Scanner;

/**
 * lab2 is a covid-19 classroom infection simulator
 *
 * @author
 */
public class lab2 {
    public static void main(String[] args) {
        if(args.length < 2) {
            printUsage();
            System.exit(1);
        }
        try {
            Scanner scanner = new Scanner(System.in);

            int row = Integer.valueOf(args[0]);
            int seat = Integer.valueOf(args[1]);

            // init your classroom with Os healthy, X means infected and present, - means absent, / means infected and dying (but printed as -), : means dead (but printed as -)
            char[][] seats = initSeats('O');

            // initialize day
            int day = 0;

            // infect first student
            seats[row][seat] = 'X';

            do {
                printClassroomOnDay(day, seats);
                seats = processInfections(seats);
                day++;
            } while(scanner.nextLine() != null);

        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Handles the infection next state mapping
     * @param curState yesterday's state
     * @param inSameRow kills adjacent healthy neighbors
     * @return
     */
    public static char getNextInfectedState(char curState, boolean inSameRow) {
        switch(curState) {
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

    /**
     * Iterates through the seats and spreads infection if found
     * @param seats yesterday's seating chart
     * @return today's seating chart after infection
     */
    public static char[][] processInfections(char[][] seats) {
        char[][] newSeats = initSeats('.');

        // TODO

        // fill any seats that weren't processed
        for(int i=0; i<newSeats.length; i++) {
            for (int j = 0; j < newSeats[i].length; j++) {
                if (newSeats[i][j] == '.') {
                    newSeats[i][j] = seats[i][j];
                }
            }
        }
        return newSeats;
    }

    /**
     * Prints the help file
     */
    public static void printUsage() {
        System.out.println("Usage:");
        System.out.println("java -jar lab2.java $ROW $SEAT");
    }

    /**
     * Initializes all the seats to initState: Os healthy, X means infected and present, - means absent, / means infected and dying (but printed as -), : means dead (but printed as -)
     * @param initState
     * @return 4x10 two dimensional array of Os or healthy students
     */
    public static char[][] initSeats(char initState) {
        char[][] seats = new char[4][10];

        // TODO

        return seats;
    }

    /**
     * Prints the current classroom state to stdout
     * @param day simulated day
     * @param seats two dimensional char array representing student health
     */
    public static void printClassroomOnDay(int day, char[][] seats) {
        System.out.printf("%nDay %d%n", day);
        for(int i=0; i<seats.length; i++) {
            for(int j=0; j<seats[i].length; j++) {

                switch(seats[i][j]){
                    case ':':   // if student dead, mark absent
                        System.out.print('-');
                        break;
                    case '/':   // if student dying, mark infected
                        System.out.print('X');
                        break;
                    default:
                        System.out.print(seats[i][j]);
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
