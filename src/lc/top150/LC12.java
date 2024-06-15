package lc.top150;

import java.util.HashMap;
import java.util.Map;

public class LC12 {
    public String intToRoman(int num) {
        HashMap<Integer,Character> map = new HashMap<>();
        map.put(1,'I');
        map.put(5,'V');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(1000,'M');
        String s = String.valueOf(num) ;
        for (int i = 0 ; i<s.length();i++){
            int n =  Character.getNumericValue(s.charAt(i));
            if (n==4){
                map.get(Double.valueOf(n* Math.pow(10,s.length()-i-1)).intValue());

            }
        }
        return "";
    }

    public static void main(String[] args) {
        LC12 lc = new LC12();
        System.out.println(lc.intToRoman(1994));
    }
}
