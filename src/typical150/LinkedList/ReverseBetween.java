package typical150.LinkedList;

//反转链表II
/*给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。*/
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair = new ListNode(0, head), p = hair;
        int count = 1;
        while (count < left) {
            p = p.next;
            count++;
        }
        ListNode first = p.next;
        ListNode q = first.next;
        for (int i = left + 1; i <= right; i++) {
            ListNode t = q.next;
            q.next = p.next;
            p.next = q;
            q = t;
        }
        first.next = q;
        return hair.next;
    }

}
