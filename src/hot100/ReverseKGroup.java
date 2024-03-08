package hot100;

//K 个一组翻转链表
/*给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。*/
/*你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？*/
public class ReverseKGroup {

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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode();
        ListNode t = hair;
        hair.next = head;
        while (t != null) {
            head = t;
            for (int i = 0; i < k; i++) {
                t = t.next;
                if (t == null) {
                    return hair.next;
                }
            }
            t=reverse(head, k, t.next);
        }
        return hair.next;
    }

    //头插法
    public ListNode reverse(ListNode head, int k, ListNode tail) {
        ListNode p=head.next.next;
        head.next.next=tail;
        ListNode re=head.next;
        for(int i=1;i<k;i++){
            ListNode t=p.next;
            p.next=head.next;
            head.next=p;
            p=t;
        }
        return re;
    }
}
