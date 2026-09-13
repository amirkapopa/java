import java.util.Scanner;




public class TaylorSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value  of x (radians for the sin/cos): ");
        double x = sc.nextDouble();
        int terms=20;//term is the value at that positon

        double eResult = 0;
        double term = 1;

        for(int n=1; n<=terms;n++){

            eResult+=term;
            term=term * x/n ;

            System.out.println(("e^x = " + eResult));
        }//for

        System.out.println("-------NEXT TERM--------");

        double sinResult = 0;
        term = 1;
        for (int n=1; n<=terms;n++){

            sinResult +=term;
            term=term * (-x * x)/( ( 2*n ) * ( 2*n+1 ) );
            System.out.println(("sinx = " + sinResult));

        }

        System.out.println("-------NEXT TERM--------");

        double consResult=0;
        term=1;

        for (int n=1; n<=term;n++){
            consResult+=term;
            term=term * (-x * x )/( ( 2*n ) * ( 2*n-1 ) );
            System.out.println(("consx = " + consResult));
        }








    }//public static void main
}//public class
