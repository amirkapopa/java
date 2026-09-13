//Task5 Write a Java program that accept two integers as
// its arguments and computes the value of
//first number raised to the power of second number.

//U2510164

import java.util.Scanner;
public class PowerNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the base number: ");
        int base = sc.nextInt();

        System.out.println("Enter the power number: ");
        int power = sc.nextInt();

        if (power < 0){
            System.out.println("The power number must be a positive integer");
            sc.close();
            return;
        }

        long result =1;
        for (int i = 1; i <=power; i++){
            result *= base;
        }
        System.out.println(base + " raised by the power of  " + power +
                " number " +  "= " + result);
    }// void main
}// PowerNumber
