package ng.meta;

import java.util.*;

public class LC721 {
    static class Email{
        String addr;
        String name;
        Email(String addr, String name){
            this.addr = addr;
            this.name = name;
        }

    }
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Email> emailMap = new HashMap<>();
        TreeMap<String, List<String>> gragh = new TreeMap<>();
        for(List<String> str : accounts){
            String name = str.get(0);
            for(int i = 1; i < str.size(); i++){
                String addr = str.get(i);
                if(!emailMap.containsKey(addr)){
                    emailMap.put(addr, new Email(addr, name));
                    gragh.putIfAbsent(addr, new ArrayList<>());
                }
                for(int j = i +1; j < str.size(); j++){
                    gragh.computeIfAbsent(addr, k -> new ArrayList<>()).add(str.get(j));
                    gragh.computeIfAbsent(str.get(j), k -> new ArrayList<>()).add(addr);
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        HashSet<String> visited = new HashSet();
        for(String email : gragh.keySet()){
            if(visited.contains(email)){
                continue;
            }
            List<String> sub = new ArrayList<>();
            Queue<String> queue = new LinkedList<>();
            queue.add(email);
            sub.add(email);
            visited.add(email);
            while(!queue.isEmpty()){
                String node = queue.poll();
                List<String> adj = gragh.get(node);
                for(String neighbor : adj){
                    if(!visited.contains(neighbor)){
                        sub.add(neighbor);
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            ans.add(sub);
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> list : ans){
            Collections.sort(list, Comparator.naturalOrder());
            List<String> newList  = new ArrayList<>();
            newList.add(emailMap.get(list.get(0)).name);
            newList.addAll(list);
            result.add(newList);
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] accounts = {{"John","johnsmith@mail.com","john_newyork@mail.com"},{"John","johnsmith@mail.com","john00@mail.com"},{"Mary","mary@mail.com"},{"John","johnnybravo@mail.com"}};
        accountsMerge(Arrays.stream(accounts).map(Arrays::asList).toList());
    }
}
