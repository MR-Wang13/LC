package intern.snowflake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC1291SeqDigit {
    List<Integer> result = new ArrayList<>();
    public List<Integer> sequentialDigits(int low, int high) {
        result = new ArrayList<>();
        int lengthHigh = String.valueOf(high).length();
        StringBuilder builder = new StringBuilder();
        for (int i = 1 ; i<=9; i++){
            builder.append(i);
            backTracking(builder,i+1,low,high,lengthHigh);
            builder.deleteCharAt(builder.length()-1);
        }
        Collections.sort(result);
        return result;
    }

    private void backTracking(StringBuilder builder, int k, int low, int high, int lengthHigh) {

        if (builder.length()>lengthHigh){
            return;
        }
        if (Integer.valueOf(builder.toString())>=low && Integer.valueOf(builder.toString())<=high){
            result.add(Integer.valueOf(builder.toString()));
        }

        for (int i=k ; i<=9; i++){
            if (i-1!=Character.getNumericValue(builder.charAt(builder.length()-1))){
                continue;
            }
            builder.append(i);
            backTracking(builder,i+1,low,high,lengthHigh);
            builder.deleteCharAt(builder.length()-1);
        }

    }

    public List<Integer> sequentialDigits1(int low, int high) {
        int lengthLow = String.valueOf(low).length();
        int lengthHigh = String.valueOf(high).length();
        List<Integer> list= new ArrayList<>();
        String digital = "123456789";
        for (int i = lengthLow ; i<=lengthHigh ; i++)
            for (int j=0 ;j<10-i;j++){
                int num = Integer.valueOf(digital.substring(j,i+j));
                if (num>=low && num<=high){
                    list.add(num);
                }
            }

        return list;
    }
    public static void main(String[] args) {
        LC1291SeqDigit lc = new LC1291SeqDigit();
        System.out.println(lc.sequentialDigits1(1000,13000));
    }


}
