package 链表;

import java.util.HashMap;
import java.util.Map;

public class 随机链表的复制138 {
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        if(!map.containsKey(head)){
            Node headNew = new Node(head.val);
            map.put(head,headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return map.get(head);

    }
}
