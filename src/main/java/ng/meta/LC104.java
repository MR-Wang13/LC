package ng.meta;
  class TreeNode {
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
public class LC104 {


    public static TreeNode str2tree(String s) {
        if(s.equals("")){
            return null;
        }
        TreeNode node = new TreeNode(Character.getNumericValue(s.charAt(0)));
        int start = s.indexOf('(');
        if(start == -1){
            return node;
        }
        int intercept = start;
        int cnt = 0;
        for(int i = start ; i < s.length(); i++){
            if(s.charAt(i) == '('){
                cnt++;
            }else if(s.charAt(i) == ')'){
                cnt--;
            }
            if(cnt == 0){
                intercept = i;
                break;
            }
        }

        node.left = str2tree(s.substring(start+1,intercept));
        if(intercept < s.length() -1) {
            node.right = str2tree(s.substring(intercept + 2));
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = str2tree("4(2(3)(1))(6(5))");
        System.out.println(node);
    }
}
