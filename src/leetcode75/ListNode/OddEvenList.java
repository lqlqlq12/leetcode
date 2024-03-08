package leetcode75.ListNode;

//328.奇偶链表
/*给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。

第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。

请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。

你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。*/
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oHair = new ListNode(), eHair = new ListNode(), p = oHair, q = eHair;
        while (head != null) {
            p.next = head;
            head = head.next;
            p = p.next;
            if (head != null) {
                q.next = head;
                head = head.next;
                q = q.next;
            }
        }
        q.next = null;
        p.next = eHair.next;
        return oHair.next;
    }

    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        oddEvenList(l1);
    }

    public static void main(String[] args) {
        new OddEvenList().test();
    }
}
