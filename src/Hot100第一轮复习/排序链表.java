package Hot100第一轮复习;

import 链表.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 排序链表 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,2,1,3);
        ListNode head = ListNode.createList(list);
    }
    public ListNode sortList(ListNode head) {
        if(head==null|| head.next == null){
            return head;
        }
        ListNode fast = head.next,slow = head;
        while(fast!=null && fast.next!=null){
             fast = fast.next.next;
             slow = slow.next;
        }
        //从中间断开
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left,right);

    }
    public ListNode merge(ListNode node1,ListNode node2){
        if(node1 == null){
            return node2;
        }else if(node2==null){
            return node1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(node1!=null || node2!=null){
            if(node1==null){
                p.next = node2;
                break;
            }else if(node2==null){
                p.next = node1;
                break;
            }
            if(node1.val<node2.val){
                p.next = node1;
                p = p.next;
                node1 = node1.next;
            }else{
                p.next = node2;
                p = p.next;
                node2 = node2.next;
            }
        }
        return dummy.next;
    }
}
