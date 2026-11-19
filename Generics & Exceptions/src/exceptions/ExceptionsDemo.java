package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionsDemo {
    public static void show() throws IOException {
        var account=new Account();
        try {
            account.withdraw(10);
        } catch (AccountException e) {
           e.printStackTrace();
        }

    }
}
