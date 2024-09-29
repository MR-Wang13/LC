package lc.top150.dp.one;

import java.util.*;

public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    boolean solution(String s, List<String> wordDict){
        int[] memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return dp(s,memo,0,wordDict);
    }

    private boolean dp(String s, int[] memo, int prefix, List<String> wordDict) {
        if (prefix == s.length()){
            return true;
        }
        if (memo[prefix]!=-1){
            return memo[prefix] == 1;
        }
        for (String word:wordDict){
            int wordLen = word.length();
            if (wordLen+prefix>s.length()) continue;
            String sub = s.substring(prefix,prefix+wordLen);
            if (!sub.equals(word)) continue;
            if(dp(s,memo,prefix+wordLen,wordDict)){
                memo[prefix] =1;
                return true;
            }

        }
        memo[prefix] = 0;
        return false;
    }

    public static void main(String[] args) {
        LC139 lc = new LC139();
        String s = "aaaaaaaaa";
        String[] dict  = {"a","aa","aaa"};
        System.out.println(lc.solution(s, new ArrayList<String>(Arrays.asList(dict))));
    }
}
