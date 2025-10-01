import java.util.ArrayList;
import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); // To read user input
        ArrayList<Integer> numbers = new ArrayList<>(); // To store valid integers

        System.out.println("Enter numbers (type 'done' to finish):");

        while (true) {
            String input = sc.nextLine(); // Read input line by line

            if (input.equalsIgnoreCase("done")) {
                break; // Stop when user types 'done'
            }

            try {
                int number = Integer.parseInt(input); // Try to convert input to an integer
                numbers.add(number); // Add number to list if valid
            } catch (NumberFormatException e) {
                // If input is not a valid integer (e.g., "abc")
                System.out.println("Error: Invalid input, please enter a valid integer.");
            }
        }

        try {
            if (numbers.isEmpty()) {
                // If the list is empty, throw an exception manually
                throw new ArithmeticException("Cannot divide by zero - no numbers entered.");
            }

            // Calculate sum
            int sum = 0;
            for (int num : numbers) {
                sum += num;
            }

            // Calculate average
            double average = (double) sum / numbers.size(); // Cast to double to avoid integer division
            System.out.println("Average: " + average);

        } catch (ArithmeticException e) {
            // Handle the case where the list is empty
            System.out.println("Error: " + e.getMessage());
        }

        sc.close(); // Always close the scanner
}
}
