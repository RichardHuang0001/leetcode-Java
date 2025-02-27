package 链表;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class 合并K个升序链表 {
    public static void main(String[] args) {
        // 构造输入的三个链表
        // [1,4,5]
        ListNode list1 = ListNode.createList(Arrays.asList(1, 4, 5));

        // [1,3,4]
        ListNode list2 = ListNode.createList(Arrays.asList(1, 3, 4));

        // [2,6]
        ListNode list3 = ListNode.createList(Arrays.asList(2, 6));

        // 将链表放入数组
        ListNode[] lists = new ListNode[]{list1, list2, list3};

        // 打印原始链表
        System.out.println("原始链表:");
        for (int i = 0; i < lists.length; i++) {
            System.out.println("链表 " + (i + 1) + ": " + lists[i]);
        }

        // 调用你的解决方法
        ListNode result = mergeKLists(lists);

        // 打印结果
        System.out.println("\n合并后的链表:");
        System.out.println(result);
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((node1,node2)->{return node1.val-node2.val;});
        int len = lists.length;
        for (int i = 0; i < len; i++) {
            if(lists[i]!=null){
                pq.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.remove();
            p.next = min;
            p = p.next;
            if(min.next != null){
                pq.offer(min.next);
            }
        }
        return dummy.next;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((node1,node2)->{return node1.val-node2.val;});
        if(list1 != null){pq.offer(list1);}
        if(list2 != null){pq.offer(list2);}
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(!pq.isEmpty()){
            p.next = pq.remove();
            if(p.next.next != null){
                pq.offer(p.next.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
    public int nthUglyNumber(int n) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        set.add(1);
        int x = 1;
        for (int i=0;i<n;i++){
            x = pq.remove();
            set.remove(x);
            if(!set.contains(2*x)){
                set.add(2*x);
                pq.offer(2*x);
            }
            if(!set.contains(3*x)){
                set.add(3*x);
                pq.offer(3*x);
            }
            if(!set.contains(5*x)){
                set.add(5*x);
                pq.offer(5*x);
            }
        }
        return x;
    }
}
