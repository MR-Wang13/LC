package lc.regular;
import lc.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC1457 {
    int count =0 ;

    public int pseudoPalindromicPaths (TreeNode root) {
        List<Integer> path = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        findPath(path,root,map);
        return count;
    }


    private void findPath(List<Integer> path, TreeNode root, HashMap<Integer, Integer> map) {
        path.add(root.val);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        if (root.left==null && root.right==null){
            if (checkPathPP(map)){
                count++;
            }
            map.put(path.get(path.size()-1),map.get(path.get(path.size()-1))-1);

            path.remove(path.size()-1);
            return;
        }

        if (root.left!=null) {
            findPath( path, root.left, map);
        }
        if (root.right!=null){
            findPath( path, root.right, map);
        }
        map.put(path.get(path.size()-1),map.get(path.get(path.size()-1))-1);

        path.remove(path.size()-1);


    }

    private boolean checkPathPP(HashMap<Integer,Integer> map) {
        int count =0;
        for (int key :map.keySet()){
            if (map.get(key)%2==1){
                count++;
            }
            if (count>1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1  = new TreeNode(1);
        TreeNode node2  = new TreeNode(2);

        TreeNode node3  = new TreeNode(3);
        TreeNode node4  = new TreeNode(4);
        TreeNode node5  = new TreeNode(5);
        TreeNode node6  = new TreeNode(6);
        TreeNode node7  = new TreeNode(7);
        TreeNode node8  = new TreeNode(8);
        TreeNode node9  = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right=node5;
        LC1457 lc1457 = new LC1457();
        System.out.println(lc1457.pseudoPalindromicPaths(node1));
    }
}
