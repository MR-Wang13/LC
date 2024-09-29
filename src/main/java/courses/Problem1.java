package courses;

import java.util.Arrays;

public class Problem1 {
    /**
     *
     * Problem1
     * */
    public int[] mergeArrayBySort(int[] m, int[] n){
        if (m.length==0){
            return n;
        }
        if (n.length==0){
            return m;
        }
        int length = m.length+n.length;
        int[] A = new int[length];
        int index = 0;
        int i = 0;
        int j = 0;
        while(i<m.length && j<n.length){
            if (m[i]<n[j]){
                A[index++] = m[i++];
            }else {
                A[index++] = n[j++];
            }
        }
        if (i==m.length){
            System.arraycopy(n,j,A,i+j,n.length-j);
        }else if((j==n.length)) {
            System.arraycopy(m,j,A,i+j,m.length-j);
        }

        return A;

    }
    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        int[] m, n;
        m = new int[]{}; n = new int[]{3, 7, 9};
        System.out.println("Test case 1: "+Arrays.toString(problem1.mergeArrayBySort(m,n)));

        m = new int[]{2, 7, 9}; n = new int[]{1};
        System.out.println("Test case 2: "+Arrays.toString(problem1.mergeArrayBySort(m,n)));

        m = new int[]{1, 7, 10, 15} ; n = new int[]{3, 8, 12, 18};
        System.out.println("Test case 3: "+Arrays.toString(problem1.mergeArrayBySort(m,n)));

        m = new int[]{1, 3, 5, 5, 15, 18, 21} ; n = new int[]{5, 5, 6, 8, 10, 12, 16, 17, 17, 20, 25, 28};
        System.out.println("Test case 4: "+Arrays.toString(problem1.mergeArrayBySort(m,n)));



    }

}
