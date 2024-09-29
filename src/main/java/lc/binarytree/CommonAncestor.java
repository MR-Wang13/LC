package lc.binarytree;

import lc.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CommonAncestor {

    int p ,q;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();

        seachTreeByMid(root,result1,p.val);
        seachTreeByMid(root,result2,q.val);

        return root;
    }

    private static boolean seachTreeByMid(TreeNode root, List<Integer> result, int target) {
        if (root == null){
            return false;
        }

        if (seachTreeByMid(root.left,result,target)){
            return true;
        };
        if (seachTreeByMid(root.right,result,target)){
            return true;
        }

        result.add(root.val);
        return false;
    }

    public static void main(String[] args) {
        TreeNode node1  = new TreeNode(3);
        TreeNode node2  = new TreeNode(5);

        TreeNode node3  = new TreeNode(1);
        TreeNode node4  = new TreeNode(6);
        TreeNode node5  = new TreeNode(2);
        TreeNode node6  = new TreeNode(0);
        TreeNode node7  = new TreeNode(8);
        TreeNode node8  = new TreeNode(7);
        TreeNode node9  = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        lowestCommonAncestor(node1,node2,node3);

    }
}
