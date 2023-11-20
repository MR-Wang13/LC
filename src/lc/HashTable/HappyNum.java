package lc.HashTable;

import java.util.HashSet;

public class HappyNum {
    public boolean isHappyNum(int n){
        int sum = 0;
        HashSet set = new HashSet<>();
        while (true){
            while (n>0){
                sum = (n%10)*(n%10);
                n=n/10;
            }
            if (sum == 1){
                return true;
            }
            if (set.contains(sum)){
                return false;
            }else {
                set.add(sum);
                n = sum;
                sum=0;
            }


        }

    }

    public static void main(String[] args) {
        HappyNum happyNum = new HappyNum();
        System.out.println( happyNum.isHappyNum(7));
    }
}
