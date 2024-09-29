package intern.snowflake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SequentialString {
    int[] cal(int n,String s,int m,String[] arr){
        int[] result = new int[m];
        for (int i =0; i<m;i++){
            String mString = arr[i];
            int index1 = 0,index2 =0;
            int lenOfM = mString.length();
            HashMap<Character,Integer> map = new HashMap<>();
            while (index1<n && index2<lenOfM){
                char sc= s.charAt(index1);
                map.put(sc,map.getOrDefault(sc,0)+1);
                while (!map.isEmpty()&& index2<lenOfM){
                    if(map.getOrDefault( mString.charAt(index2),0)!=0){
                        map.put( mString.charAt(index2),map.getOrDefault( mString.charAt(index2),0)-1);
                        index2++;
                    }else {
                        index1++;
                        break;
                    }
                }
            }
            if (index1>=n){
                result[i] = -1;
            }else {
                result[i] = index1 + 1;
            }
        }
        return result;
    }

    public static List<Integer> solution(String s, List<String> a) {
        List<List<Integer>> have = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            have.add(new ArrayList<>());
        }

        for (int i = 0; i < s.length(); ++i) {
            have.get(s.charAt(i) - '0').add(i);
        }

        List<Integer> r = new ArrayList<>();
        for (String t : a) {
            int[] num = new int[10];
            int ans = 0;
            for (char c : t.toCharArray()) {
                int x = c - '0';
                if (++num[x] > have.get(x).size()) {
                    ans = -1;
                    break;
                }
                ans = Math.max(ans, have.get(x).get(num[x] - 1) + 1);
            }
            r.add(ans);
        }
        return r;
    }

    public static void main(String[] args) {
        SequentialString ss = new SequentialString();
        int n =12,m=3;
        String s ="111222333444";
        String[] arr = {"121","3","12345"};

        //System.out.println(ss.cal(n,s,m,arr));
        System.out.println(ss.solution(s, Arrays.asList(arr)));
    }
}
