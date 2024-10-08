package lc.top150.linkedlist;

import java.util.List;

public class LC86 {
    public static ListNode partition(ListNode head, int x) {
        ListNode lessList = new ListNode();
        ListNode greList = new ListNode();
        ListNode preLess = lessList;
        ListNode preGreater  = greList;

        ListNode cur = head;
        while (cur!=null){
            if(cur.val<x){
                lessList.next = cur;
                lessList = lessList.next;
            }else {
                greList.next = cur;
                greList = greList.next;
            }
            cur =  cur.next;
        }
        greList.next = null;
        lessList.next = preGreater.next;

        return preLess.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        System.out.println(partition(n1,3));
    }
}
