package lc.String;

public class KMP {
    //前缀表（不减一）Java实现
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;

    }

    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;

        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
        System.out.println(next);
    }

    int matchStr(String lStr, String sStr){
        int[] next = getNext(sStr);

        int j = 0;
        for (int i=0; i<lStr.length(); i++){
            while (j>0 && sStr.charAt(j)!= lStr.charAt(i)){
                j = next[j-1];
            }
            if (sStr.charAt(j) == lStr.charAt(i))
                j++;
            if (j == sStr.length()){
                return  i - sStr.length() +1;
            }
        }
        return  -1;
    }
    int[] getNext (String s){
        int j=0;
        int next[] = new int[s.length()];
        for (int i=0; i<s.length() ; i++){
            while (j>0 && s.charAt(i)!=s.charAt(j)){
                j = next[j-1];
            }
            if (s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }

    boolean checkRepeatable(String s){
        return true;
    }
    public static void main(String[] args) {
        KMP kmp = new KMP();
        int[] next = new int[9];
        kmp.getNext("abcabcabc");

        kmp.strStr("aabcaabdd","aabd");
    }
}
