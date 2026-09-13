//Task4 Write a Java program to find
// the Factorial of a given number.

//U2510164

import java.util.Scanner;

public class FactroialNumber {

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        if (num <2 ) {
            System.out.println("Invalid number please enter a non-negative number");
            sc.nextLine();
            return;
        }//if

        long factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }//for loop

        System.out.println(num + "!=" + factorial);

        sc.close();

    }//void main

}//FactroialNumber
