package lc.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    static List<String> result = new ArrayList<>();
    static HashMap<Integer,String> map = new HashMap<>();

    static public List<String> letterCombinations(String digits) {
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        result = new ArrayList<>();
        int length = digits.length();
        StringBuilder builder = new StringBuilder();
        backTracking(builder,length,0,digits);
        return result;
    }

    static private void backTracking(StringBuilder build, int length, int k,String digits) {
        if (build.length() == length){
            result.add(build.toString());
            return;
        }
        String str = map.get(Character.getNumericValue(digits.charAt(k)));
        for (int i =0; i<str.length() ; i++){
            build.append(str.charAt(i));
            backTracking(build,length,k+1,digits);
            build.deleteCharAt(build.length()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
