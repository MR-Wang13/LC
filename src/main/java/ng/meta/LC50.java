package ng.meta;

public class LC50 {
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0; // 任何数的 0 次方都是 1
        }

        // 处理 n 为负数的情况
        long exp = n; // 使用 long 避免溢出
        boolean isNegative = exp < 0;
        exp = Math.abs(exp);

        double result = 1.0;

        // 快速幂算法
        while (exp > 0) {
            if ((exp % 2) == 1) { // 如果当前指数是奇数
                result *= x;
            }
            x *= x; // 基数平方
            exp /= 2; // 指数减半
        }

        return isNegative ? 1 / result : result;
    }
    //173
    //347
    //394
    //721
    //75
    public static void main(String[] args) {
        System.out.println(myPow(2.0000,10));
    }
}
