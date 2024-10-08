package lc.top150.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map  = new HashMap<>();
        for(String s:strs){
            char[] c =s.toCharArray();
            Arrays.sort(c);
            String key =String.valueOf(c);
            map.computeIfAbsent(key,k->new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagrams(strs));

    }
}
