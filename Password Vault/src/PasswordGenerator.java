import java.security.SecureRandom;


public class PasswordGenerator {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+";
    private static final String ALL = LOWER + UPPER + DIGITS + SYMBOLS;

    private final SecureRandom random = new SecureRandom();

    private char pick(String set){
        int index= random.nextInt(set.length());
        return set.charAt(index);
    }

    public String generate( int length ){
        if (length < 8 ) {
            throw new IllegalArgumentException("Password length must be at least 8 characters");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(pick(ALL));
        }
        return sb.toString();

    }//generate

}
