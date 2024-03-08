package typical150.LinkedList;

//148.排序链表
/*给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。*/
//你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//忘了咋做了 好像是分治 归并 分自顶向上 自顶向下
public class SortList {
    public ListNode sortList(ListNode head) {
        ListNode hair = new ListNode(0, head), p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        if (length == 0 || length == 1) {
            return head;
        }
        for (int subLength = 2; ; subLength <<= 1) {
            int tLength = 0;
            ListNode h1 = null;
            for (p = hair; p.next != null; ) {
                if (tLength == 0) {
                    h1 = p;
                } else if (tLength == subLength >> 1) {
                    p = merge(h1, h1.next, p.next, tLength);
                    tLength = 0;
                    continue;
                }
                p = p.next;
                tLength++;
            }
            if (subLength >= length) {
                break;
            }
        }
        return hair.next;
    }

    public ListNode merge(ListNode hair, ListNode h1, ListNode h2, int length) {
        ListNode t = new ListNode(), p = t;
        int l1 = 0, l2 = 0;
        while (l1 < length && l2 < length && h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                p.next = h1;
                p = p.next;
                h1 = h1.next;
                l1++;
            } else {
                p.next = h2;
                p = p.next;
                h2 = h2.next;
                l2++;
            }
        }
        while (h1 != null && l1 < length) {
            p.next = h1;
            p = p.next;
            h1 = h1.next;
            l1++;
        }
        while (h2 != null && l2 < length) {
            p.next = h2;
            p = p.next;
            h2 = h2.next;
            l2++;
        }
        p.next = h2;
        hair.next = t.next;
        return p;
    }
}
