package _201_400;

//203.移除链表元素
/*给你一个链表的头节点 head 和一个整数 val ，

请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。*/
//水题
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode hair = new ListNode(0, head), p = hair;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return hair.next;
    }
}
