package ng.tiktok.vo;

import java.util.*;

public class Strobogrammatic {
    public static List<String> findStrobogrammatic(int n) {
        boolean canDivideTwo = n % 2 == 0;
        int rounds = n/2;
        StringBuilder sb = new StringBuilder();
        List<String> temp = new ArrayList<>();
        if(!canDivideTwo){
            temp.addAll(Arrays.asList("1","0","8"));
        }else{
            temp.add("");
        }
        HashMap<Character,Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        List<String> result = new ArrayList<>(temp);
        while(rounds-->0){
            result = new ArrayList<>();
            for(String s : temp){
                for(Map.Entry<Character,Character> entry: map.entrySet()){
                    if(rounds == 0 && entry.getKey()=='0'){
                        continue;
                    }
                    result.add(entry.getKey()+s+entry.getValue());
                }
            }
            temp = new ArrayList<>(result);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
