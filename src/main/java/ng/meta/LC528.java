package ng.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LC528 {
    private List<Integer> runningSums;
    private int totalW;
    public LC528(int[] w) {
        runningSums = new ArrayList<>();
        int total = 0;
        for(int v : w){
            total+=v;
            runningSums.add(total);
        }
        totalW = total;

    }

    public int pickIndex() {
        Random random = new Random();
        int target = random.nextInt(totalW) + 1;
        int low = 0;
        int high = runningSums.size();
        while(low < high){
            int mid = low + (high - low) / 2;
            if(target > runningSums.get(mid)){
                low = mid + 1;
            }else {
                high = mid;
            }

        }

        return low;
    }

    public static void main(String[] args) {

    }
}
