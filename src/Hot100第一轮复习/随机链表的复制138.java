package Hot100第一轮复习;

import 链表.Node;

import java.util.HashMap;
import java.util.Map;

public class 随机链表的复制138 {
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        return backtrack(head);
    }
    public Node backtrack(Node head){
        if(head==null){
            return null;
        }
        if(map.containsKey(head)){
            return map.get(head);
        }
        Node node = new Node(head.val);
        map.put(head,node);
        node.next = backtrack(head.next);
        node.random = backtrack(head.random);
        return node;
    }
}
