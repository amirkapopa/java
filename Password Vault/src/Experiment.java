
//this class was created for testing purposes so if
//accidentally  added fell free to  skip it please

import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

public class Experiment {
    public static void main(String[] args) throws Exception {
        VaultStorage storage = new VaultStorage(new AesEncryptor(), Path.of("vault.dat"));

        // 1. SAVE fresh data with the current code
        Vault vault = new Vault();
        vault.add(new Credential("gmail.com", "amir", "pass1"));
        vault.add(new Credential("github.com", "amir", "gh123"));
        storage.save(vault, "master123".toCharArray());
        System.out.println("Saved fresh.");

        // 2. LOAD it back
        Vault loaded = storage.load("master123".toCharArray());
        System.out.println("Loaded entries: " + loaded.size());
        for (Credential c : loaded.getAll()) {
            System.out.println(c);
        }
    }
}