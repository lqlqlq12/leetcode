package hot100;

//两数相加
/*给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。*/
//直接模拟手算过程
public class AddTwoNumbers {

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

    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode hair=new ListNode(0);
        ListNode head=hair;
        int carry=0;
        while(l1!=null||l2!=null){
            int x=l1!=null?l1.val:0;
            int y=l2!=null?l2.val:0;
            int sum=x+y+carry;
            head.next=new ListNode(sum%10);
            head=head.next;
            carry=sum/10;
            l1=l1!=null?l1.next:null;
            l2=l2!=null?l2.next:null;
        }
        while (carry!=0){
            head.next=new ListNode(carry%10);
            head=head.next;
            carry/=10;
        }
        return hair.next;
    }

}
