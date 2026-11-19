import java.security.GeneralSecurityException;

public interface Encryptor {
    byte[] encrypt(byte[] plain, char[] password) throws GeneralSecurityException;
    byte[] decrypt(byte[] data, char[] password) throws GeneralSecurityException;
}