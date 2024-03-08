package hot100;

/*将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。*/
public class MergeTwoLists {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p = list1, q = list2;
        ListNode hair = new ListNode();
        ListNode head = hair;
        while (p != null && q != null) {
            if (p.val < q.val) {
                head.next = p;
                p = p.next;
            } else {
                head.next = q;
                q = q.next;
            }
            head = head.next;
        }
        if(p!=null){
          head.next=p;
        }
        if(q!=null){
            head.next=q;
        }
        return hair.next;
    }
}
