package intern.zipRecruit;

public class CyclicShift {
    int solution(int[] arr){
        int count =0 ;
        for (int i =0 ; i<arr.length ; i++){
            for (int j=i+1; j<arr.length;j++){
                if (isPair(String.valueOf(arr[i]),String.valueOf(arr[j]))){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPair(String i, String j) {
        if(i.length()!=j.length())
            return false;

        return (i+i).contains(j);
    }

    public static void main(String[] args) {
        CyclicShift c = new CyclicShift();
        int[] arr = {13,5604,31,2,13,4560,546,654,456};
        System.out.println(c.solution(arr));
    }
}
