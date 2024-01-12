package lc.backtracking;

import java.math.BigInteger;

public class LargestOddNumberinString {
    static public String largestOddNumber(String num) {

        for (int i = num.length() -1 ; i>=0 ; i--){
            if (Character.getNumericValue(num.charAt(i)) % 2 ==1){
                return num.substring(0,i+1);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(largestOddNumber("239537672423884969653287101"));
    }
}
