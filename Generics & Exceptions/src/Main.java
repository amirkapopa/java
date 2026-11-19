import exceptions.ExceptionsDemo;
import generics.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        User user=new Instructor(5);
        Utils.printUser(new Instructor(5));
        var users= new GenericList<Instructor>();
        Utils.printUser(users);


    }
}