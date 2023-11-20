package courses.backtracking;
import java.util.Random;

public class MonteCarloPiEstimation {
    public static void main(String[] args) {
        int totalPoints = 1000000; // 总共的随机点数
        int insideCircle = 0; // 落在圆内的点数

        // 随机数生成器
        Random random = new Random();

        for (int i = 0; i < totalPoints; i++) {
            double x = random.nextDouble(); // 随机生成 x 坐标
            double y = random.nextDouble(); // 随机生成 y 坐标

            // 计算点 (x, y) 到原点的距离
            double distance = Math.sqrt(x * x + y * y);

            // 如果距离小于等于 1，则表示点在圆内
            if (distance <= 1) {
                insideCircle++;
            }
        }

        // 使用 Monte Carlo 方法估算 π 值
        double estimatedPi = 4.0 * insideCircle / totalPoints;
        System.out.println("Estimated Pi: " + estimatedPi);
    }
}
