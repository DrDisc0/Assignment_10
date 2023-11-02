package assignment_10;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
	public static boolean isPasswordValid(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        int categoryCount = 0;

        // Check for lower case letters
        if (containsLowerCase(password)) {
            categoryCount++;
        }

        // Check for upper case letters
        if (containsUpperCase(password)) {
            categoryCount++;
        }

        // Check for numbers
        if (containsNumber(password)) {
            categoryCount++;
        }

        // Check for special symbols
        if (containsSpecialSymbols(password)) {
            categoryCount++;
        }

        return categoryCount >= 3;
    }

    private static boolean containsLowerCase(String password) {
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private static boolean containsUpperCase(String password) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private static boolean containsNumber(String password) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private static boolean containsSpecialSymbols(String password) {
        Pattern pattern = Pattern.compile("[~!@#$%^&*()\\-=+_]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public static void main(String[] args) {
        String password = "Password123#";
        boolean isValid = isPasswordValid(password);

        if (isValid) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }

}
