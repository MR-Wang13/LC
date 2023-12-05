package lc.tree;

import lc.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    static List<String> result = new ArrayList<>();
    static List<List<Integer>> listAll = new ArrayList<>();
    static public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        listAll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findPath(root,list);
        for (List<Integer> item : listAll){
            StringBuilder sb = new StringBuilder();
            for (int i =0 ; i<item.size() ; i++){
                if (i==item.size()-1){
                    sb.append(item.get(i));
                }else {
                    sb.append(item.get(i)+"->");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    private static void findPath(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (root.left == null && root.right == null){
            List<Integer> temp = new ArrayList<>(list);
            listAll.add(temp);
        }

        if (root.left!=null)
            findPath(root.left,list);
        if (root.right!=null)
            findPath(root.right,list);
        list.remove(list.size()-1);

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
        System.out.println(binaryTreePaths(node1));
    }
}
