package lc.gragh;

import java.util.ArrayList;
import java.util.List;

public class LC797AllPaths {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph,list,result,0);
        return result;
    }

    private void dfs(int[][] graph, List<Integer> list, List<List<Integer>> result, int k) {
        if (k == graph.length-1){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i =0; i<graph[k].length;i++){
            list.add(graph[k][i]);
            dfs(graph,list,result,graph[k][i]);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        LC797AllPaths lc =new LC797AllPaths();
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(lc.allPathsSourceTarget(graph));
    }
}
