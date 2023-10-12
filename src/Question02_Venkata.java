package src;

import java.util.*;

class MostActiveTraders {

    public List<String> findMostActiveTraders(List<String> trades, int numTrades) {
        Map<String, Integer> tradeCounts = new HashMap<>();

        // Count the trades for each trader
        for (String trader : trades) {
            tradeCounts.put(trader, tradeCounts.getOrDefault(trader, 0) + 1);
        }

        int threshold = numTrades * 5 / 100;
        List<String> activeTraders = new ArrayList<>();

        // Find traders with trade counts above the threshold
        for (Map.Entry<String, Integer> entry : tradeCounts.entrySet()) {
            if (entry.getValue() > threshold) {
                activeTraders.add(entry.getKey());
            }
        }

        // Sort the active traders alphabetically
        Collections.sort(activeTraders);
        int totalTrades = trades.size();

        return activeTraders;

    }


    void displayActiveTraders(List<String> activeTraders) {
        System.out.println("Most Active Traders:");

        for (String trader : activeTraders) {
            System.out.println(trader);
        }
    }
}

public class Question02_Venkata{

    public static void main(String[] args) {
        MostActiveTraders mat = new MostActiveTraders();
        Scanner scanner = new Scanner(System.in);
        List<String> trades = new ArrayList<>();

        System.out.print("Enter the number of trades you want: ");
        int numTrades = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter a list of trades (one trade per line):");

        while (trades.size() < numTrades) {
            String input = scanner.nextLine();
            trades.add(input);
        }

        try {
            List<String> activeTraders = mat.findMostActiveTraders(trades, numTrades);
            mat.displayActiveTraders(activeTraders);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }


        scanner.close();
    }
}
