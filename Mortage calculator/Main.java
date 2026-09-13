import java.io.Console;

public class Main {
    public static void main(String [] args) {
        ConsoleUI ui= new ConsoleUI();

        int principal=(int) ui.readNumber("Principal:",1000,1_000_000);
        float annualInterestRate=(float) ui.readNumber("Annual Interest Rate:",1,30);
    int period=(int) ui.readNumber("Period (Years): " ,1 ,12 );


    Loan loan=new Loan(principal,annualInterestRate,period);

    ui.printMortgage(loan);
    ui.printPaymentSchedule(loan);

    }
    
}