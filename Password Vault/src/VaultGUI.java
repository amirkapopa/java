import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.nio.file.Files;
import java.nio.file.Path;


public class VaultGUI {
    public static void main(String[] args) {
        Path file=Path.of("vault data");
        Encryptor encryptor= new AesEncryptor();
        VaultStorage storage= new VaultStorage(encryptor,file);

        String input = JOptionPane.showInputDialog("Enter Password");
        if (input==null) return;
        char[] master =input.toCharArray();

        Vault vault;
        if (Files.exists(file)) {
            try {
                vault=storage.load(master);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            vault= new Vault();
        }


        PasswordGenerator generator = new PasswordGenerator();

        JFrame window = new JFrame("Password Vault");
        window.setLocationRelativeTo(null);   // center on screen, before setVisible
        window.setSize(430, 240);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 2, 6, 6));  // rows of 2 columns

        JTextField siteField = new JTextField();
        JTextField usernameField = new JTextField();
        JTextField passwordField = new JTextField();
        JButton generateButton = new JButton("Generate");
        JButton addButton = new JButton("Add entry");
        JLabel status = new JLabel("Fill the fields and click Add");

        panel.add(new JLabel("Site:"));      panel.add(siteField);
        panel.add(new JLabel("Username:"));  panel.add(usernameField);
        panel.add(new JLabel("Password:"));  panel.add(passwordField);
        panel.add(generateButton);           panel.add(addButton);
        panel.add(status);
        window.add(panel, BorderLayout.NORTH);

        JTextArea listArea = new JTextArea();
        listArea.setEditable(false);
        window.add(new JScrollPane(listArea), BorderLayout.CENTER);

        // Generate button fills the password field
        generateButton.addActionListener(e -> {
            passwordField.setText(generator.generate(16));
        });

        // Add button creates a Credential and stores it
        addButton.addActionListener(e -> {
            try {
                Credential c = new Credential(
                        siteField.getText(),
                        usernameField.getText(),
                        passwordField.getText());
                boolean isNew = vault.add(c);
                StringBuilder sb=new StringBuilder();
                for (Credential cr: vault.getAll()){
                    sb.append(cr.getSite())
                            .append(" (").append(cr.getUsername()).append(")\n");
                }
                listArea.setText(sb.toString());
                try {
                    storage.save(vault,master);
                } catch (Exception ex2) {
                    status.setText("Saved in memory, but failed to save the vault");
                }

                status.setText((isNew ? "Saved. " : "Updated. ") + "Total: " + vault.size());
                siteField.setText("");          // clear the fields
                usernameField.setText("");
                passwordField.setText("");
            } catch (IllegalArgumentException ex) {
                status.setText("Error: " + ex.getMessage());
            }
        });

        window.setVisible(true);
    }
}