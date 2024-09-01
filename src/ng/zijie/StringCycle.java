package ng.zijie;

import ng.optiver.Main;

import java.util.HashSet;

public class StringCycle {
    int getMinimumCycle(String s){
        for (int i = 1 ; i<s.length() ; i++){
            if (checkIfCycle(s,i)){
               return i;
            }
        }
        return s.length()-1;
    }

    private boolean checkIfCycle(String s, int cycle) {
        for (int i = 0 ; i<s.length();i++ ){
            int start = i;
            HashSet<Character> set = new HashSet<>();

            while (start<s.length()){
                set.add(s.charAt(start));
                if (set.contains('1')&&set.contains('0')){
                    return false;
                }
                start +=cycle;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StringCycle sc = new StringCycle();
        System.out.println(sc.getMinimumCycle("1*011*0*1"));
    }
}
