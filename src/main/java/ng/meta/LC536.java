package ng.meta;

import lc.TreeNode;

public class LC536 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static TreeNode constructTree(String s){
        if(s == null || s.length() == 0){
            return null;
        }
        TreeNode root = new TreeNode(Character.getNumericValue(s.charAt(0)));
        int start = s.indexOf('(');
        if(start != -1) {
            int count = -1;
            int end = -1;
            for (int i = start + 1; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    count--;
                } else if (s.charAt(i) == ')') {
                    count++;
                }
                if (count == 0) {
                    end = i;
                    break;
                }
            }

            root.left = constructTree(s.substring(start + 1, end));
            if(end < s.length()-1) {
                root.right = constructTree(s.substring(end+2, s.length() - 1));
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode node = constructTree("4(2(3)(1))(6(5))");
        System.out.println(node);
    }
}
