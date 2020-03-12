package edu.sdccd.cisc191;

import java.util.Scanner;
public class lab2 {
    /***************************************************************************************
     Main squeeze area
     ****************************************************************************************/
    public static void main(String[] args) {
        //variables
        final int MAX_CHAR_INPUT = 256;
        char[][] students = new char[4][10];
        char[] input = new char[MAX_CHAR_INPUT];
        String inputStr = "";


        getUserInput(input);
        //test print input
        System.out.println(input[1]);




//        //fill seating chart
//        fillArray(students,'X');
//
//        //print chart
//        printChart(students);
//
//        //test prints
//        System.out.println("look, something from the array: " + students[3][9]);
//        System.out.println("look, something from my scanner: " + input);
    }//end main


    /***************************************************************************************
     function that asks the user for input
     ****************************************************************************************/
    static void getUserInput(char[] inputArr){
        //variable and object
        String inputRawStr = "";
        Scanner myScan = new Scanner(System.in);

        //ask user for input
        System.out.println("Please enter row and column seating, separated by single comma: ");
        inputRawStr = myScan.nextLine();

        //convert string into char array
        inputArr = inputRawStr.toCharArray();

        //test print input
        System.out.println(inputArr);
    }//end function

    /***************************************************************************************
     function that prints the chart of the classroom seating chart
     ****************************************************************************************/
    private void fillArray(char[][] students, char inputChar){
        //perform dummy loop
        for (int a = 0; a < 4; a++){
            for(int b = 0; b < 10; b++){
                students[a][b] = inputChar;
            }//end inner loop
        }//end out loop
    }//end function

    /***************************************************************************************
     function that prints the chart of the classroom seating chart
     ****************************************************************************************/
    private static void printChart(char[][] student){
        //perform dummy loop
        for (int a = 0; a < 4; a++){
            for(int b = 0; b < 10; b++){
                //print print print!
                System.out.print(student[a][b] + " ");
            }//end a loop

            //go to new row
            System.out.println("\n");
        }//end b loop
    }//end function
}//end class