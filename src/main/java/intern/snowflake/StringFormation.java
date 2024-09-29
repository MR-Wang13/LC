package intern.snowflake;

import java.util.HashSet;
import java.util.stream.LongStream;

public class StringFormation {
    int MOD =1000000007 ;



    public int numWays(String[] words, String target) {
        int wordLen = words[0].length();
        int targetLen = target.length();
        int[][] dict = new int[wordLen][26];
        for (String word : words){
            for (int i=0; i<wordLen; i++){
                dict[i][word.charAt(i)-'a']++;
            }
        }
        long[][] dp = new long[targetLen+1][wordLen+1];
        dp[0] = LongStream.range(0,wordLen+1).map(e->1).toArray();
        for (int i =1;i<=targetLen;i++){
            int bound = i+wordLen-targetLen;
            int ch = target.charAt(i-1)-'a';
            for (int j =i ; j<=bound ; j++){
                int times = dict[j-1][ch];
                long preCount1 = dp[i-1][j-1];
                long preCount2 = dp[i][j-1];
                long cur = times*preCount1 + preCount2;
                dp[i][j] = cur%MOD;
            }
        }
        return (int)dp[targetLen][wordLen];
    }


    public static void main(String[] args) {
        StringFormation lc = new StringFormation();
        String[]  words = {"acca","bbbb","caca"};
        String target = "aba";
        System.out.println(lc.numWays(words,target));
    }

}
