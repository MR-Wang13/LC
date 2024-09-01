package ng.zijie;

import java.util.*;
import java.util.*;

public class SymmetricMatrixMinCost {

    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {
        // 初始化矩形 matrix
        char[][] matrix = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };

        int n = matrix.length;      // 行数
        int m = matrix[0].length;   // 列数
        int x = 10;                 // 万能操作的代价

        // 初始化字母间的转换代价 cost
        int[][] cost = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(cost[i], INF);  // 初始化为一个很大的数，表示不能直接转换
            cost[i][i] = 0;             // 自己转换为自己，代价为 0
        }

        // 添加特定的转换代价
        cost['a' - 'a']['b' - 'a'] = 3;
        cost['b' - 'a']['c' - 'a'] = 4;
        cost['c' - 'a']['d' - 'a'] = 2;
        cost['g' - 'a']['h' - 'a'] = 5;
        cost['h' - 'a']['i' - 'a'] = 6;
        cost['f' - 'a']['e' - 'a'] = 7;

        // 使用 Floyd-Warshall 算法计算任意两字母之间的最小转换代价
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }

        int totalCost = 0;
        // 遍历矩形的所有位置并计算对称化的最小代价
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < (m + 1) / 2; j++) {
                // 获取对称位置的字符集合
                Set<Character> charSet = new HashSet<>();
                charSet.add(matrix[i][j]);
                charSet.add(matrix[n - i - 1][j]);
                charSet.add(matrix[i][m - j - 1]);
                charSet.add(matrix[n - i - 1][m - j - 1]);

                int minCost = INF;
                for (char target = 'a'; target <= 'z'; target++) {
                    int currentCost = 0;
                    for (char c : charSet) {
                        if (c != target) {
                            currentCost += Math.min(cost[c - 'a'][target - 'a'], x);
                        }
                    }
                    minCost = Math.min(minCost, currentCost);
                }

                totalCost += minCost;
            }
        }

        System.out.println(totalCost);  // 打印最终的最小代价
        solution();
    }
    static void solution(){
        char[][] matrix = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };

        int n = matrix.length;      // 行数
        int m = matrix[0].length;   // 列数
        int x = 10;                 // 万能操作的代价

        // 初始化字母间的转换代价 cost
        int[][] cost = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(cost[i], INF);  // 初始化为一个很大的数，表示不能直接转换
            cost[i][i] = 0;             // 自己转换为自己，代价为 0
        }

        // 添加特定的转换代价
        cost['a' - 'a']['b' - 'a'] = 3;
        cost['b' - 'a']['c' - 'a'] = 4;
        cost['c' - 'a']['d' - 'a'] = 2;
        cost['g' - 'a']['h' - 'a'] = 5;
        cost['h' - 'a']['i' - 'a'] = 6;
        cost['f' - 'a']['e' - 'a'] = 7;

        for (int i = 0 ; i < 26; i++)
            for (int k = 0 ; k < 26; k++)
                for (int j = 0 ; j < 26; j++){
                    cost[i][j] = Math.min(cost[i][j],cost[i][k]+cost[k][j]);
                }
        int total = 0;
        for (int i =0 ; i<(n+1)/2;i++){
            for (int j = 0 ; j<(m+1)/2;j++){
                HashSet<Character> set = new HashSet<>();
                set.add(matrix[i][j]);
                set.add(matrix[i][m-j-1]);
                set.add(matrix[n-i-1][j]);
                set.add(matrix[n-i-1][m-j-1]);

                int min = INF;
                for (char target = 'a' ; target<='z' ; target++){
                    int cur = 0;
                    for (char c : set){
                        if (c!=target){
                            cur+=Math.min(cost[c-'a'][target-'a'],x);
                        }
                    }
                    min = Math.min(cur,min);
                }
                total+=min;
            }
        }

        System.out.println(total);
    }
}
