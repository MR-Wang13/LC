package ng.tiktok.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class LC92 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dumpPre = new ListNode(-1,head);
        int length = right-left+1;
        ListNode findpre = dumpPre;
        while (left-->1){
            findpre = findpre.next;
        }

        ListNode newTail = findpre.next;
        findpre.next = reverseN(findpre.next,length);
        newTail.next = post;



        return dumpPre.next;


    }
    static ListNode post = null;
    public static ListNode reverseN(ListNode head,int n){
        if(n == 1){
            post = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next,n-1);
        head.next.next = head;

        return newHead;
    }

    public static ListNode reverse(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;

        head.next = null;
        return newHead;
    }


    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        Collections.reverse(player);
        int curIndex = 0;
        int curRank = 1;
        for(int score:player){
            for(int i = curIndex; i<ranked.size(); i++){
                if(ranked.get(i)<=score){
                    curIndex = i;
                    break;
                }else{
                    if(i<ranked.size() - 1 && ranked.get(i).compareTo(ranked.get(i+1))==0){
                        continue;
                    }
                    curRank++;
                }
            }
            result.add(curRank);

        }
        Collections.reverse(result);
        return result;
    }
    public static void main(String[] args) {
       /* ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(13);
        ListNode n3 = new ListNode(11);
        ListNode n4 = new ListNode(10);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head = reverseBetween(n1,1,5);
        System.out.println(head);*/

        int[] ranked = {100, 90, 90, 80, 75, 60};
        int[] player = {50, 65, 77, 90, 102};
        climbingLeaderboard(Arrays.stream(ranked)
                .boxed()
                .collect(Collectors.toList()),
                Arrays.stream(player)
                .boxed()
                .collect(Collectors.toList()));
    }
}
