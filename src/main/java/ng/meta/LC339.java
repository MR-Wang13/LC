package ng.meta;

import java.util.ArrayList;
import java.util.List;

public class LC339 {
    static class NestedInteger{
        int val = -1;
        List<NestedInteger> list = new ArrayList<>();
        boolean isDigit(){
            return val != -1;
        }
    }
    public static int depthSum(List<NestedInteger> nestedList) {
        return computeDepthSum(nestedList, 1);
    }

    private static int computeDepthSum(List<NestedInteger> nestedList, int depth) {
        int total = 0;
        for(NestedInteger nestedInteger : nestedList){
            if(nestedInteger.isDigit()){
                total += nestedInteger.val * depth;
            }else {
                total+= computeDepthSum(nestedInteger.list,depth+1);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>();
        NestedInteger n1 = new NestedInteger();
        NestedInteger n2 = new NestedInteger();
        NestedInteger n3 = new NestedInteger();
        NestedInteger n4 = new NestedInteger();
        NestedInteger n5 = new NestedInteger();
        NestedInteger n6 = new NestedInteger();
        NestedInteger n7 = new NestedInteger();
        NestedInteger n8 = new NestedInteger();
        NestedInteger n9 = new NestedInteger();
        n1.val = 1;
        n3.val = 2;
        n4.val = 2;
        n2.list.add(n3);
        n2.list.add(n4);
        n5.list.add(n6);
        n5.list.add(n7);
        n7.val = 2;
        n8.val = 3;
        n6.list.add(n8);
        n9.val = 1;
        list.add(n1);
        list.add(n2);
        list.add(n5);
        list.add(n9);

        System.out.println(depthSum(list));
    }
}
