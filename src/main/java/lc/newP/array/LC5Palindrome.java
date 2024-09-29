package lc.newP.array;

public class LC5Palindrome {
    boolean isPalindrome(String s){
        int left =0,right = s.length()-1;
        while (left<right){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    String findPalindrome(String s, int left , int right){
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }

    public String longestPalindrome(String s) {
        String result = "";
        for (int i =0 ; i<s.length()-1; i++){
            String s1 = findPalindrome(s, i, i);
            String s2 = findPalindrome(s,i,i+1);

            result = s1.length()>result.length()?s1:result;
            result = s2.length()>result.length()?s2:result;
        }
        return result;
    }
    public static void main(String[] args) {
        LC5Palindrome lc  = new LC5Palindrome();
        System.out.println(lc.longestPalindrome("abaa"));

    }
}
