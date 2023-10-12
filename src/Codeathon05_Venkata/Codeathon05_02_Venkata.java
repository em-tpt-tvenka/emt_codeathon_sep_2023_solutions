package src.Codeathon05_Venkata;

import java.util.Scanner;

class Rectangle {
    int width;
    int height;

    public void display() {
        System.out.println("Rectangle dimensions: " + width + " x " + height);
    }
}

class RectangleArea extends Rectangle {
    public void readInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the width of the rectangle: "+"\n");
        width = scanner.nextInt();

        System.out.print("Enter the height of the rectangle: "+"\n");
        height = scanner.nextInt();

        scanner.close();
    }

    @Override
    public void display() {
        super.display(); // Display dimensions from the parent class

        int area = width * height;
        System.out.println("Area of the rectangle: " + area);
    }
}

public class Codeathon05_02_Venkata {
    public static void main(String[] args) {
        RectangleArea rectangleArea = new RectangleArea();
        System.out.println("Rectangle Area Calculator");
        System.out.println("--------------------------"+"\n");

        rectangleArea.readInput(); // Prompt user to enter width and height
        rectangleArea.display();   // Display rectangle dimensions and area
    }
}
