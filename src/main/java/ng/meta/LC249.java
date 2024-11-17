package ng.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC249 {
    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for(String s : strings){
            int shiftToA = s.charAt(0) - 'a';
            char[] shiftedChars = new char[s.length()];
            int index = 0;
            for(char c : s.toCharArray()){
                char shifted = (char)(c - shiftToA);
                if(shifted<'a'){
                    shifted += 26;
                }
                shiftedChars[index++] = shifted;
            }

            groupMap.computeIfAbsent(String.valueOf(shiftedChars), k -> new ArrayList<>()).add(s);
        }

        return  new ArrayList<>(groupMap.values());
    }

    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        groupStrings(strings);
    }

}
