package ng.tiktok.vo;

import java.util.*;
import java.util.stream.Collectors;

public class LC140 {

    public static List<String> wordBreak2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<Integer, List<String>> memo = new HashMap<>();

        return dp2(0, set, memo, s);

    }

    private static List<String> dp2(int n, HashSet<String> set, HashMap<Integer, List<String>> memo, String s) {
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        List<String> result = new ArrayList<>();

        if(n==s.length()){
            result.add("");
            return result;
        }

        for(int i =n;i<s.length();i++){
            String subStr = s.substring(n,i+1);
            if(set.contains(subStr)){
                List<String> subList = dp2(i+1,set,memo,s);
                for(String sub : subList){
                    result.add(subStr+(sub.equals("")?"":" ")+sub);
                }
            }
        }
        memo.put(n, result);

        return result;
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int[] memo = new int[s.length()];

        return dp(0,set,memo,s);
    }

    private static boolean dp(int n, HashSet<String> set, int[] memo, String s) {
        if(n==s.length()){
            return true;
        }
        if(memo[n]!=0){
            return memo[n] ==1;
        }
        for(int i =n;i<s.length();i++){
            String subStr = s.substring(n,i+1);
            if(set.contains(subStr) && dp(i+1,set,memo,s)){
                memo[n] =1;
                return true;
            }else{
                memo[n] = -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        String[] wordDict = {"apple","pen","applepen","pine","pineapple"};

        List<String> l = wordBreak2(s, Arrays.stream(wordDict).collect(Collectors.toList()));
        System.out.println(l);
    }
}
