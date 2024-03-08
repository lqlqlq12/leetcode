package hot100;

import java.util.HashMap;

//随机链表的复制
/*给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，
并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 */
//回溯+HashMap
//在每一个原节点的后面接上它的复制,两次遍历,比上面的方法少了O(n)的哈希表
public class CopyRandomList {
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node p = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (p != null) {
            Node node = new Node(p.val);
            map.put(p,node);
            p=p.next;
        }
        p=head;
        while(p!=null){
            Node node = map.get(p);
            node.next=map.get(p.next);
            node.random=map.get(p.random);
            p=p.next;
        }
        return map.get(head);
    }
}
