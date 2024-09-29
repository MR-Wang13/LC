package lc.top150.slidewindow;

import java.util.HashMap;

public class LC76 {
    public String minWindow(String s, String t) {
        int minLength = s.length()+1;
        String minWindow = new String();
        if (t.length()>s.length()){
            return minWindow;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> curMap = new HashMap<>();
        int charCount  = 0;
        int left = 0,right = 0;
        while (left<=right && right<s.length()){
            char cur = s.charAt(right);
            if (map.containsKey(cur)){
                curMap.put(cur,curMap.getOrDefault(cur,0)+1);
                if (curMap.getOrDefault(cur,0)<=map.get(cur)){
                    charCount++;
                }
                while (charCount == t.length()){
                    if (right+1-left<minLength){
                        minLength = right+1-left;
                        minWindow = s.substring(left,right+1);
                    }
                    char leftChar = s.charAt(left);
                    if (map.containsKey(leftChar)){
                        if (curMap.getOrDefault(leftChar,0)<=map.get(leftChar)){
                            charCount--;
                        }
                        curMap.put(leftChar,curMap.get(leftChar)-1);
                    }
                    left++;
                }

            }
            right++;

        }
        return minWindow;
    }

    public static void main(String[] args) {
        LC76 lc = new LC76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(lc.minWindow(s,t));

    }
}
