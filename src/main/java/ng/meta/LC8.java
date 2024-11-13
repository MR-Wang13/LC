package ng.meta;

public class LC8 {
    public static int myAtoi(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        boolean isNegtive = false;
        int start = 0;
        while(start < n && s.charAt(start) == ' '){
            start++;
        }

        if(start == n){
            return 0;
        }
        if(s.charAt(start) == '-'){
            isNegtive = true;
            start++;
        }else if(s.charAt(start) == '+'){
            start++;
        }


        while(start < n && s.charAt(start) == '0'){
            start++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < n; i++){
            if('0'<=s.charAt(i) && '9' >=s.charAt(i)){
                sb.append(s.charAt(i));
            }else{
                break;
            }
        }
        if( sb.length() == 0){
            return 0;
        }
        String max = String.valueOf(Integer.MAX_VALUE);
        String min = String.valueOf(Integer.MIN_VALUE).substring(1);

        boolean beyondMax = compareWithMax(max , sb.toString());
        boolean beyondMin = compareWithMax(min , sb.toString());

        int validNumber;
        if(isNegtive && beyondMin  ){
            validNumber = Integer.MIN_VALUE;
        }else if(!isNegtive && beyondMax){
            validNumber = Integer.MAX_VALUE;
        }else{
            validNumber = Integer.valueOf(sb.toString());
        }
        return isNegtive? -validNumber:validNumber;
    }

    private static boolean compareWithMax(String max, String s) {
        if(max.length() < s.length()){
            return true;
        }else if(max.length() > s.length()){
            return false;
        }
        for(int i = 0; i<max.length(); i++){
            if(max.charAt(i) > s.charAt(i)){
                return false;
            }else if(max.charAt(i) < s.charAt(i)){
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        myAtoi("-2147483648");
    }
}
