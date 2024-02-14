package intern.snowflake;

import java.util.ArrayList;
import java.util.List;

public class RatioWaves {
    int max = 0;
    int cal(int networkNodes,int[] from,int[] to, int freq[]){
        int depth = 0;
        int[][] graph = new int[networkNodes+1][networkNodes+1];
        for (int i =0; i<from.length;i++){
            graph[from[i]][to[i]]=1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=networkNodes;i++){
            list.add(i);
            dfs(list,freq,i,graph);
            list.remove(list.size()-1);

        }
        return max;
    }

    private void dfs(List<Integer> list, int[] freq, int k, int[][] graph) {
        max =Math.max(list.size()-1,max);
        for (int i = 1 ; i<graph[k].length; i++){
            if (graph[k][i]==1 && Math.abs(freq[i-1]-freq[k-1])<=1){
                list.add(i);
                dfs(list,freq,i,graph);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        RatioWaves rw = new RatioWaves();
        int[] from = {1,1,1};
        int[] to = {2,3,4};
        int[] fre = {1,1,1,1};
        System.out.println(rw.cal(4,from,to,fre));
    }
}
