package 链表;

public class 删除链表的倒数第N个结点19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1,head);
        ListNode fast = dummy,slow = dummy;
        for (int i = 0; i <n ; i++) {//先走n-1步
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //这时候slow指向目标节点的前一个节点
        if(slow!=null && slow.next != null) {
            slow.next = slow.next.next;
        }else{
            slow.next = null;
        }
        return dummy.next;
    }
}
