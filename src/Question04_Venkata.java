package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

// Step 1: Define a functional interface for operations.
interface Operation {
	boolean apply(int number);
}

class ValueChecker {
	public static boolean checkValue(Operation operation, int number) {
		return operation.apply(number);
	}
	// Step 2: Implement methods for operations as lambda expressions.
	public static Operation isOdd() {
		return n -> (n & 1) == 1; // Checks if a number is odd.
	}

	public static Operation isPrime() {
		return n -> {
			if (n < 2) {
				return false;
			}
			int sqrt = (int) Math.sqrt(n);
			for (int i = 2; i <= sqrt; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true; // Checks if a number is prime.
		};
	}

	public static Operation isPalindrome() {
		return n -> {
			String original = Integer.toString(n);
			String reversed = new StringBuilder(Integer.toString(n)).reverse().toString();
			return original.equals(reversed); // Checks if a number is a palindrome.
		};
	}
}

public class Question04_Venkata {
	public static void main(String[] args) {
		ValueChecker valueChecker = new ValueChecker();
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		Operation operation;
		String result = null;
		scanner.nextLine();
		List<String> results = new ArrayList<>();

		while (testCases-- > 0) {
			String input = scanner.nextLine().trim();
			StringTokenizer tokenizer = new StringTokenizer(input);
			int choice = Integer.parseInt(tokenizer.nextToken());
			int number = Integer.parseInt(tokenizer.nextToken());

			// Step 3: Use the functional interfaces to check values.
			if (choice == 1) {
				operation = valueChecker.isOdd();
				result = valueChecker.checkValue(operation, number) ? "ODD" : "EVEN";
			} else if (choice == 2) {
				operation = valueChecker.isPrime();
				result = valueChecker.checkValue(operation, number) ? "PRIME" : "COMPOSITE";
			} else if (choice == 3) {
				operation = valueChecker.isPalindrome();
				result = valueChecker.checkValue(operation, number) ? "PALINDROME" : "NOT PALINDROME";
			}

			results.add(result);
		}

		scanner.close();

		// Step 4: Display the results.
		for (String output : results) {
			System.out.println(output);
		}
	}
}
