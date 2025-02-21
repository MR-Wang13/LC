package ng.gs;

import java.util.*;
import java.util.stream.Collectors;

public class ReconstructFlightPath {
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            adj.putIfAbsent(ticket.get(0), new ArrayList<>());
        }

        tickets.sort(Comparator.comparing(a -> a.get(1)));
        for (List<String> ticket : tickets) {
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> res = new ArrayList<>();
        res.add("JFK");

        if (dfs("JFK", res, adj, tickets.size() + 1)) {
            return res;
        }
        return new ArrayList<>();
    }

    private static boolean dfs(String src, List<String> res,
                        Map<String, List<String>> adj, int targetLen) {
        if (res.size() == targetLen) {
            return true;
        }

        if (!adj.containsKey(src)) {
            return false;
        }

        List<String> temp = new ArrayList<>(adj.get(src));
        for (int i = 0; i < temp.size(); i++) {
            String v = temp.get(i);
            adj.get(src).remove(i);
            res.add(v);
            if (dfs(v, res, adj, targetLen)) return true;
            adj.get(src).add(i, v);
            res.remove(res.size() - 1);
        }
        return false;
    }

    public static List<String> findItineraryTest(List<List<String>> tickets) {
        HashMap<String, List<String>> adj = new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }

        // sorting by lexio order
        for(Map.Entry<String, List<String>>  entry: adj.entrySet()){
            String key = entry.getKey();
            List<String> temp = new ArrayList<>(entry.getValue());
            temp.sort(Comparator.naturalOrder());
            adj.put(key,temp);
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");
        if(dfsTest("JFK",res,adj,tickets.size()+1)){
            return res;
        }
        return new ArrayList<>();

    }

    private static boolean dfsTest(String from, List<String> res, HashMap<String, List<String>> adj, int length) {
        if(res.size() == length){
            return true;
        }

        if(!adj.containsKey(from)){
            return false;
        }

        List<String> temp = new ArrayList<>(adj.get(from));
        for(int i = 0; i < temp.size(); i++){
            String to = temp.get(i);
            res.add(to);
            adj.get(from).remove(i);
            if(dfs(to, res, adj, length)){
                return true;
            }
            adj.put(from, temp);
            res.remove(res.size() -1 );

        }
        return false;
    }
    /**
     * Time complexity O(E*logE)
     * Recursion
     * */
    public static List<String> findItineraryPQ(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).offer(dst);
        }

        List<String> res = new ArrayList<>();
        dfs(adj, "JFK", res);

        Collections.reverse(res);
        return res;
    }
    /**
     * Time complexity O(E logE)
     * Iteration
     * */
    public static List<String> findItineraryIteration(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> list : tickets){
            String from  = list.get(0);
            String to  = list.get(1);
            adj.computeIfAbsent(from, k -> new PriorityQueue<String>()).add(to);
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        LinkedList<String> res = new LinkedList<>();
        while(!stack.isEmpty()){
            String from = stack.peek();
            if(!adj.containsKey(from) || adj.get(from).isEmpty()){
                res.addFirst(stack.pop());
            }else{
                stack.push(adj.get(from).poll());
            }
        }
        return res;
    }
    private static void dfs(Map<String, PriorityQueue<String>> adj,
                     String src, List<String> res) {
        PriorityQueue<String> queue = adj.get(src);
        while (queue != null && !queue.isEmpty()) {
            String dst = queue.poll();
            dfs(adj, dst, res);
        }
        res.add(src);
    }
    public static void main(String[] args) {
        String[][] tickets = {{"HOU","JFK"},{"SEA","JFK"},{"JFK","SEA"},{"JFK","HOU"}};
        List<List<String>> list = Arrays.stream(tickets)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        System.out.println(findItineraryIteration(list));
    }
}
