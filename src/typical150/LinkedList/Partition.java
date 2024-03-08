package typical150.LinkedList;


//分割链表
/*给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

你应当 保留 两个分区中每个节点的初始相对位置。*/
//思路:双指针,维护两个区域,
public class Partition {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode lt = new ListNode(0), p = lt;
        ListNode mt = new ListNode(0), q = mt;
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        p.next = mt.next;
        q.next = null;
        return lt.next;
    }

    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        partition(l1, 3);
    }

    public static void main(String[] args) {
        new Partition().test();
    }
}
