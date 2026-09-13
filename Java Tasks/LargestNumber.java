//Task2 2. Write a Java program
// to display Largest of three numbers.
import java.util.Scanner;

public class LargestNumber {

    public static void main (String[] args ){
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter the first number: ");
        double a = sc.nextDouble();
        System.out.println("Enter the second number: ");
        double b = sc.nextDouble();
        System.out.println("Enter the third number: ");
        double c = sc.nextDouble();

        double largest;

        if (a > b && a  > c){
            largest = a;
        }
        else if (a < b && b > c){
            largest = b;
        }
        else {
            largest = c;

        }

        System.out.println("The largest number is: " + largest);
        sc.close();

    }



}//void main