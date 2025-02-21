package ng.uber;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromeFilter {

    // Method to check if a number is a palindrome
    private static boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method to filter and sort palindromes
    public static List<Integer> getSortedPalindromes(List<Integer> numbers) {
        List<Integer> palindromes = new ArrayList<>();
        for (int number : numbers) {
            if (isPalindrome(number)) {
                palindromes.add(number);
            }
        }
        Collections.sort(palindromes);
        return palindromes;
    }

    // Main method for testing
    public static void main(String[] args) {
        List<Integer> input = List.of(121, 123, 454, 11, 99, 10, 323, 22);
        List<Integer> result = getSortedPalindromes(input);
        System.out.println("Sorted Palindromes: " + result);
    }
}
