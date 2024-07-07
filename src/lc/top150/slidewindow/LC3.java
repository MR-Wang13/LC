package lc.top150.slidewindow;

import java.util.HashMap;

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

    public static void main(String[] args) {
        LC3 lc = new LC3();
        System.out.println(lc.lengthOfLongestSubstring("tmmzuxt"));
    }
}
