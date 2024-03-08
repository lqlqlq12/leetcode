package hot100;

//两两交换链表中的节点
/*给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。*/
//迭代
//递归
public class SwapPairs {

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

    public ListNode swapPairs(ListNode head) {
        ListNode hair=new ListNode();
        hair.next=head;
        recursion(hair);
        return hair.next;
    }

    public void recursion(ListNode head) {
        if (head != null && head.next != null && head.next.next != null) {
            ListNode p = head.next;
            ListNode q = p.next;
            p.next=q.next;
            q.next=p;
            head.next=q;
            recursion(p);
        }
    }

    public ListNode iteration(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode p=hair,q=hair.next,r=hair.next.next;
        while(true){
            q.next=r.next;
            r.next=q;
            p.next=r;
            p=q;
            if(p.next!=null)
                q=p.next;
            else{
                break;
            }
            if(q.next!=null)
                r=q.next;
            else{
                break;
            }
        }
        return hair.next;
    }

}
