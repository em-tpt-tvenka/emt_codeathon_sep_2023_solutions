package src.Codeathon05_Venkata;

import java.util.Scanner;

public class Question05_01_Venkata {
    public static void main(String[] args) {
        // Step 1: Input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of var1: ");
        int var1 = input.nextInt();
        System.out.print("Enter the value of var2: ");
        int var2 = input.nextInt();

        // Step 2: Swap using arithmetic operations
        // Swap var1 and var2 without using a temporary variable
        var1 = var1 + var2;
        var2 = var1 - var2;
        var1 = var1 - var2;

        // Step 3: Apply a scaling factor
        // Scale down the swapped values
        var1 = (int) (0.1 * var1);
        var2 = (int) (0.2 * var2);

        // Step 4: Output
        System.out.println("Swapped values: var1 = " + var1 + ", var2 = " + var2);
    }
}
