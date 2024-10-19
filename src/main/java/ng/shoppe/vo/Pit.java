package ng.shoppe.vo;

public class Pit {
    public static void main(String[] args) {
        int[] urinals = {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0};
        int n = urinals.length;
        int[] leftBound = new int[n];
        int[] rightBound = new int[n];

        leftBound[0] = -1;
        for (int i = 1; i < n; i++){
            if(urinals[i-1] == 1){
                leftBound[i] = i-1;
            }else {
                leftBound[i] = leftBound[i-1];
            }
        }
        rightBound[n-1] = n;
        for (int i = n-2; i >= 0; i--){
            if(urinals[i+1] == 1){
                rightBound[i] = i+1;
            }else {
                rightBound[i] = rightBound[i+1];
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++){
            if(urinals[i]==0){
                if(i ==0){
                    max = Math.max(max, rightBound[i] - i);
                }else if( i == n-1){
                    max = Math.max(max, i - leftBound[i]);
                }else {
                    max = Math.max(max, Math.min(rightBound[i] - i, i - leftBound[i]));
                }
            }
        }
        System.out.println(max);
    }
}
