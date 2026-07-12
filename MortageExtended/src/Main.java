import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    final static  byte MONTHS_IN_YEARS = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int  principal=(int) readNumber("Principal:", 1000,1_000_000);
        float annualInterestRate=(float) readNumber("Annual Interest Rate: ", 1,30);
        int period=(int) readNumber("Period(Years):", 1,12);

        printMortgage(principal, annualInterestRate, period);
        printPaymentSchedule(period, principal, annualInterestRate);

    }

    private static void printMortgage(int principal, float annualInterestRate, int period) {
        double Mortgage = calculateMortgage(principal, annualInterestRate, period);
        String mortgageFormat = NumberFormat.getCurrencyInstance().format(Mortgage);
        System.out.println();
        System.out.println("Mortgage");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormat);
    }

    private static void printPaymentSchedule(int period, int principal, float annualInterestRate) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= period *MONTHS_IN_YEARS; month++){
           double balance = calculateBalance(principal, annualInterestRate, period, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));;
        }
    }

    public static double readNumber(String prompt,double min,double max) {
        Scanner scanner = new Scanner(System.in);

        double value;

        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Please enter a number between"+ min + "and "+ max);
        }//while
        return value;
    }


    public static double calculateBalance(
            double principal,
            double annualInterestRate,
            int period,
            short numbeOfPaymentsMade
    )  {
        double monthlyRate = annualInterestRate / PERCENT / MONTHS_IN_YEARS;
        short numberPayments = (short)(MONTHS_IN_YEARS * period);

        double balance= principal
                * (Math.pow(1 + monthlyRate, numberPayments) - (Math.pow(1 + monthlyRate, numbeOfPaymentsMade))
                / (Math.pow(1 + monthlyRate, numberPayments) - 1));

        return balance;

    }

    public static double calculateMortgage(
            double principal,
            double annualInterestRate,
            int period) {

        double monthlyRate = annualInterestRate / PERCENT / MONTHS_IN_YEARS;
        short numberPayments = (short)(MONTHS_IN_YEARS * period);

        double Mortgage = (principal * monthlyRate) *
                (Math.pow(1 + monthlyRate, numberPayments))
                / ((Math.pow(1 + monthlyRate, numberPayments) - 1));

        return Mortgage;

    }
}