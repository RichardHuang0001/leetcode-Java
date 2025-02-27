package 链表;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LRUCache {
    int capacity;
    Node dummy;
    Map<Integer,Node> map = new HashMap<>();
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dummy = new Node(-1,-1);
        // 创建循环链表
        this.dummy.next = this.dummy;
        this.dummy.prev = this.dummy;
    }

    //找到节点，然后插入到链表头，然后返回value
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        putFront(node,dummy);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            putFront(node,dummy);
        }else{
            if(map.size() == capacity){
                Node node = dummy.prev;
                removeNode(node);
                map.remove(node.key);
            }
            Node node = new Node(key,value);
            putFront(node,dummy);
            map.put(key,node);
        }
    }

    public void putFront(Node node,Node dummy){
        node.next = dummy.next;
        node.prev = dummy;
        dummy.next.prev = node;  // 这行现在是安全的
        dummy.next = node;
    }

    public void removeNode (Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
