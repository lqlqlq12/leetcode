package typical150.LinkedList;

//25.K个一组反转链表
/*给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。*/
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0, head), p = hair;
        while (p != null) {
            ListNode t = p;
            int i;
            for (i = 0; t != null && i < k; i++) {
                t = t.next;
            }
            if (t != null) {
                p = reverseK(p, k);
            } else {
                break;
            }
        }
        return hair.next;
    }

    //head是真正头节点的前一个
    public ListNode reverseK(ListNode head, int k) {
        ListNode p = head.next.next, tail = head.next;
        ListNode t = p;
        for (int i = 1; i < k; i++) {
            t = p.next;
            p.next = head.next;
            head.next = p;
            p = t;
        }
        tail.next = t;
        return tail;
    }


    public void test() {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = null;
        reverseKGroup(p1, 2);
    }

    public static void main(String[] args) {
        new ReverseKGroup().test();
    }

}
