//AesEncryptor. This class uses Java’s
// crypto library,
// so unlike the earlier classes,
// not expected to invent the method
//names — those come from Java.

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;


public class AesEncryptor implements Encryptor {
    private static final int ITERATIONS = 1000_000;
    private static final int KEY_BITS = 128;

    // Turn a password + salt into a 256-bit key
    private static byte[] deriveKey(char[] password, byte[] salt)
            throws GeneralSecurityException {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_BITS);
        SecretKeyFactory factory =
                SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        return factory.generateSecret(spec).getEncoded();
    }

    // encrypt / decrypt come next — leave them for now
    @Override
    public byte[] encrypt(byte[] plain, char[] password) throws GeneralSecurityException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        byte[] iv = new byte[12];
        random.nextBytes(salt);                 // fresh random salt
        random.nextBytes(iv);                   // fresh random IV

        SecretKeySpec key = new SecretKeySpec(deriveKey(password, salt), "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key, new GCMParameterSpec(128, iv));
        byte[] cipherText = cipher.doFinal(plain);

        // file layout: [salt 16][iv 12][cipherText...]
        byte[] out = new byte[16 + 12 + cipherText.length];
        System.arraycopy(salt, 0, out, 0, 16);
        System.arraycopy(iv, 0, out, 16, 12);
        System.arraycopy(cipherText, 0, out, 28, cipherText.length);
        return out;
    }

    @Override
    public byte[] decrypt(byte[] data, char[] password) throws GeneralSecurityException {
        byte[] salt = Arrays.copyOfRange(data, 0, 16);     // first 16 bytes
        byte[] iv = Arrays.copyOfRange(data, 16, 28);      // next 12 bytes
        byte[] cipherText = Arrays.copyOfRange(data, 28, data.length);  // the rest

        SecretKeySpec key = new SecretKeySpec(deriveKey(password, salt), "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, key, new GCMParameterSpec(128, iv));
        return cipher.doFinal(cipherText);     // wrong key -> throws AEADBadTagException
    }
}



