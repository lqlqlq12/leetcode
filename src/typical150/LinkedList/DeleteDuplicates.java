package typical150.LinkedList;

//删除排序链表中的重复元素II
/*给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。*/
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode hair = new ListNode(0, head);
        ListNode p = hair;
        while (p.next != null && p.next.next != null) {
            //要删除一系列节点
            if (p.next.val == p.next.next.val) {
                int t = p.next.val;
                ListNode q = p.next;
                while (q != null && q.val == t) {
                    q = q.next;
                }
                p.next = q;
            } else {
                p = p.next;
            }
        }
        return hair.next;
    }
}
