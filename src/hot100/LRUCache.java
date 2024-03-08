package hot100;

import javax.xml.bind.ValidationEvent;
import javax.xml.soap.Node;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
*/
//LRU缓存
//使用HashMap,map的value是双向链表的一个节点,最近被访问和最近被添加的节点移动到链表头,容量不够时删除链表的最后一个节点
//使用伪头节点和伪尾节点,这样删除添加移动的时候不用考虑是否有临近节点
public class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key,int value){
            this.key=key;
            this.value=value;
            this.prev=null;
            this.next=null;
        }

    }

    Map<Integer,DLinkedNode> map;
    int capacity;
    int size;
    private DLinkedNode head;   //伪头节点
    private DLinkedNode tail;   //伪尾节点

    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
        this.size=0;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.prev=head;
    }

    //将一个节点移动到第一个
    private void moveToHead(DLinkedNode node){
        //将前后连起来
        node.prev.next=node.next;
        node.next.prev=node.prev;
        //和伪头结点的后面的节点连起来
        node.next=head.next;
        head.next.prev=node;
        //和伪头节点连起来
        head.next=node;
        node.prev=head;
    }

    //将一个新的节点添加到第一个
    private void addToHead(DLinkedNode node){
        head.next.prev=node;
        node.next=head.next;
        head.next=node;
        node.prev=head;
    }

    //将最后一个节点删除
    private void deleteTail(){
        tail.prev=tail.prev.prev;
        tail.prev.next=tail;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if(node==null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if(node!=null){
            node.value=value;
            moveToHead(node);
            return;
        }
        node=new DLinkedNode(key, value);
        map.put(key,node);
        addToHead(node);
        size++;
        if(size>capacity){
            int targetKey=tail.prev.key;
            map.remove(targetKey);
            size--;
            deleteTail();
        }
    }
}
