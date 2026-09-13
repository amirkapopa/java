public class Loan {
    private static final byte MONTHS_IN_YEARS = 12;
    private static final byte PERCENT= 100;

    private final double principal;
    private final double annualInterestRate;
    private final int period;

    public Loan(double principal, double annualInterestRate,int period) {
        this.principal=principal;
        this.annualInterestRate=annualInterestRate;
        this.period=period;
    }


    public  int  getNumbersOfPayments()
      {return period * MONTHS_IN_YEARS; }

    private double getMonthlyInterestRate()
     {return annualInterestRate/PERCENT/MONTHS_IN_YEARS;}

    public double calculateMortgage() {
        double monthlyInterestRate = getMonthlyInterestRate();
        int numberOfPayments = getNumbersOfPayments();


        return(principal * monthlyInterestRate
                * Math.pow(1+monthlyInterestRate,numberOfPayments))
                /(Math.pow(1+monthlyInterestRate,numberOfPayments)-1);

    }//calculateMortage

    public double calculateBalance(int numberOfPaymentsMade) {
        double monthlyInterestRate = getMonthlyInterestRate();
        int numberOfPayments = getNumbersOfPayments();

        double totaGrowth=Math.pow(1+
                annualInterestRate,numberOfPayments);

        double paidGrowth=Math.pow(1+
                monthlyInterestRate,numberOfPaymentsMade);

        return principal *( totaGrowth - paidGrowth) / (totaGrowth -1);




    }



}