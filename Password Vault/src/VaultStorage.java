import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;

public class VaultStorage {
    private final Encryptor encryptor;
    private final Path file ;

    public VaultStorage(Encryptor encryptor, Path file) {
        this.encryptor = encryptor;
        this.file = file;
    }
    public void save(Vault vault, char[] masterPassword) throws GeneralSecurityException, IOException {
        StringBuilder sb=new StringBuilder();
        for (Credential c: vault.getAll()){
            sb.append(c.getSite()).append(";")
                    .append (c.getUsername()).append(";")
                    .append (c.getPassword()).append("\n");
        }
        byte [] plain=sb.toString().getBytes();
        byte [] encrypted=encryptor.encrypt(plain, masterPassword);
        Files.write(file, encrypted);

    }

    public Vault load(char[] masterPassword)
            throws IOException, WrongMasterPasswordException {
        byte[] encrypted = Files.readAllBytes(file);     // read the scrambled bytes
        byte[] plain;
        try {
            plain = encryptor.decrypt(encrypted, masterPassword);   // unscramble
        } catch (GeneralSecurityException e) {
            throw new WrongMasterPasswordException("Wrong master password", e);
        }

        String text = new String(plain, StandardCharsets.UTF_8);   // bytes -> text
        Vault vault = new Vault();
        for (String line : text.split("\n")) {       // one credential per line
            if (line.isBlank()) continue;            // skip empty lines
            String[] parts = line.split(";");
            vault.add(new Credential(parts[0], parts[1], parts[2]));
        }
        return vault;
    }


}

