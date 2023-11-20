package lc.doublePoint;

public class reverseString {
    /**
     * 1. remove the extra blank
     * 2. reverse the whole string
     * 3. reverse each word
     * */
    static String reverse(String s){
       s =removeBlank(s);
       s=reverseStr(s,0,s.length()-1);
       s=reverseWords(s);
       return s;
    }

    private static String reverseWords(String s) {
        int start = 0;
        for (int i = 0 ; i<s.length()-1;i++){
            if (s.charAt(i)==' '){
                s=reverseStr(s,start, i-1);
                start=i+1;
            }
        }
        return reverseStr(s,start, s.length()-1);
    }

    private static String reverseStr(String s, int start, int end) {

        char[] arr = s.toCharArray();
        while (start<end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }

    private static String removeBlank(String s) {
        int left = 0,right = s.length()-1;
        while (s.charAt(left)==' ') left++;
        while (s.charAt(right)==' ') right--;
        return s.substring(left,right+1);
    }

    public static void main(String[] args) {

        System.out.println(reverse(" hello world! "));
    }
}
