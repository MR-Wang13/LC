package ng.tiktok.vo;

import java.util.*;

public class LC1593 {
    static int max = 0;
    public static int maxUniqueSplit(String s) {

        max = 0;

        backTracking(0, s, new HashSet<String>());

        return max;
    }

    private static void backTracking(int i, String s, HashSet<String> set) {
        if(i >= s.length()){
            max = Math.max(max, set.size());
            return;
        }
        int leftLength = s.length() - i;
        if(leftLength + set.size() <= max ){
            return;
        }
        for(int k = i; k < s.length(); k++){
            String sub = s.substring(i, k+1);
            if(set.contains(sub)){
                continue;
            }

            set.add(sub);
            backTracking(k+1, s, set);
            set.remove(sub);
        }
    }

    public static void main(String[] args) {
        maxUniqueSplit("wwwzfvedwfvhsww");
    }

}
