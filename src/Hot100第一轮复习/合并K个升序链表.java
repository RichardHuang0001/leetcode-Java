package Hot100第一轮复习;

import 链表.ListNode;

import java.util.PriorityQueue;

public class 合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        //创建一个小根堆的比较节点大小的pq
        PriorityQueue<ListNode> pq = new PriorityQueue<>((node1,node2)->{return node1.val-node2.val;});

        //把每条链表的头入队
        for(ListNode node : lists){
            if(node != null) {
                pq.offer(node);
            }
        }
        //创建输出链表的dummy
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        //每次取出队首，放到输出链表中，如果它还有next，就把next入队
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
