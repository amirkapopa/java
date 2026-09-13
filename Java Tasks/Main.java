//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import  java.util.Scanner;
//U2510164
//Task1 1. Write a Java program to check
// the given integer is prime or not.

public class Main {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num =sc.nextInt();

        //Numbers less than 1 are automatically  not prime

        if (num <=1) {
            System.out.println(num + " is not a prime number");
            sc.close();
            return;
        }// if

        boolean isPrime = true;

        for (int i =2; i <=Math.sqrt(num); i++ ) {

            if (num % i==0) {
                isPrime = false;
                break;
            }//if

        }//for

        if ( isPrime) {
            System.out.println(num + " is a prime number");

        }// if isPrime
        else {
            System.out.println(num + " is not a prime number");
        }//else

        sc.close();




    }//public class void main




}//public class Main

