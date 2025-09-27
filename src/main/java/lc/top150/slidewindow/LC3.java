package lc.top150.slidewindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0){
            return 0;
        }
        int maxLength = 1;
        int left =0 ,right = 1,n = s.length();
        String cur = s.substring(0,1);
        while (right<n){
            char next =s.charAt(right);
            if (cur.indexOf(next)>=0){

                left +=cur.indexOf(next)+1;
            }else {
                maxLength = Math.max(maxLength,right-left+1);

            }
            right++;
            cur = s.substring(left,right);

        }
        return maxLength;
    }

    private void removeMap(String s,HashMap<Character, Integer> map, int left, Integer right) {
        for (int i = left ; i<=right ; i++){
            map.remove(s.charAt(i));
        }

    }
    public int lengthOfLongestSubstring1(String s) {
        int l = 0, r = 0, n = s.length();
        Set<Character> set = new HashSet<>();
        int max = 1;
        while(r < n){
            char c = s.charAt(r);
            if (set.contains(c)){
                while(l<r&&c!=s.charAt(l)){
                    set.remove(s.charAt(l));
                    l++;

                }
                set.remove(l);
                l++;
            }
            set.add(c);
            max = Math.max(max, r -l+1);
            r++;
        }
        return max;
    }
    public static void main(String[] args) {
        LC3 lc = new LC3();
        System.out.println(lc.lengthOfLongestSubstring1("tmmzuxt"));
    }
}
