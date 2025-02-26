package 链表;

import java.util.HashSet;
import java.util.Set;

public class 环形链表141 {

    //快慢指针
    public static boolean hasCycle(ListNode head) {
        if(head==null){
          return false;
        }
        ListNode fast=head,slow=head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    //哈希表
    public static boolean hasCycle2(ListNode head) {
        Set<ListNode> hashSet = new HashSet<>();
        while(head != null){
            if(hashSet.contains(head)){
                return true;
            }
            hashSet.add(head);
            head = head.next;
        }
        return false;
    }
}
