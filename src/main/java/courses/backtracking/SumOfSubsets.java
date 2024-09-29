package courses.backtracking;

import java.util.List;

public class SumOfSubsets {
    int[] w ;
    char[] include;
    int wb;
    SumOfSubsets(int[] w, int wb){
        this.w = w;
        include = new char[w.length];
        this.wb = wb;
    }
    boolean sumOfSub(int i, int weight, int total){
        if (promising(i,weight,total)){
            if (weight==wb) {
                printInclude(include);
                return true;
            }else {
                include[i+1]='y';
                if (sumOfSub(i+1,weight+w[i+1],total-w[i+1])){
                    return true;
                }
                include[i+1]='n';
                if ( sumOfSub(i+1,weight,total-w[i+1])){
                    return true;
                }

            }
        }
        return false;
    }

    private void printInclude(char[] include) {
        for (int i=0; i<include.length; i++){
            if (include[i]=='y'){
                System.out.println(w[i]);
            }
        }
    }

    private boolean promising(int i, int weight, int total) {
        return (weight+total>=wb)&&(weight==wb||weight+w[i+1]<=wb);
    }

    public static void main(String[] args) {
        int[] w = {1,5,2,4};
        SumOfSubsets sumOfSubsets = new SumOfSubsets(w,6);
        sumOfSubsets.sumOfSub(-1,0,12);
    }
}
