package 链表;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 排序链表148 {
    public ListNode sortList(ListNode head) {

        //最后才写的，递归基线条件
        if(head == null || head.next == null){
            //需要排序的链表为空或者只剩下一个节点
            return head;
        }

        //找到中间的节点
        ListNode slow=head,fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //这样slow就是中间节点,然后将链表从中间断开
        ListNode midNext = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(midNext);
        return merge(left,right);
    }
    public ListNode merge(ListNode left,ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(left != null && right != null){
            if(left.val < right.val){
                current.next = left;
                left = left.next;
            }else{
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        if(left == null){
            current.next = right;
        }
        if(right == null){
            current.next = left;
        }
        return dummy.next;
    }
}
