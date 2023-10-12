package src;

import java.util.Scanner;

class UsernameValidation {

    public static Boolean possibleChanges(String username) {
        for (int i = 0; i < username.length(); i++) {
            char currentChar = username.charAt(i);
            for (int j = i + 1; j < username.length(); j++) {
                char nextChar = username.charAt(j);
                if (nextChar < currentChar) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void displayResults(boolean[] results) {
        System.out.println("Output:");
        for (boolean result : results) {
            System.out.println(result ? "YES" : "NO");
        }

    }
}
public class Question01_Venkata {
    public static void main(String[] args) {
        UsernameValidation validate = new UsernameValidation();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of usernames:");
        int size = scanner.nextInt();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Please enter string values:");
        String[] usernames = new String[size];
        for (int i = 0; i < size; i++) {
            usernames[i] = scanner1.next().toLowerCase();
        }

        boolean[] results = new boolean[size];

        for (int i = 0; i < size; i++) {
            results[i] = validate.possibleChanges(usernames[i]);
        }

        validate.displayResults(results);
    }
}

