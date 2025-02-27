package 链表;

public class 两两交换链表中的节点24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        if(head == null || head.next == null){
            return head;
        }
        ListNode p0 = dummy,left = head,right = head.next;

        while(p0.next != null && p0.next.next!= null) {
            left.next = right.next;
            right.next = left;
            p0.next = right;

            //更新p0和left right
            p0 = left;
            if(p0.next != null && p0.next.next!= null){
                p0 = left;
                left = p0.next;
                right = left.next;
            }
        }
        return dummy.next;

    }
}
