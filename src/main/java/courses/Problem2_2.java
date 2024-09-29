package courses;

import java.math.BigInteger;

public class Problem2_2 {
        public static BigInteger RectangleMultiplication(BigInteger a, BigInteger b) {

            BigInteger result = new BigInteger("0") ;
            boolean isNegative = false;
            BigInteger zero = new BigInteger("0");

            BigInteger minusOne = new BigInteger("-1");
            if (a.compareTo(zero) < 0 && b.compareTo(zero) > 0) {
                a = a.multiply(minusOne);
                isNegative = true;
            } else if (a.compareTo(zero) > 0 && b.compareTo(zero) < 0) {
                b = b.multiply(minusOne);
                isNegative = true;
            } else if (a.compareTo(zero) < 0 && b.compareTo(zero) < 0) {
                a = a.multiply(minusOne);
                b = b.multiply(minusOne);
            }
            String aStr = String.valueOf(a);
            String bStr = String.valueOf(b);

            for (int i = 0; i < aStr.length(); i++) {
                for (int j = 0; j < bStr.length(); j++) {
                    BigInteger aDigit = new BigInteger(String.valueOf(aStr.charAt(i)));
                    BigInteger bDigit = new BigInteger(String.valueOf(bStr.charAt(j)));
                    BigInteger pow =  power ((aStr.length() - i - 1) + (bStr.length() - j - 1));
                    result = result.add( aDigit.multiply(bDigit).multiply( pow));
                }
            }

            return isNegative ? result.multiply(minusOne):result;
        }

    public  static  BigInteger power(int n){
        if(n == 0)
            return new BigInteger("1");
        else{
            BigInteger result = new BigInteger("1");
            for(int t = 0; t < n; t++){
                result = result.multiply(new BigInteger("10"));
            }
            return result;
        }
    }
        public static void main(String[] args) {

            BigInteger n,m;


            n = new BigInteger("7000") ; m = new BigInteger("7294");
            System.out.println("RectangleMultiplication Test case 1 :"+RectangleMultiplication(n,m));
            n = new BigInteger("25") ; m = new BigInteger("5038385");
            System.out.println("RectangleMultiplication Test case 2 :"+RectangleMultiplication(n,m));
            n = new BigInteger("-59724") ; m = new BigInteger("783");
            System.out.println("RectangleMultiplication Test case 3 :"+RectangleMultiplication(n,m));
            n = new BigInteger("8516") ; m = new BigInteger("-82147953548159344");
            System.out.println("RectangleMultiplication Test case 4 :"+RectangleMultiplication(n,m));
            n = new BigInteger("45952456856498465985") ; m = new BigInteger("98654651986546519856");
            System.out.println("RectangleMultiplication Test case 5 :"+RectangleMultiplication(n,m));
            n = new BigInteger("-45952456856498465985") ; m = new BigInteger("-98654651986546519856");
            System.out.println("RectangleMultiplication Test case 6 :"+RectangleMultiplication(n,m));
        }


}
