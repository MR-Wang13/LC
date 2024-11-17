package ng.meta;

import java.util.*;
import java.util.stream.Collectors;

public class LC314 {
    public List<Integer> getVertical(TreeNode node){
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        traverse(node, map, 0);
        List<Integer> ans = new ArrayList<>();
        for(List<Integer> list : map.values()){
            ans.addAll(list);
        }
        return ans;
    }

    private void traverse(TreeNode node, TreeMap<Integer, List<Integer>> map, int offset) {
        if(node == null){
            return;
        }
        map.computeIfAbsent(offset, k -> new ArrayList<>()).add(node.val);

        traverse(node.left,map,offset - 1);
        traverse(node.right,map,offset + 1);
    }
}
