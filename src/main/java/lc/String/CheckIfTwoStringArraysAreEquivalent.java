package lc.String;

public class CheckIfTwoStringArraysAreEquivalent {
    static public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0,index1 =0,index2 = 0;
        int j = 0;
        String a = null ,b = null;
        int length1=0,length2=0;
        while(i<word1.length && j< word2.length){
            if (a == null){
                a = word1[i];
                length1+=a.length();
                index1 = 0;
            }
            if (b==null){
                b= word2[j];
                length2+=b.length();
                index2 =0;
            }
            while (true){
                if (a.charAt(index1) != b.charAt(index2)){
                    return false;
                }
                index1++;
                index2++;
                if (index1 == a.length() && index2 == b.length() ){
                    a = null;
                    i++;
                    b = null;
                    j++;
                    break;
                } else if (index1 == a.length()){
                    a = null;
                    i++;
                    break;
                }else if (index2 == b.length()){
                    b = null;
                    j++;
                    break;
                }
            }

        }
        if (length1!=length2){
            return false;
        }
        if (i==j && word1.length != word2.length){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] word1  = {"o","b"};
        String[] word2 = {"o"};
        System.out.println(arrayStringsAreEqual(word1,word2));
    }
}
