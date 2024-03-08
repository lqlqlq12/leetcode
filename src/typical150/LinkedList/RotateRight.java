package typical150.LinkedList;

//61.旋转链表
/*给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。*/
//思路:将倒数的k个节点整个进行头插法 12345 将45头插 使用双指针确认第k个位置
//优化 如果k大于链表的长度 则可以将k取余长度 重新开始循环
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode hair = new ListNode(0, head), p = hair, q = hair;
        for (int i = 0; i < k; i++) {
            p = p.next;
            len++;
            if (p.next == null) {
                k %= len;
                i = -1;
                p = hair;
            }
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = hair.next;
        hair.next = q.next;
        q.next = null;
        return hair.next;
    }
}
