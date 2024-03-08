package hot100;


import com.sun.scenario.effect.Merge;

//排序链表
/*给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表*/
/*在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序*/
//归并、堆排序、快速排序
//自底向上的归并
public class SortList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        int length = 0;
        ListNode p = head;
        ListNode hair = new ListNode();
        hair.next = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        if (length == 0 || length == 1) {
            return head;
        }
        for (int subLength = 2; ; subLength <<= 1) {
            int tLength = 0;
            p = hair.next;
            ListNode h1 = null, h2, tHair = hair;
            for (; p != null; ) {
                if (tLength == 0) {
                    h1 = p;
                } else if (tLength == subLength >> 1) {
                    h2 = p;
                    tHair = merge(tHair, h1, h2, tLength);
                    tLength = 0;
                    p = tHair.next;
                    continue;
                }
                p = p.next;
                tLength++;
            }
            if (subLength >= length)
                break;
        }
        return hair.next;
    }

    public ListNode merge(ListNode hair, ListNode h1, ListNode h2, int length) {
        int i = 0, j = 0;
        ListNode re = new ListNode();
        ListNode head = re;
        ListNode tail = null;
        while (h1 != null && h2 != null && i < length && j < length) {
            if (h1.val < h2.val) {
                re.next = h1;
                h1 = h1.next;
                i++;
            } else {
                re.next = h2;
                h2 = h2.next;
                j++;
                if (j == length) {
                    tail = h2;
                }
            }
            re = re.next;
        }
        while (h1 != null && i < length) {
            re.next = h1;
            h1 = h1.next;
            re = re.next;
            i++;
        }
        while (h2 != null && j < length) {
            re.next = h2;
            h2 = h2.next;
            re = re.next;
            j++;
            if (j == length) {
                tail = h2;
            }
        }
        re.next = tail;
        hair.next = head.next;
        return re;
    }

    public void test() {
        ListNode hair = new ListNode();
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        hair.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode listNode = sortList(n1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public void test_1() {
        ListNode hair = new ListNode();
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        hair.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode p = hair.next;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
        merge(hair, n1, n3, 2);
        p = hair.next;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        SortList sortList = new SortList();
        sortList.test();
    }
}
