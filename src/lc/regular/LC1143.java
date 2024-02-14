package lc.regular;

import java.util.HashMap;

public class LC1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int i =0 ,j =0;
        int max = 0;

        while (i<text1.length() && j<text2.length()){
            int n = i;
            while (n<text1.length()&& text1.charAt(n)!=text2.charAt(j)){
                n++;
            }
            if (n==text1.length()){
                j++;
            }else {
                i=n;
                break;
            }
        }
        if (j==text2.length()){
            return max;
        }
        while (i<text1.length() && j<text2.length()){
            if (text1.charAt(i)==text2.charAt(j)){
                max++;
                i++;j++;
            }else {
                int m = j;
                while (m<text2.length()&& text1.charAt(i)!=text2.charAt(m)){
                    m++;
                }
                if (m==text2.length()){
                    i++;
                }else {
                    max++;
                    i++; j=m+1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LC1143 lc1143 = new LC1143();
        String text1 = "oxcpqrsvwf", text2 = "shmtulqrypy";
        System.out.println(lc1143.longestCommonSubsequence(text1,text2));
    }
}
