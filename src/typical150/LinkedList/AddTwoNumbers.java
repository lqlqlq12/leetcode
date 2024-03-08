package typical150.LinkedList;

//2.两数相加
/*给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。*/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode hair = new ListNode(), p = hair;
        int remain = 0;
        while (l1 != null && l2 != null) {
            int sum = remain + l1.val + l2.val;
            p.next = new ListNode(sum % 10);
            p = p.next;
            remain = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = remain + l1.val;
            p.next = new ListNode(sum % 10);
            p = p.next;
            remain = sum / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = remain + l2.val;
            p.next = new ListNode(sum % 10);
            p = p.next;
            remain = sum / 10;
            l2 = l2.next;
        }
        while (remain != 0) {
            p.next = new ListNode(remain % 10);
            p = p.next;
            remain /= 10;
        }
        return hair.next;
    }
}
