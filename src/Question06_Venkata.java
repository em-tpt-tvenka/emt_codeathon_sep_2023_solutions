package src;

import java.util.*;
import java.util.stream.Collectors;

public class Question06_Venkata {
	static ArrayList<String> letters = new ArrayList<>();

	public static Map<String, List<String>> playGame(List<String> uniqueCodes, List<String> fruits) {
		Map<String, List<String>> resultMap = new HashMap<>();

		// Iterate through the English alphabet
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			String alphabet = String.valueOf(letter);
			letters.add(alphabet);
		}

		// Iterate through each character in the word
		for (String code : uniqueCodes) {
			String uniqueChar = processWord(code);
			int index = letters.indexOf(uniqueChar);

			List<String> matchingFruits = fruits.stream().filter(fruit -> fruit.length() == index).collect(Collectors.toList());
			resultMap.put(code, matchingFruits);
		}

		return resultMap;
	}

	public static String processWord(String word) {
		StringBuilder processedWord = new StringBuilder();

		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);

			// Check if the character is an alphabet letter
			if (Character.isAlphabetic(character)) {
				String characterStr = String.valueOf(character).toUpperCase();

				if (letters.contains(characterStr)) {
					// If the character exists in the 'letters' ArrayList, add it to the processed word
					processedWord.append(characterStr);
				}
			}
		}
		return processedWord.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of unique codes and fruits: " + "\n");
		int numValues = scanner.nextInt();
		scanner.nextLine();

		List<String> uniqueCodes = new ArrayList<>();
		System.out.println("Enter unique codes:" + "\n");
		for (int i = 0; i < numValues; i++) {
			String input = scanner.nextLine();
			uniqueCodes.add(input);
		}

		List<String> fruits = new ArrayList<>();
		System.out.println("Enter fruit names:" + "\n");
		for (int i = 0; i < numValues; i++) {
			String input = scanner.nextLine();
			fruits.add(input);
		}

		Map<String, List<String>> resultMap = playGame(uniqueCodes, fruits);

		for (String code : uniqueCodes) {
			List<String> matchingFruits = resultMap.get(code);
			System.out.print(code + ": ");
			if (matchingFruits.isEmpty()) {
				System.out.println("[No Fruit]");
			} else {
				System.out.println(String.join(", ", matchingFruits));
			}
		}
		scanner.close();
	}
}
