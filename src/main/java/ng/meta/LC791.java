package ng.meta;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class LC791 {
    public static String customSortString(String order, String s) {

        HashMap<Character, Integer> sMap = new HashMap<>();
        for(char c : s.toCharArray()){
            sMap.put(c, sMap.getOrDefault(c, 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()){
            if(sMap.containsKey(c)){
                sb.append(String.valueOf(c).repeat(sMap.get(c)));
                sMap.remove(c);
            }
        }
        for(char c : sMap.keySet()){
            sb.append(String.valueOf(c).repeat(sMap.get(c)));
        }

        return sb.toString();
    }
    public static String customSortString1(String order, String s) {
        int[] sCount = new int[26];
        for(int i = 0; i < s.length(); i++){
            sCount[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();

        for (char c : order.toCharArray()){
            if (sCount[c - 'a'] > 0){
                sb.append(String.valueOf(c).repeat(sCount[c - 'a']));
                sCount[c - 'a'] = 0;
            }
        }
        for(int i = 0; i < 26; i++){
            if(sCount[i] > 0){
                char c = (char)(i +'a');
                sb.append(String.valueOf(c).repeat(sCount[i]));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(customSortString1("cba", "abcd"));
    }
}
