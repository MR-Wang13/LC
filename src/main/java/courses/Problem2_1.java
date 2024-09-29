package courses;

import java.math.BigInteger;

public class Problem2_1 {
    public static BigInteger multiply(BigInteger a, BigInteger b) {
        BigInteger s = new BigInteger("0") ;
        boolean isNegative = false;
        BigInteger zero = new BigInteger("0");
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");

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

        while (a.compareTo(one) >=0) {
            if (a.divideAndRemainder(two)[1].compareTo(one)==0) {
                s = s.add(b);
            }
            a = a.divide(two);
            b = b.multiply(two);
        }

        return isNegative ? s.multiply(minusOne) : s;
    }

    public static void main(String[] args) {
        BigInteger n,m;
        n = new BigInteger("7000") ; m = new BigInteger("7294");
        System.out.println("Ala Carte Multiplication Test case 1 :"+multiply(n,m));
        n = new BigInteger("25") ; m = new BigInteger("5038385");
        System.out.println("Ala Carte Multiplication Test case 2 :"+multiply(n,m));
        n = new BigInteger("-59724") ; m = new BigInteger("783");
        System.out.println("Ala Carte Multiplication Test case 3 :"+multiply(n,m));
        n = new BigInteger("8516") ; m = new BigInteger("-82147953548159344");
        System.out.println("Ala Carte Multiplication Test case 4 :"+multiply(n,m));
        n = new BigInteger("45952456856498465985") ; m = new BigInteger("98654651986546519856");
        System.out.println("Ala Carte Multiplication Test case 5 :"+multiply(n,m));
        n = new BigInteger("-45952456856498465985") ; m = new BigInteger("-98654651986546519856");
        System.out.println("Ala Carte Multiplication Test case 6 :"+multiply(n,m));


    }
}
