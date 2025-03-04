package Hot100第一轮复习;

import 链表.ListNode;

import java.util.PriorityQueue;

public class 合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((node1,node2)->{return node1.val-node2.val;});
        for(ListNode node : lists){
            if(node != null) {
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if(node.next!=null){
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}
