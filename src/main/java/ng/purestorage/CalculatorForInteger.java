package ng.purestorage;

public class CalculatorForInteger {
    static int calculator(String s){
        int totalScores = 0;
        int sequenceLength = 1;
        int consecutive3 = 1;
        for(int i = 0; i < s.length(); i++){
            int num = Character.getNumericValue(s.charAt(i));
            if(num == 5){
                totalScores+=2;
            }
            if(num % 2 == 1){
                totalScores++;
            }
            if(i >0 && num == 3 && s.charAt(i - 1) == '3' ){
                consecutive3++;
            }else {
                if(consecutive3 >= 2){
                    int extra = 0;
                    if (consecutive3 > 2){
                        extra = (consecutive3  - 2) * 4;
                    }
                    totalScores+= 4 + extra;
                }
                consecutive3 = 1;
            }
            if( i > 0 && num == Character.getNumericValue(s.charAt(i - 1)) + 1 ){
                sequenceLength++;
            }else if ( i > 0 && num != Character.getNumericValue(s.charAt(i - 1)) + 1  ){
                totalScores+= Math.pow(sequenceLength, 2);
                sequenceLength = 1;
            }
        }
        totalScores+= Math.pow(sequenceLength, 2);
        if(consecutive3 >= 2){
            int extra = 0;
            if (consecutive3 > 2){
                extra = (consecutive3  - 2) * 4;
            }
            totalScores+= 4 + extra;
        }

        if(Integer.parseInt(s) % 5 == 0 ){
            totalScores += 6;
        }

        return totalScores;

    }

    public static void main(String[] args) {
        System.out.println(calculator("456"));
    }
}
