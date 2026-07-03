import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEARS = 12;
        final byte PERCENT = 100;

        Scanner input = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = input.nextInt();

        System.out.print("AnnualInterestRate: ");
        double annualInterestRate = input.nextDouble();
        double monthlyRate = annualInterestRate /PERCENT/MONTHS_IN_YEARS;

        System.out.print("Period(Years): ");
        int period = input.nextInt();
        int numberPayments =MONTHS_IN_YEARS*period;

        double Mortgage =(principal*monthlyRate)*
                         (Math.pow(1+monthlyRate,numberPayments))/((Math.pow(1+monthlyRate,numberPayments)-1));

        String mortgageFormat = NumberFormat.getCurrencyInstance().format(Mortgage);
        System.out.println("Mortgage: "+ mortgageFormat );



    }
}