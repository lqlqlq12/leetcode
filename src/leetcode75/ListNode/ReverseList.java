package leetcode75.ListNode;

//206.反转链表
/*给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。*/
//思路:遍历使用头插法
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode hair = new ListNode(0, head), p = hair;
        while (p != null) {
            ListNode t = p.next;
            p.next = hair.next;
            hair.next = p;
            p = t;
        }
        head.next = null;
        return hair.next;
    }
}
