package intern;

import java.util.ArrayList;
import java.util.List;

public class NumbersStation {


    public void ProcessSample(int[] numbers,char[] chars){
        int initNum ;
        int i = 0;
        while (chars[i++]!='-'){

        }
        initNum = numbers[i-1];
        List<Character> message = new ArrayList<>();
        for (int k =i; k<numbers.length; k++){
            if (chars[k]=='-' && numbers[k]==initNum+1){
                initNum++;
                OnMessageComplete(message);
                message.clear();

            }else {
                if (numbers[k]==initNum+1){
                    initNum++;
                    message.add(chars[k]);
                }else {
                    initNum = numbers[k];
                    message.clear();
                }
            }
        }
    }
    public void  OnMessageComplete (List<Character> chars){
        for (char c : chars){
            System.out.print(c);
        }
    }
    public static void main(String[] args) {
        char a = 'a';
        char b= 'b';
        System.out.println("a:"+(int)a+"  b:"+(int)b);

        a^=b;
        System.out.println("a:"+(int)a+"  b:"+b);
        b^=a;
        System.out.println("a:"+(int)a+"  b:"+b);
        a^=b;
        System.out.println("a:"+a+"  b:"+b);



    }
}
