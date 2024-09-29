package intern.snowflake;

import java.util.ArrayList;
import java.util.List;

public class ArrayReduction {
    void solution(int n,int[] a){
            int[] csLeft=new int[n+1];
            for (int i:a) csLeft[i]++;
            int nAlive=n;
            int[] inPrefix=new int[n+1];
            int at=0;
            ArrayList<Integer> ans=new ArrayList<>();
            while (nAlive>0) {
                int mex=0;
                while (csLeft[mex]!=0) mex++;

                //need to pop until we reach mex
                ArrayList<Integer> modified=new ArrayList<>();
                int newMex=0;
                while (newMex<mex) {
                    int nextVal=a[at++];
                    modified.add(nextVal);
                    csLeft[nextVal]--;
                    inPrefix[nextVal]++;
                    nAlive--;
                    while (inPrefix[newMex]!=0)newMex++;
                }
                for (int i:modified) inPrefix[i]=0;
                ans.add(mex);
            }
            for (int i:ans) {
                System.out.print(i+" ");
            }

    }

    void solution1(int n,int[] a) {
        List<Integer> result = new ArrayList<>();
        int[] dict = new int[n+1];
        for (int i:a) dict[i]++;

        int at =0;
        int[] inPre =  new int[n+1];
        while (at<n){
            int mex =0;
            while (dict[mex]!=0) mex++;

            int curMex = 0;
            List<Integer> list = new ArrayList<>();
            while (curMex<mex){
                int val = a[at++];
                dict[val]--;
                inPre[val]++;
                list.add(val);
                while (inPre[curMex]!=0) curMex++;
            }
            for (int i : list){
                inPre[i] =0;
            }
            result.add(mex);
        }
        System.out.println(result);
    }

        public static void main(String[] args) {
        ArrayReduction ar = new ArrayReduction();
        int[] arr = {2,2,3,4,0,1,2,0};
        ar.solution1(8,arr);
    }
}
