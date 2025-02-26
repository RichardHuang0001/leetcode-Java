package 链表;

public class 两数相加2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode dummy = new ListNode(-1,null);
        ListNode p = dummy;
        while(l1 != null || l2 != null){
            int l1Val = l1!=null ? l1.val:0;
            int l2Val = l2!=null ? l2.val:0;
            int sum = l1Val+l2Val;
            if(carry){
                sum+=1;
                carry = false;
            }
            if(sum>=10){
                carry=true;
                sum-=10;
            }
            p.next = new ListNode(sum,null);
            p = p.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry){
            p.next = new ListNode(1,null);
        }
        return dummy.next;
    }
}
