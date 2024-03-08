package _1_200;

//143.重排链表
/*给定一个单链表 L 的头节点 head ，单链表 L 表示为：

L0 → L1 → … → Ln - 1 → Ln
请将其重新排列后变为：

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。*/
//思路:首先用快慢指针定位到链表中间 然后中间后的结点先倒序再依次插入
//要定位到中间偏右 nice一遍过
public class ReOrderList {
    public void reOrderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null) {
            slow = slow.next;
        }
        ListNode p = slow.next, pre = null;
        slow.next = null;
        while (p != null) {
            ListNode t = p.next;
            p.next = pre;
            pre = p;
            p = t;
        }
        slow = head;
        while (pre != null) {
            ListNode t = pre.next;
            pre.next = slow.next;
            slow.next = pre;
            slow = slow.next.next;
            pre = t;
        }
    }
}
