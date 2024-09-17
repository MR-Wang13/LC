package ng.ziprecruiter;

public class TowerBlocks {
    public static int solution(int[] towers) {
        int n = towers.length;
        int movements1 =0 ,sum1=0,movements2 = 0,sum2=0;
        for (int  i = 1 ; i<n ;i++){

            if (Math.abs(towers[i-1]+sum1-towers[i])!=1){
                movements1+=Math.abs(towers[i-1]+sum1-towers[i])+1;
            }
            if(towers[i]<=towers[i-1]+sum1){
                sum1+=Math.abs(towers[i-1]+sum1-towers[i])+1;
            }
            if (Math.abs(towers[n-i]+sum2-towers[n-i-1])!=1){
                movements2 += Math.abs(towers[n-i]+sum2-towers[n-i-1])+1;

            }
            if(towers[n-i]+sum2>=towers[n-i-1]){
                sum2+=Math.abs(towers[n-i]+sum2-towers[n-i-1])+1;
            }
        }
        return Math.min(movements1,movements2);
    }

    public static void main(String[] args) {
        int[] towers = {1,4,3,2};
        System.out.println(solution(towers));
    }
}
