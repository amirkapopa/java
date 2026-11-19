public class StrengthChecker {

    public PasswordStrength check(String password) {
     int score = 0;
     if (password.length()>= 12) score ++;
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSymbol = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSymbol = true;
        }

        if (hasLower) score++;
        if (hasUpper) score++;
        if (hasDigit) score++;
        if (hasSymbol) score++;

        if (score >= 4) return PasswordStrength.STRONG;
         else if (score >= 2) return PasswordStrength.MEDIUM;
         else return PasswordStrength.WEAK;

    }
}//Strenghtchecker
