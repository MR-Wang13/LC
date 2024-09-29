package lc.top150;

import java.util.HashMap;

public class LC13 {
    /***
     *
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * */
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        char tmp = s.charAt(s.length()-1);
        int sum = map.get(tmp);

        for (int i = s.length()-2; i>=0;i--){
            if (map.get(s.charAt(i))<map.get(tmp)){
                sum-=map.get(s.charAt(i));
            }else if (map.get(s.charAt(i))>map.get(tmp)){
                sum+=map.get(s.charAt(i));
                tmp = s.charAt(i);
            }else {
                sum+=map.get(s.charAt(i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LC13 lc = new LC13();
        System.out.println(lc.romanToInt("MCMXCIV"));
    }
}
