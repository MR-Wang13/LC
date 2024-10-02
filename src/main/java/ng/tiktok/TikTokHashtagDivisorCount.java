package ng.tiktok;
import java.io.*;
import java.util.*;

public class TikTokHashtagDivisorCount {
    public static void main(String[] args) throws IOException {
        // Fast input reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String description1 = br.readLine();
        String description2 = br.readLine();

        int len1 = description1.length();
        int len2 = description2.length();

        // Compute the GCD of the lengths
        int gcdLen = gcd(len1, len2);

        // Get all divisors of gcdLen
        List<Integer> divisors = getDivisors(gcdLen);

        int count = 0;
        for (int l : divisors) {
            String prefix1 = description1.substring(0, l);
            String prefix2 = description2.substring(0, l);

            if (prefix1.equals(prefix2)) {
                if (check(description1, prefix1) && check(description2, prefix1)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    // Function to compute GCD
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to get all divisors of n
    private static List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        Collections.sort(divisors);
        return divisors;
    }

    // Function to check if s can be formed by repeating prefix
    private static boolean check(String s, String prefix) {
        int len = prefix.length();
        int sLen = s.length();
        if (sLen % len != 0) {
            return false;
        }
        int times = sLen / len;
        for (int i = 0; i < times; i++) {
            int start = i * len;
            int end = start + len;
            if (!s.substring(start, end).equals(prefix)) {
                return false;
            }
        }
        return true;
    }
}
