package courses;

import java.math.BigInteger;
import java.util.Arrays;

public class MultiplicationAlgorithms {



        private static String alaCarteMultiplication(String num1, String num2) {
            // Determine the signs and make the numbers positive
            boolean isNegative = num1.startsWith("-") ^ num2.startsWith("-");
            num1 = num1.startsWith("-") ? num1.substring(1) : num1;
            num2 = num2.startsWith("-") ? num2.substring(1) : num2;

            int[] result = new int[num1.length() + num2.length()];
            Arrays.fill(result, 0);

            for (int i = num1.length() - 1; i >= 0; i--) {
                for (int j = num2.length() - 1; j >= 0; j--) {
                    int index = num1.length() - 1 - i + num2.length() - 1 - j;
                    int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    result[index] += product;
                    result[index + 1] += result[index] / 10;
                    result[index] %= 10;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = result.length - 1; i > 0; i--) { // Skip leading zeros
                if (sb.length() == 0 && result[i] == 0) continue;
                sb.append(result[i]);
            }
            sb.append(result[0]);

            return isNegative ? "-" + sb.toString() : sb.toString();
        }

        private static String rectangleMultiplication(String num1, String num2) {
            // Determine the signs and make the numbers positive
            boolean isNegative = num1.charAt(0) == '-' ^ num2.charAt(0) == '-';
            num1 = num1.charAt(0) == '-' ? num1.substring(1) : num1;
            num2 = num2.charAt(0) == '-' ? num2.substring(1) : num2;

            // Result can be at most the sum of the lengths of both numbers
            int[] result = new int[num1.length() + num2.length()];
            Arrays.fill(result, 0);

            // Reverse both the numbers for ease of calculation
            num1 = new StringBuilder(num1).reverse().toString();
            num2 = new StringBuilder(num2).reverse().toString();

            // Multiply each digit and add to result
            for (int i = 0; i < num1.length(); i++) {
                for (int j = 0; j < num2.length(); j++) {
                    int digit1 = num1.charAt(i) - '0';
                    int digit2 = num2.charAt(j) - '0';

                    // Multiply and add to current position
                    result[i + j] += digit1 * digit2;
                    // Carry for next position
                    result[i + j + 1] += result[i + j] / 10;
                    result[i + j] %= 10;
                }
            }

            // Convert the result to a string
            StringBuilder sb = new StringBuilder();
            for (int i = result.length - 1; i >= 0; i--) {
                if (sb.length() == 0 && result[i] == 0) { // Skip leading zeros
                    continue;
                }
                sb.append(result[i]);
            }

            String resultString = sb.length() == 0 ? "0" : sb.toString();
            return isNegative ? "-" + resultString : resultString;
        }


        public static void main(String[] args) {
            // Test cases
            System.out.println("Ala Carte Multiplication Result: " + alaCarteMultiplication("-45952456856498465985", "98654651986546519856"));
            System.out.println("Rectangle Multiplication Result: " + rectangleMultiplication("-45952456856498465985", "98654651986546519856"));
            // Other test cases can be added similarly
        }


}
