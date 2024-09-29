package ng;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       int n =4;
        int[] arr = {1,2,2,1};
        int[] left= new int[n];
        int[] right= new int[n];
        for(int i =1 ;i<n;i++){
            if(arr[i]>arr[i-1]){
                left[i] = left[i-1]+1;
            }
        }
        for(int i =n-2 ;i>=0;i--){
            if(arr[i]>arr[i+1]){
                right[i] = right[i+1]+1;
            }
        }

        int max = 0;
        for(int i =1;i<n-1;i++){
            if(left[i]>0 && right[i]>0){
                max = Math.max(max,left[i]+right[i]+1);
            }
        }

        System.out.println(max);
    }
}
