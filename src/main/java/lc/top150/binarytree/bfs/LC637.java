package lc.top150.binarytree.bfs;

import lc.top150.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ave = new ArrayList<>();
        if (root == null){
            return ave;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Double sum = 0.0;
            for (int i = 0 ; i<size ;i++){
                TreeNode node = queue.poll();
                sum+=node.val;
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            ave.add(sum/size);
        }
        return  ave;
    }
}
