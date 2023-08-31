import java.util.HashMap;
import java.util.Set;


public class Main {
    public static boolean compareNum(String s1, String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        HashMap<Character, Integer> s1Map = new HashMap<>();

        HashMap<Character, Integer> s2Map = new HashMap<>();

        for (char c : chars1){
            if (s1Map.containsKey(c)){
                s1Map.put(c,s1Map.get(c)+1);
            }else {
                s1Map.put(c,0);
            }
        }

        for (char c : chars2){
            if (s2Map.containsKey(c)){
                s2Map.put(c,s2Map.get(c)+1);
            }else {
                s2Map.put(c,0);
            }
        }

        Set<Character> keys = s1Map.keySet();

        for (char key:keys) {
            if (!s2Map.containsKey(key) || s1Map.get(key)!=s2Map.get(key)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }

}