package ng.gs;

import java.util.HashMap;

public class fractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) && (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
    public static String fractionToDecimalPractice(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        if(numerator>0 && denominator<0 || numerator <0 && denominator>0){
            res.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        long quotient = num / den;
        long remainder = num % den;
        res.append(quotient);
        if(remainder == 0){
            return res.toString();
        }
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while(remainder!=0){
            if(map.containsKey(remainder)){
                int index = map.get(remainder);
                res.insert(index, "(");
                res.append(")");
                break;
            }else{
                map.put(remainder, res.length());
                remainder*=10;
                quotient = remainder/den;
                remainder %= den;
                res.append(quotient);
            }
        }

        return res.toString();

    }
    public static void main(String[] args) {
        int numerator = 1, denominator = 6;
        System.out.println(fractionToDecimalPractice(numerator,denominator));
    }
}
