package lc.top150.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC207 {
    boolean canFinish = true;

    int[] path ,visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        canFinish = true;
        path = new int[numCourses];
        visited = new int[numCourses];
        List<Integer>[] graph = buildGraph(numCourses,prerequisites);


        for (int i = 0 ; i <numCourses;i++){
            travelDFS(i,graph);
        }
        return canFinish;
    }

    private void travelDFS(int i, List<Integer>[] graph) {
        if (path[i] == 1){
            canFinish = false;
        };
        if (visited[i]==1||canFinish){
            return;
        }
        path[i] = 1;
        visited[i] = 1;

        for (int next:graph[i]){
            travelDFS(next,graph);
        }
        path[i] =0;

    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i =0 ; i<numCourses;i++ ){
            List<Integer> g = new ArrayList<>();
            graph[i] =g;
        }

        for (int[] course : prerequisites){
            List<Integer> g = graph[course[1]];
            g.add(course[0]);
        }
        return graph;
    }

    public static void main(String[] args) {
        int num = 3;
        int[][] pre= {{695,229},{199,149},{199,149}};
        LC207 lc = new LC207();
        System.out.println(lc.canFinish(num,pre));

    }
}
