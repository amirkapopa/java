//Task3Write a Java program to check
// whether the given number is even or odd.
//U2510164
import java.util.Scanner;

public class EvenOdd {
    public static void main(String[]  args ){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter an Integer: ");
        int num=sc.nextInt();

        if ( num % 2 ==0  ) {
            System.out.println("The number is even");
        }
        else {
            System.out.println("The number is odd");
        }

        sc.close();



    }

}//EvenOdd