package typical150.LinkedList;

//19.删除链表的倒数第N个节点
/*给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点*/
//思路:双指针 第一个指针遍历n个节点后 第二个出发
// 0 1 2 3
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hair = new ListNode(0, head);
        ListNode p = hair, q = p;
        for (int i = 0; i < n; i++, p = p.next) ;
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return hair.next;
    }
}
