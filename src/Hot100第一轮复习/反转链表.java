package Hot100第一轮复习;

import 链表.ListNode;

import java.util.List;

public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        if(head == null){return head;}
        ListNode prev = head,cur = head.next;
        prev.next = null;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
