package lc.regular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LC2225 {
    static public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,Integer> winners = new HashMap<>();
        HashMap<Integer,Integer> losers = new HashMap<>();
        int max = 0;
        for (int[] match : matches){
            max = Math.max(max,match[0]);
            max = Math.max(max,match[1]);
            winners.put(match[0],winners.getOrDefault(match[0],0)+1);
            losers.put(match[1],losers.getOrDefault(match[1],0)+1);
        }
        List<Integer> notLost = new ArrayList<>();
        List<Integer> winnerKeys =  winners.keySet().stream().sorted().collect(Collectors.toList());
        winnerKeys.forEach(key->{
            if (!losers.keySet().contains(key)){
                notLost.add(key);
            }
        });
        List<Integer> oneLost = new ArrayList<>();

        losers.keySet().stream().sorted().collect(Collectors.toList()).forEach(key->{
            if (losers.get(key)==1){
                oneLost.add(key);
            }
        });
        result.add(notLost);
        result.add(oneLost);
        return result;
    }

    public static void main(String[] args) {
        int[][] matchs = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        findWinners(matchs);
    }
}
