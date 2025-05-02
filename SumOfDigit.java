import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * This class calculates the sum of all digits.
 * @author Tony Tran
 * @version 1.0
 * @since 2025-05-02
 */

final class SumOfDigit {
    /**
     * This is a private constructor to satisfy style checker.
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private SumOfDigit() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This function calculates the sum of all digits in a given integer.
     * @param number the integer whose digits are to be summed
     * @return the sum of the digits of the number
     */
    public static int sumOfDigits(final int number) {
        // Base case: if the number is 0, return 0
        if (number == 0) {
            return 0;
        }
        // Recursive case: add the last digit to the sum of the remaining digits
        return Math.abs(number % 10) + sumOfDigits(number / 10);
    }
    /**
     * This the main method to run the program.
     * @param args
     */
    public static void main(final String[] args) throws Exception {
        // Create a Scanner object to read from the input file
        Scanner input = new Scanner(new File(args[0]));
        // Create a FileWriter object to write to the output file
        FileWriter writer = new FileWriter("output.txt");
        // Loop through space-separated integers in the input file
        while (input.hasNext()) {
            try {
                // Read the integer from the input file
                int number = Integer.parseInt(input.next());

                // Calculate the sum of digits of the number
                int result = sumOfDigits(number);

                // Write the result to the output file
                writer.write(result + "\n");
                System.out.println(result);
            } catch (NumberFormatException e) {
                // Handle invalid input gracefully
                writer.write("Invalid input\n");
            }
        }
        // Close the Scanner and FileWriter objects
        input.close();
        writer.close();
    }
}
