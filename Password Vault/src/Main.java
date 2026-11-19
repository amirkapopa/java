import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Path file = Path.of("vault.dat");
        Encryptor encryptor= new AesEncryptor();
        VaultStorage storage= new VaultStorage(encryptor,file);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter master password: ");
        char [] master=scanner.nextLine().toCharArray();


        Vault vault;
        if (Files.exists(file)) {
             try{
                 vault=storage.load(master);
                 System.out.println("Vault unlocked.Entries: " + vault.size());
             } catch (WrongMasterPasswordException e ) {
                 System.out.println("Wrong master password.Exiting");
                 return; // stop the program
             }

        }
        else {
                 vault =new Vault();
                System.out.println("No vault found.Createing new one.");
            }

        ConsoleUI ui = new ConsoleUI(vault, new PasswordGenerator());//reates the interface and passes the vault in (dependency injection)
        ui.run();



        // 3. Save on exit
        storage.save(vault, master);
        System.out.println("Vault saved. Goodbye!");















    }
}