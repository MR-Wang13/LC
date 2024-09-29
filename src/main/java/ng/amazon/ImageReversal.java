package ng.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ImageReversal {
    public static int findMinimumOperations1(String image) {
        int n = image.length() , index = 0,count= 0;
        char[] reverse = new char[n];
       while (index<n){
           reverse[index] = image.charAt(n-index-1);
           index++;
       }
       List<Character> source = IntStream.range(0,image.length()).mapToObj(i->image.charAt(i)).collect(Collectors.toList());
       while (!(source.stream().map(String::valueOf).collect(Collectors.joining())).equals(String.valueOf(reverse))){
          int left = 0, right = n-1;
          while (left<right && source.get(left) == source.get(right)){
              left++;
              right--;
          }
          if (left<right){
              count++;
              char temp = source.get(left);
              source.remove(left);
              source.add(temp);

          }
       }
       return count;
    }
    public static int findMinimumOperations(String image) {
        char[] s = image.toCharArray();
        int n = s.length;

        int lp = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == s[n - lp - 1]) {
                lp++;
            }
        }

        return n - lp;
    }

    public static void main(String[] args) {
        System.out.println(findMinimumOperations("0100110"));
    }
}
