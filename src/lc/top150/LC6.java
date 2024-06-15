package lc.top150;

public class LC6 {
    public String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        StringBuilder result = new StringBuilder();
        int gap = 2*(numRows-1);
        char[] c = s.toCharArray();
        for (int i =0 ; i<numRows;i++){
            int index = i;
            while (index<c.length){
                if (i>0&&i<numRows-1){
                    result.append(c[index]);
                    int secondIndex= index+(gap-2*(i));
                    if (secondIndex<c.length) {
                        result.append(c[secondIndex]);
                    }
                    index+=gap;
                }else {
                    result.append(c[index]);
                    index += gap;
                }
            }

        }
        return result.toString();
    }

    public static void main(String[] args) {
        LC6 lc = new LC6();
        System.out.println(lc.convert("PAYPALISHIRING",4));
    }
}
