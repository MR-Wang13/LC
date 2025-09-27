package ng.uber;

import java.util.*;

public class PhoneScreen2025 {
    // 比较的是单词之间 不是单词内部的字母
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> orderMap = new HashMap<>();
        for( int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            orderMap.put(c,i);
        }
        for(int i = 0; i < words.length - 1; i++){
            for(int j = 0; j < words[i].length(); j++){
                if (j >= words[i + 1].length()){
                    return false;
                }
                char cur = words[i].charAt(j);
                char nxt = words[i + 1].charAt(j);
                if(orderMap.get(cur) > orderMap.get(nxt)){
                    return false;
                }else if(orderMap.get(cur).equals(orderMap.get(nxt))){
                    continue;
                }else {
                    break;
                }
            }
        }
        return true;
    }
    public String alienOrder(String[] words) {
        Map<Character,Set<Character>> graph = new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                graph.putIfAbsent(c, new HashSet<>());
                indegree.put(c,0);
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String curWord = words[i];
            String nxtWord = words[i + 1];
            for(int j = 0; j < curWord.length();j++){
                if(j >= nxtWord.length()){
                    break;
                }
                if(curWord.charAt(j) != nxtWord.charAt(j)){
                    if (!graph.get(curWord.charAt(j)).contains(nxtWord.charAt(j))){
                        graph.get(curWord.charAt(j)).add(nxtWord.charAt(j));
                        indegree.put(nxtWord.charAt(j),indegree.get(nxtWord.charAt(j)) + 1);
                    }
                    break;
                }

            }
        }
        StringBuilder result = new StringBuilder();
        Deque<Character> queue = new LinkedList<>();
        for(Map.Entry<Character,Integer> entry : indegree.entrySet()){
            if (entry.getValue() == 0){
                queue.add(entry.getKey());
            }
        }
        while (!queue.isEmpty()){
            Character c = queue.pop();
            result.append(c);
            if(!graph.get(c).isEmpty()){
                for(char nxtNode : graph.get(c)){
                    indegree.put(nxtNode,indegree.get(nxtNode) - 1);
                    if (indegree.get(nxtNode) == 0){
                        queue.add(nxtNode);
                    }
                }
            }
        }
        return result.toString();
    }
    //79
    public boolean exist(char[][] board, String word) {
        Set<String> visited = new HashSet<>();
        StringBuilder path = new StringBuilder();
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(path(i,j,visited,path,board,word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean path(int i, int j, Set<String> visited, StringBuilder path,char[][] board, String word) {
        int m = board.length, n = board[0].length;
        int[][] directs = {{1,0},{0,1},{-1,0},{0,-1}};
        if(i >= m || i < 0 || j >=n || j <0 || visited.contains(i+"-"+j)){
           return false;
        }
        path.append(board[i][j]);
        visited.add(i + "-" +j);

        if(word.equals(path.toString())){
            return true;
        }
        for(int[] direct : directs){
            if(path(i + direct[0],j + direct[1],visited,path,board,word))
                return true;
        }
        visited.remove(i + "-" +j);
        path.deleteCharAt(path.length() - 1);
        return false;
    }

    public static void main(String[] args) {
        PhoneScreen2025 lc = new PhoneScreen2025();
        /*String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        lc.isAlienSorted(words,order);*/
        String[] words = {"wrt","wrf","er","ett","rftt"};
        //wertf
        System.out.println(lc.alienOrder(words));

     }
}


class GreedyDriverPassengerMatching {

    public static List<int[]> match(int[][] drivers, int[][] passengers) {
        int m = drivers.length;
        int n = passengers.length;

        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int dist = Math.abs(drivers[i][0]-passengers[j][0]) +  Math.abs(drivers[i][1]-passengers[j][1]);
                pairs.add(new int[]{i,j,dist});
            }
        }

        pairs.sort(Comparator.comparingInt(p -> p[2]));

        boolean[] driverUsed = new boolean[m];
        boolean[] psgUsed = new boolean[n];
        List<int[]> result = new ArrayList<>();

        for (int[] pair : pairs){
            if (!driverUsed[pair[0]] && !psgUsed[pair[1]]){
                result.add(pair);
                driverUsed[pair[0]]  = true;
                psgUsed[pair[1]] = true;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] drivers = {{0, 0}, {2, 1}};
        int[][] passengers = {{1, 2}, {3, 3}};
        List<int[]> matches = match(drivers, passengers);

        for (int[] match : matches) {
            System.out.println("Driver " + match[0] + " -> Passenger " + match[1]);
        }
    }
}