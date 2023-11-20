package intern.ebay;

import java.util.ArrayList;
import java.util.List;

public class ReverseSort {
   static boolean check(int[] numbers){
        int count = 0;
       for (int j  = 0; j<numbers.length ; j++){
           if (numbers[j] >= numbers[j + 1]) {
               count++;
           }
       }
        if (count>1){
            return  false;
        }else if(count==0)
            return true;
        for (int i = 0; i<numbers.length-1 ; i++){

            if (numbers[i] > numbers[i + 1]){
                int[] temp = numbers.clone();
                temp[i] =reverseNum(temp[i]);

                int[] temp1 = numbers.clone();
                temp1[i+1] =reverseNum(temp1[i+1]);
                if (checkSort(temp)||checkSort(temp1)){
                    return true;
                };
            }
        }
        return false;
    }

    private static boolean checkSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static int reverseNum(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            num = num / 10;
            reversed = reversed * 10 + digit;
        }
        return reversed;
    }

    public static void main(String[] args) {
        int[] test = {13,31,30};
        System.out.println(check(test));
    }
}
