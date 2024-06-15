package lc.newP.array;

import java.util.List;

public class LC167Twosum2 {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i =0 ; i<numbers.length ; i++)
            for (int j = 1 ; j<numbers.length; j++){
                if (numbers[i]+numbers[j]==target){
                    res[0] = i;
                    res[1] = j;
                }else if (numbers[i]+numbers[j]>target){
                    break;
                }
            }
        return res;
    }

}
