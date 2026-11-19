import java.util.Scanner;



public class ConsoleUI {
    private final Vault vault;
    private final Scanner scanner = new Scanner(System.in);
    private final PasswordGenerator generator;
    private final StrengthChecker strengthChecker = new StrengthChecker();

    public ConsoleUI(Vault vault,  PasswordGenerator generator) {
        this.vault = vault;
        this.generator = generator;
    }


     public void run(){
        boolean running = true;
        while(running){
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice){
                case "1": addEntry(); break;
                case "2": findEntry(); break;
                case "3": deleteEntry(); break;
                case "4": listEntries(); break;
                case "5": generatePasword(); break;
                case "0": running = false; break;
                default:
                    System.out.println("Invalid choice");


            }//switch

        }//while
         System.out.println("Goodbye!");
     }


     private void printMenu(){
        System.out.println();
        System.out.println("   Menu: ");
         System.out.println("1. Add entry");
         System.out.println("2. Find entry");
         System.out.println("3. Delete entry");
         System.out.println("4. List all entries");
         System.out.println("5. Generate a password");
         System.out.println("0. Exit");
         System.out.println("Choose an option: ");
     }// printMenu

    private String ask(String prompt){
        System.out.println(prompt);
        return scanner.nextLine();
    }

    private void addEntry(){
        String site = ask("Enter site: ");
        String username = ask("Enter username: ");

        if (vault.contains(site,username)){
        String answer=ask("This login  already exists. Overwrite your login? (y/n) ");
        if (!answer.equalsIgnoreCase("y")){
            System.out.println("Cancelled.");
            return;
         }
        }
        String password = ask("Password: ");
        if (password.isBlank()) {
            password = generator.generate(16);
            System.out.println("Generated password: " + password);
        }
        System.out.println("Strength: " + strengthChecker.check(password));

        boolean isNew=vault.add(new Credential(site,username,password));
        System.out.println( isNew ? "Successfully saved  a new entry" : "Updated existing entry.");

    }


    private void findEntry(){
        String site = ask("Enter site: ");
        String username = ask("Enter username: ");
        try{
            Credential found = vault.find(site, username);
            System.out.println("Site: " + found.getSite());
            System.out.println("Username: " + found.getUsername());
            System.out.println("Password: " + found.getPassword());
        } catch (EntryNotFoundException e) {
            System.out.println("Could not find entry: " + e.getMessage());
        }
    }// findEntry

    private void deleteEntry(){
        String site = ask("Enter site: ");
        String username = ask("Enter username: ");

        boolean removed = vault.remove(site, username);

        if (removed){
            System.out.println("Successfully deleted entry");
        } else {
            System.out.println("Nothing to delete");
        }


    }//deleteEntry

        private void listEntries(){
        if (vault.size() == 0){
            System.out.println("Nothing to list");
            return;
        }
        for (Credential c : vault.getAll()){
          PasswordStrength strength = strengthChecker.check(c.getPassword());
          System.out.println(c.getSite() + " (" + c.getUsername() + ") - " + strength);

        }
    }//LISTALLENTRIES




//    calls your existing generator to make a 16-character password,
//    prints it, then runs it through your strengthChecker and
//    prints the rating. It reuses two classes you already built —
//    no new logic, just wiring them to a menu choice.
    private void generatePasword(){
        String password=generator.generate(16);
        System.out.println("Generated password: " + password);
        System.out.println("Strength: " + strengthChecker.check(password));
    }





}//ConsoleUI
