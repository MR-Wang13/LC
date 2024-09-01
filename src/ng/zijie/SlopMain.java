package ng.zijie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SlopMain {
    public static void main(String[] args) {
        int n = 5;
        int[] a = {1,2,4,4,5};

        System.out.println(solution());
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

   static int solution(){
        int n = 5 ;
       int[] a = {1,2,4,4,5};
       int count = 0;

       HashMap<String,Integer> slopMap = new HashMap<>();
       for (int i = 0; i<n ; i++){
           String slop = (i+1)/gcd(i+1,a[i])+"-"+a[i]/gcd(i+1,a[i]);
           if (slopMap.containsKey(slop)){
               count+=slopMap.get(slop);
           }
           slopMap.put(slop,slopMap.getOrDefault(slop,0)+1);
       }
       return count;
   }
   int mygcd(int a,int b){
        while (b!=0){
            int temp = b;
            b = a%b;
            a =temp;
        }
        return a;
   }
}

