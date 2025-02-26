package 链表;

import java.util.HashSet;
import java.util.Set;

public class 环形链表II142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visitedSet = new HashSet<>();
        while(head != null){
            if(visitedSet.contains(head)){
                return head;
            }
            visitedSet.add(head);
            head = head.next;
        }
        return null;
    }
}

