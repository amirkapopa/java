import java.text.NumberFormat;
import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);
    private final NumberFormat currency = NumberFormat.getCurrencyInstance();


    public double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Please enter a number between " + min + " and " + max);
        }//while

        return value;

    }//readnumber

    public void printMortgage(Loan loan) {
        String formatted = currency.format(loan.calculateMortgage());
        System.out.println();
        System.out.println("Mortgage");
        System.out.println("--------");
        System.out.println("Monthly Payments:" + formatted);
    }

    public void printPaymentSchedule(Loan loan) {
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("--------");
        for (int month = 1; month <= loan.getNumbersOfPayments(); month++) {
            double balance = loan.calculateBalance(month);
            System.out.println(currency.format(balance));
        }
    }

}