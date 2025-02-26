package 链表;

import java.util.LinkedList;
import java.util.List;

public class 回文链表234 {

    //方法一 用栈来记录
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        List<Integer> stack = new LinkedList<>();
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            stack.add(slow.val);
        }
        if(fast!=null){
            slow=slow.next;
        }
        for (int i = stack.size() - 1; i >= 0; i--) {
            if (stack.get(i) != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
    //方法二 反转链表
    public boolean isPalindrome2(ListNode head) {
        ListNode fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast!=null){
            slow = slow.next;
        }
        ListNode pre = null,cur = slow;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next= pre;
            pre = cur;
            cur = next;
        }
        while(pre!=null){
            if(pre.val!=head.val){
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }
}
