public class PrampTest2 {


    static double findGrantsCap(double[] grantsArray, double newBudget) {

        sortByReverse(grantsArray);
        double max = grantsArray[0];

        double sum = 0;
        for(double i : grantsArray){
            sum+=i;
        }
        if(sum<=newBudget){
            return max;
        }
        int slot = grantsArray.length-1;
        double toSurplus = sum - newBudget;
        double reduced = 0;
        for( int i = 0 ; i< grantsArray.length-1;i++){
            toSurplus -= (i+1) * (grantsArray[i] - grantsArray[i+1]);

            if(toSurplus<0){
                slot= i;
                break;
            }
        }

        return grantsArray[slot] + (float)(-toSurplus / (slot));
    }

    static void sortByReverse(double[] nums){
        for(int i =0;i<nums.length;i++){
            for(int j=0;j<nums.length-1;j++){
                if(nums[j]<nums[j+1]){
                    double temp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }

    }

    public static void main(String[] args) {

        double[] grantsArray = {2,4};
        double newBudget = 3;
        System.out.println(findGrantsCap(grantsArray,newBudget));
    }

}
