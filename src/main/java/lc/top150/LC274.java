package lc.top150;

import java.util.HashMap;

public class LC274 {
    /**
     * 1 -- 68ms
     * */
    public int hIndex(int[] citations) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i<citations.length ;i++){
            addToMap(citations[i],map);
        }
        for (int k = citations.length;k>0;k--){

            if (map.get(k)!=null&&map.get(k)>=k){
                return k;
            }
        }
        return 0;
    }

    private void addToMap(int citation, HashMap<Integer, Integer> map) {
        for (int i = citation;i>0;i--){
            map.put(i,map.getOrDefault(i,0)+1);
        }
    }

    /**
     * 2 -- 7ms
     * */

    public int hIndex2(int[] citations) {
        for (int i = 0 ; i<=citations.length; i++){
            if(checkZero(citations,i)){
                return i;
            };
            minusOne(citations);

        }
        return citations.length;
    }

    private boolean checkZero(int[] citations,int num) {
        int count =0;
        for (int i =0;i<citations.length;i++){
            if (citations[i]>0){
                count++;
            }

        }

        return count<=num;
    }

    private void minusOne(int[] citations) {
        for (int i =0;i<citations.length;i++){
            citations[i]--;
        }
    }
    /**
     * optimal solution--0ms
     * */
    public int hIndex3(int[] citations) {
       int length = citations.length;
       int[] freq = new int[length+1];
       for (int i:citations){
           if (i<length){
               freq[i]++;
           }else {
               freq[length]++;
           }
       }
       int cnt = 0;
       for (int i=length;i>=0;i--){
           cnt+=freq[i];
           if (cnt>=i){
               return i;
           }
       }
       return 0;
    }
    public static void main(String[] args) {

        LC274 lc = new LC274();
        int[] nums = {1,3,1};
        System.out.println(lc.hIndex3(nums));
    }
}
