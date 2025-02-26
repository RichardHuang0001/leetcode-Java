package 链表;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 相交链表160 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
     //哈希表方法
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
    //双指针法
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
         ListNode pa = headA,pb = headB;
         while(true){
             if(pa == pb){
                 return pa;
             }
             if(pa==null){
                 pa = headB;
                 continue;
             }
             if(pb==null){
                 pb = headA;
                 continue;
             }
                 pa = pa.next;
                 pb = pb.next;
         }
    }
}
