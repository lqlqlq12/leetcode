package hot100;

/*给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。*/
//双指针,当第一个指针走了n步,第二个指针出发,这样第一个到终点时,第二个到倒数第n个
public class RemoveNthFromEnd {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode p = head, q;
        int i;
        for (i = 0; p != null && i < n; i++, p = p.next) ;
        if(p==null&&i<n){
            return head;
        }
        q=hair;
        while(p!=null){
            p=p.next;
            q=q.next;
        }
        q.next=q.next.next;
        return hair.next;
    }

    public  void func() {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        removeNthFromEnd(l6,1);
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        removeNthFromEnd.func();
    }
}
