// u2510164 AMIR PULATOV - Lab 9: Simple Interest Calculator (Client)
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleInterestCalculatorClient {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask the user for the three values
        System.out.println("=== Simple Interest Calculator ===");
        double principal = readPositive(input, "Enter principal amount: ");
        double rate = readPositive(input, "Enter rate of interest (% per year): ");
        double years = readPositive(input, "Enter duration (years): ");

        try {
            // Connect to the server running on this computer, port 8000
            Socket socket = new Socket("localhost", 8000);

            // Streams to send data to and receive data from the server
            DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
            DataInputStream fromServer = new DataInputStream(socket.getInputStream());

            // Send the three values (the server reads them in this same order)
            toServer.writeDouble(principal);
            toServer.writeDouble(rate);
            toServer.writeDouble(years);

            // Wait for and receive the calculated simple interest
            double interest = fromServer.readDouble();

            // Display the result
            System.out.printf("Simple interest: %.2f%n", interest);
            System.out.printf("Total amount (principal + interest): %.2f%n", principal + interest);

            socket.close();
        } catch (IOException e) {
            System.out.println("Could not reach the server. Start SimpleInterestCalculatorServer first.");
        }
    }

    // Keep asking until the user types a number that is zero or more
    static double readPositive(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (input.hasNextDouble()) {
                double value = input.nextDouble();
                if (value >= 0) {
                    return value;
                }
                System.out.println("Please enter a number that is not negative.");
            } else {
                System.out.println("Please enter a valid number.");
                input.next();   // throw away the invalid input
            }
        }
    }
}