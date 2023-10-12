package src;

import java.util.Scanner;

public class Question03_Venkata {

	/**
	 * Calculates the maximum travel time for two monkeys in a circular garden.
	 */
	public static int calculateMaximumTravelTime(int[] treeHeights) {
		int maxTravelTime = 0;
		int n = treeHeights.length;

		for (int i = 0; i < n; i++) {
			int maxTime = 0;

			for (int j = i + 1; j < n; j++) {
				int clockwiseDistance = (n - j + i) % n;
				int anticlockwiseDistance = (j - i) % n;
				int shortestDistance = Math.min(clockwiseDistance, anticlockwiseDistance);

				int totalTime = shortestDistance + treeHeights[i] + treeHeights[j];
				maxTime = Math.max(maxTime, totalTime);
			}

			maxTravelTime = Math.max(maxTravelTime, maxTime);
		}

		return maxTravelTime;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of trees: ");
		int n = scanner.nextInt();

		int[] treeHeights = new int[n];

		System.out.println("Enter the heights of trees (one on each line):");
		for (int i = 0; i < n; i++) {
			treeHeights[i] = scanner.nextInt();
		}

		int maxTravelTime = calculateMaximumTravelTime(treeHeights);
		System.out.println("Maximum Traveling Time: " + maxTravelTime);

		scanner.close();
	}
}
