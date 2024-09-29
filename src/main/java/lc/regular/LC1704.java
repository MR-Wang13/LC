package lc.regular;

import java.util.Arrays;
import java.util.List;

public class LC1704 {
    static public boolean halvesAreAlike(String s) {
        Character[] set = {'a','e','i','o','u','A','E','I','O','U'};
        List<Character> list = Arrays.asList(set);
        int mid = s.length()/2;
        int start = 0 , count1=0,count2=0;
        while (mid<s.length()){
            if (list.contains(s.charAt(start))){
                count1++;
            }
            if (list.contains(s.charAt(mid))){
                count2++;
            }
            mid++;start++;
        }
        return count1 == count2;
    }

    public static void main(String[] args) {

    }
}
