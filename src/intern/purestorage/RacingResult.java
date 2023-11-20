package intern.purestorage;

import java.util.HashMap;
import java.util.List;

public class RacingResult {
    HashMap<Integer,Integer> map  = new HashMap<>();
    static void getResult(List<Integer> record){

    }

    static int getPoint(int position){
        switch (position){
            case 1:
                return 10;
            case 2:
                return 6;
            case 3:
                return 4;
        }
        return 0;
    }

    public static void main(String[] args) {
        int i =3 , j =2;
        if (i>j){
            System.out.println("i>j");
        }
        if (i<j){
            System.out.println("j<j");
        }else {
            System.out.println("i=j");
        }
    }
}
