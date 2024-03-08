package leetcode75.ListNode;

import com.sun.xml.internal.bind.v2.util.FatalAdapter;

//2095.删除链表的中间结点
/*给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。

长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。

对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。*/
//思路:快慢指针
public class DeleteMiddle {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode hair = new ListNode(0, head), fast = head, slow = hair;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null) {
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return hair.next;
    }
}
