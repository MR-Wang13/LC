package ng.amazon;

public class makePowerNonDecreasing {
    public static int makePowerNonDecreasing1(int[] power) {
        int totalIncrease = 0;
        int n = power.length;
        for (int i =1; i<n;i++){
            if (power[i]+totalIncrease<power[i-1]){
                int diff = power[i-1] - power[i];
                totalIncrease+=diff;
                power[i]+=diff;

            }
        }

        return totalIncrease;
    }

    public static void main(String[] args) {
        int[] power = {3, 4, 1, 1, 2};
        System.out.println(makePowerNonDecreasing1(power));  // 输出 7
    }
}
