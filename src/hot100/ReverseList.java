package hot100;


//反转链表
public class ReverseList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      public ListNode reverseList(ListNode head){
          if(head==null||head.next==null){
              return head;
          }
          ListNode hair=new ListNode();
          hair.next=head;
          ListNode p=head.next;
          head.next=null;
          while(p!=null){
              ListNode t=p.next;
              p.next=hair.next;
              hair.next=p;
              p=t;
          }
          return hair.next;
      }
}
