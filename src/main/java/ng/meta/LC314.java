package ng.meta;

import java.util.*;
import java.util.stream.Collectors;

public class LC314 {
    public static List<List<Integer>> getVertical(TreeNode node){
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        traverse(node, map, 0);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> list : map.values()){
            ans.add(list);
        }
        return ans;
    }

    private static void traverse(TreeNode node, TreeMap<Integer, List<Integer>> map, int offset) {
        if(node == null){
            return;
        }
        map.computeIfAbsent(offset, k -> new ArrayList<>()).add(node.val);
        traverse(node.left,map,offset - 1);
        traverse(node.right,map,offset + 1);
    }

    public static void main(String[] args) {
        TreeNode node1  = new TreeNode(3);
        TreeNode node2  = new TreeNode(9);

        TreeNode node3  = new TreeNode(20);
        TreeNode node4  = new TreeNode(15);
        TreeNode node5  = new TreeNode(7);
        //TreeNode node6  = new TreeNode(7);
        //TreeNode node7  = new TreeNode(10);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        getVertical(node1);

    }
}
