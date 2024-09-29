package intern;
import java.util.HashMap;

public class Main {
    public int minConcatenations(String source, String target) {
        int[] dp = new int[target.length() + 1];
        // 初始化dp数组，所有值为无穷大，除了dp[0]为0（表示空目标需要0个源）
        for (int i = 1; i <= target.length(); i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        // 对于target的每一个位置i
        for (int i = 0; i < target.length(); i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue; // 如果这个位置是无穷大，则跳过
            }

            int sIndex = 0; // source的索引
            // 遍历source，尝试匹配target中从i开始的部分
            for (int tIndex = i; tIndex < target.length() && sIndex < source.length(); sIndex++) {
                if (source.charAt(sIndex) == target.charAt(tIndex)) {
                    // 如果字符匹配，尝试更新dp[tIndex + 1]
                    if (dp[tIndex + 1] > dp[i] + 1) {
                        dp[tIndex + 1] = dp[i] + 1;
                    }
                    tIndex++;
                }
            }
        }

        // 如果dp[target.length()]仍然是无穷大，则目标不能被构建
        return dp[target.length()] == Integer.MAX_VALUE ? -1 : dp[target.length()];
    }

    public static void main(String[] args) {
        Main sc = new Main();
        System.out.println(sc.minConcatenations("abc", "abcbcacbc")); // Output: 2
        System.out.println(sc.minConcatenations("abc", "acdcbc")); // Output: -1
        System.out.println(sc.minConcatenations("xyz", "xzyxzz")); // Output: 3
    }
}
