package 链表;

public class 合并两个有序链表21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1,null);
        ListNode p = dummy;
        while(list1 !=null && list2 != null){
            if(list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
                p = p.next;
            }else{
                p.next = list2;
                list2 = list2.next;
                p = p.next;
            }
        }
        if(list1==null){
            p.next = list2;
        }else{
            p.next = list1;
        }
        return dummy.next;
    }
}
