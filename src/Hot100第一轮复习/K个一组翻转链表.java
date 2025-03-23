package Hot100第一轮复习;

import 链表.ListNode;

public class K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //先获取链表长度
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        int len = 0;
        while(p!=null){
            len++;
            p = p.next;
        }
        ListNode p0 = dummy,prev = dummy,cur = head;
        while(len>=k){
            for (int i = 0; i < k; i++) {//每次翻转k个节点，循环k次
                //下面的4行是标准的翻转链表的一步动作
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = cur.next;
            }
            //完成一组之后，p0也要更新位置，所以要先把p0.next存下来
            ListNode p0Next = p0.next;
            p0.next.next = cur;
            p0.next = prev;
            len -=k;
            p0 = p0Next;
        }
        return dummy.next;
    }
}
