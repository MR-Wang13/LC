public class PrampTest {


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
        double toSurplus = newBudget;
        double reduced = 0;
        for( int i = grantsArray.length-1 ; i>=0;i--){
            toSurplus -= grantsArray[i];

            if(toSurplus<0){
                slot = i;
                break;
            }else {
                reduced += grantsArray[i];
            }
        }


        double leftAverage = (newBudget - reduced) / (slot+1);

        return leftAverage>grantsArray[slot+1]?leftAverage:grantsArray[slot+1];
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
