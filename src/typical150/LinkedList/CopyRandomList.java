package typical150.LinkedList;

import java.util.HashMap;
import java.util.Map;

//138.随机链表的复制
/*给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。

构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。

例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。

返回复制链表的头节点。

用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
你的代码 只 接受原链表的头节点 head 作为传入参数。*/
//思路:先过一遍链表 存到hashMap 然后再过一遍 将random也赋上
//优化 可以过链表的时候就把random也赋上 有点难理解
public class CopyRandomList {
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
        Map<Node, Node> reflect = new HashMap<>();
        Node hair = new Node(0), p = head, q = hair;
        while (p != null) {
            q.next = new Node(p.val);
            q = q.next;
            reflect.put(p, q);
            p = p.next;
        }
        p = head;
        q = hair.next;
        while (p != null) {
            if (p.random != null) {
                q.random = reflect.get(p.random);
            }
            p = p.next;
            q = q.next;
        }
        return hair.next;
    }

    Map<Node, Node> cacheMap = new HashMap<>();

    public Node copy(Node head) {
        if (head == null) {
            return null;
        }
        if (!cacheMap.containsKey(head)) {
            Node clo = new Node(head.val);
            cacheMap.put(head, clo);
            clo.next = copy(head.next);
            clo.random = copy(head.random);
        }
        return cacheMap.get(head);
    }
}
