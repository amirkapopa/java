//U2510164 Amir Pulatov Lab9


import java.net.*;
import java.io.*;
import java.sql.SQLOutput;


public class SimpleInterestCalculatorServer {
    public static void main(String[] args)  throws   java.io.IOException{
        final int PORT=8000;


        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Simple Interest Calculator Server Started on port "+PORT);

            while (true) {

                System.out.println("Waiting for client...");

                Socket socket=serverSocket.accept();
                System.out.println("Client connected" + socket.getInetAddress());

                DataInputStream fromClient=new DataInputStream(socket.getInputStream());
                DataOutputStream toClient= new DataOutputStream(socket.getOutputStream());


                double principal=fromClient.readDouble();
                double rate=fromClient.readDouble();
                double years= fromClient.readDouble();
                System.out.println("Received principal "+principal
                        + " , Received rate = "+rate + "%, Years= "+years);

                double interest=(principal*rate*years)/100;

                toClient.writeDouble(interest);
                System.out.println("Sent interest "+interest);

                socket.close();

            }//while

        } catch (IOException ex) {
            System.out.println("Something went wrong" + ex.getMessage());
        }
    }
}
