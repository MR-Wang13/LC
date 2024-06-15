package lc.top150;

public class LC135 {
    public int candy(int[] ratings) {
        int n =ratings.length;
        int mini = n;
        int[] candies = new int[n];
        for (int i = 1 ; i<n ; i++){
            if (ratings[i]>ratings[i-1]){
                candies[i] = candies[i - 1] + 1;
                mini +=candies[i];

            }else if (ratings[i]<ratings[i-1]){
                if (candies[i-1]<=candies[i]){
                    mini+=addLeft(i,candies,ratings);
                }

            }

        }
        return mini;
    }

    private int addLeft(int i, int[] candies, int[] ratings) {

        int count =0;
        for (int k = i;k>0;k--){
            if (ratings[k-1]<ratings[k]){
                return count;
            }else {
                if (candies[k-1]<=candies[k]){
                    candies[k-1]++;
                    count++;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        LC135 lc = new LC135();
        int[] rating = {1,0,2};
        System.out.println(lc.candy(rating));

    }
}
