package ng.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ShortestWordEditPath {
    static int min=Integer.MAX_VALUE;
    static int solution(String source, String target, String[] words) {
        int n = words.length;
        min=Integer.MAX_VALUE;
        HashMap<String,ArrayList<String>> map =  new HashMap<>();
        for (int i = 0;i<n;i++) {
            if (canTransform(words[i], source)){
                map.computeIfAbsent(source, k -> new ArrayList<>()).add(words[i]);
            }
            for (int j = 0; j < n; j++) {
                if (i != j && canTransform(words[i], words[j])) {
                    map.computeIfAbsent(words[i], k -> new ArrayList<>()).add(words[j]);
                }
            }
        }
        HashSet<String> visited = new HashSet<>();
        rec(source,target,map,0,visited);

        return  min == Integer.MAX_VALUE?-1:min;

    }

    private static void rec(String source, String target, HashMap<String, ArrayList<String>> map, int count, HashSet<String> visited) {
        if (source.equals(target)){
            min = Math.min(min,count);
            return;
        }
        ArrayList<String> list = map.get(source);
        if (list==null||list.size()==0){
            return;
        }
        for (String s : list){
            if (visited.contains(s)) continue;
            visited.add(s);
            rec(s,target,map,count+1, visited);
            visited.remove(s);
        }
    }

    private static boolean canTransform(String word, String word1) {
        if (word.length()!=word1.length()){
            return false;
        }
        HashMap<Integer,Character> map1 = new HashMap<>();
        for (int i =0;i<word.length();i++){
            map1.put(i,word.charAt(i));
        }

        int diffCount = 0;
        for (int i =0;i<word1.length();i++){
            if (word1.charAt(i)!=map1.get(i)){
                diffCount++;
            }
            if (diffCount>1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       String  source = "bit", target = "dog";
       String[] words = {"but", "put", "big", "pot", "pog", "dog", "lot"};
        System.out.println(solution(source,target,words));

    }
}
