package lc.top150;

public class LC151 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length-1;i>=0;i--){
            if (!"".equals(words[i])){
                sb.append(words[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }


    public String reverseWords1(String s) {
        int left = 0, right = s.length()-1;
        char[] c = s.toCharArray();
        while (left<right){
            char tmp = c[left];
            c[left] = c[right];
            c[right] = tmp;
            left++;
            right--;
        }
        return c.toString();
    }
    public static void main(String[] args) {
        LC151 lc = new LC151();
        System.out.println(lc.reverseWords1("a good   example"));
    }
}
