package intern.snowflake;

import java.util.HashSet;
import java.util.Set;

public class LC1930Unique {
    public int countPalindromicSubsequence(String s) {
        int count =0 ;
        for (char c = 'a'; c<='z';c++ ){
            int l = 0 , r =s.length()-1;
            //找到左边第一个
            while (l<s.length() && s.charAt(l)!=c){
                l++;
            }
            //找到右边第一个
            while (r>=0 && s.charAt(r)!=c){
                r--;
            }
            if (r-l<2){
                continue;
            }
            //中间不同的字符数
            HashSet<Character> set = new HashSet<>();
            for (int i =l+1;i<r ; i++ ){
                set.add(s.charAt(i));
            }
            count+=set.size();
        }
        return count;
    }

    public static void main(String[] args) {
        LC1930Unique lc = new LC1930Unique();
        String s = "aabca";
        System.out.println(lc.countPalindromicSubsequence(s));
    }
}
