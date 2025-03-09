package Hot100第一轮复习;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LRUCache {
    Map<Integer,Node> map = new HashMap<>();//储存key和Node的映射
    int capacity;
    Node dummy = new Node(-1,-1);
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            putFront(dummy,node);
            return node.val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.keySet().contains(key)){//已经存在的直接更新
            Node node = map.get(key);
            node.val = value;
            map.put(key,node);
            //放到最前面
            removeNode(node);
            putFront(dummy,node);
        }else {
            //不存在的要插入
            Node newNode = new Node(key, value);
            if (map.size() >= capacity) {//如果超容，先删掉末尾
                map.remove(dummy.prev.key);
                removeNode(dummy.prev);
            }
            map.put(key, newNode);
            putFront(dummy, newNode);
        }
    }
    //使用双向链表的数据结构
    class Node {
        Node prev;
        Node next;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    //定义两个轮子方法，remove和putFront

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void putFront(Node dummy,Node node){
        node.prev = dummy;
        node.next = dummy.next;
        dummy.next.prev = node;
        dummy.next = node;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */