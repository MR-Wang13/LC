package intern;

import java.util.HashSet;
import java.util.stream.LongStream;

public class LC1639 {

    long MOD = 1000000007;
    public int numWays(String[] words, String target) {
        int L1 = words[0].length();
        int L2 = target.length();
        int[][] dict = new int[L1+1][26];
        for (String str: words){
            for (int j =1;j<=L1;j++){
                dict[j][str.charAt(j-1)-'a']++;
            }
        }
        long[][] dp = new long[L2+1][L1+1];

        dp[0] = LongStream.range(0,L1+1).map(e->1).toArray();//匹配到0个字符的次数都初始化为1

        for (int i =1; i<=L2;i++){//target 第i个字符
            int to = L1-L2+i; //保证连续 to之后的不匹配
            int c = target.charAt(i-1)-'a';
            for (int j = i; j<=to;j++){
                int times = dict[j][c];//出现次数
                long preCount = dp[i-1][j-1];//用j-1个字符匹配到i-1个字符的次数
                long preCount2 =  dp[i][j-1];//用j-1个字符匹配到i个字符的次数
                long cur = times * preCount +preCount2;
                dp[i][j] = (cur) % MOD;
            }
        }
        return (int)dp[L2][L1];
    }


    public int numWays1(String[] words, String target) {
        int lenWord = words[0].length();
        int lenTarget = target.length();
        int[][] dict = new int[lenWord][26];
        for (String word : words){
            for (int i = 0;i<lenWord;i++){
                dict[i][word.charAt(i)-'a']++;
            }
        }
        long[][] dp = new long[lenTarget+1][lenWord+1];
        dp[0] = LongStream.range(0,lenWord+1).map(e->1).toArray();
        for (int i = 1 ; i<=lenTarget; i++){
            int c = target.charAt(i-1)-'a';
            int bound = i+lenWord-lenTarget;
            for (int j = i; j<=bound ; j++){
                long preCount1 = dp[i-1][j-1];
                long preCount2 = dp[i][j-1];
                int times= dict[j-1][c];
                long cur = preCount1*times + preCount2;
                dp[i][j] = cur%MOD;

            }
        }

        return (int)dp[lenTarget][lenWord];
    }


    public static void main(String[] args) {
        LC1639 lc = new LC1639();
        String[]  words = {"valyaa","lyglba","vldoha"};
        String target = "val";
        System.out.println(lc.numWays1(words,target));
    }

}
