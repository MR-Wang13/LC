package lc.regular;

import java.util.HashSet;

public class LC886 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (dislikes.length==0){
            return true;
        }
        HashSet<Integer> group1 = new HashSet<>();
        HashSet<Integer> group2 = new HashSet<>();

        return backtracking(dislikes,group1,group2,0,dislikes[0][0],dislikes[0][1]) || backtracking(dislikes,group1,group2,0,dislikes[0][1],dislikes[0][0]);
    }

    private boolean backtracking(int[][] dislikes, HashSet<Integer> group1, HashSet<Integer> group2, int k,int a,int b) {

        if (group1.contains(a)&&group1.contains(b)
                ||group2.contains(a)&&group2.contains(b)){
            return false;
        }
        if (group2.contains(a) || group1.contains(b)){
            return false;
        }
        group1.add(a);
        group2.add(b);

        if(k == dislikes.length-1){
            return true;
        }

        boolean m = backtracking(dislikes,group1,group2,k+1,dislikes[k+1][0],dislikes[k+1][1]);
        group1.remove(a);
        group2.remove(b);
        boolean n = backtracking(dislikes,group1,group2,k+1,dislikes[k+1][1],dislikes[k+1][0]);

        return  m || n;

    }

    public static void main(String[] args) {
        LC886 lc886 = new LC886();
        int[][] dislikes = {{1,2},{3,4},{5,6},{6,7},{8,9},{7,8}};


                ;
        System.out.println(lc886.possibleBipartition(3,dislikes));
    }
}
