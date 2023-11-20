package lc.doublePoint;

public class replaceBlank {
    private static String replace(String s){
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()){
            if (c==' '){
                result.append("%20");
            }else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(replace( "We are happy."));
    }

}
