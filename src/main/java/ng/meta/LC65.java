package ng.meta;

public class LC65 {
    public boolean isNumber(String s) {
        int index = 0;
        int n = s.length();
        boolean e = false, digit = false, dot = false;
        while (index < n){
            char c = s.charAt(index);
            if(c == '-' || c == '+'){
                if(index != 0){
                    char pre = s.charAt(index - 1);
                    if(pre != 'e' && pre != 'E'){
                        return false;
                    }
                }
            }else if(Character.isDigit(c)){
                digit = true;
            }else if(c == 'e' || c == 'E'){
                if(!digit || e){
                    return false;
                }
                e = true;
                digit = false;
            }else if(c == '.'){
                if(dot || e){
                    return false;
                }
                dot = true;
            }else{
                return false;
            }
            index++;
        }
        return digit;

    }
}
