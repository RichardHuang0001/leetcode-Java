package 链表;

import java.util.List;

public class 反转链表II92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1,head);
        ListNode p0 = dummy;
        for (int i = 0; i < left-1; i++) {
            p0 = p0.next;
        }
        ListNode p1 = dummy;
        for (int i = 0; i <right+1 ; i++) {
            p1 = p1.next;
        }
        ListNode pre = p0,cur = p0.next;
        while(cur != p1){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p0.next.next=p1;
        p0.next = pre;
        return dummy.next;
    }
}
