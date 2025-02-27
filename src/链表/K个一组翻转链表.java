package 链表;

import java.util.Arrays;
import java.util.List;

public class K个一组翻转链表 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5);

        ListNode head = ListNode.createList(nums);
        System.out.println(head);
        ListNode res = reverseKGroup(head, 2);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        //统计链表长度
        ListNode p = head;
        int len = 0;
        while(p!=null){
            len++;
            p = p.next;
        }
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        ListNode cur = pre.next;
        ListNode p0 = dummy;
        ListNode p0Nxt = p0.next;
        while(len>=k){
            for (int i = 0; i < k; i++) {//循环k次
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
//        System.out.println("p0.val="+p0.val+" p0.next.val="+p0.next.val+" pre.val="+pre.val+" cur.val="+cur.val);
            //当前pre=K区间内反转后的头节点，原来的最后节点，cur为下一个K区间的第一个节点
            p0Nxt = p0.next;//p0Nxt是旧k区间的头节点，也是新k区间的尾节点，也是下一个k区间的p0
            p0.next = pre;
            p0Nxt.next = cur;
            p0 = p0Nxt;
            len -=k;
        }


        return dummy.next;
    }
}
