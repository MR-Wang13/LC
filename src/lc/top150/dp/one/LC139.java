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

    public static void main(String[] args) {
        LC139 lc = new LC139();
        String s = "catsandog";
        String[] dict  = {"cats", "dog", "sand", "and", "cat"};
        System.out.println(lc.wordBreak(s, new ArrayList<String>(Arrays.asList(dict))));
    }
}
