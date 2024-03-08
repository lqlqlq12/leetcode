package hot100;

import java.util.HashSet;
import java.util.Set;

//相交链表
/*给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
如果两个链表不存在相交节点，返回 null 。*/
//集合
//双指针
public class GetIntersectionNode {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        Set<ListNode> set=new HashSet<>();
        while(headA!=null||headB!=null){
            if(headA!=null&&set.contains(headA)){
                return headA;
            }
            if(headA!=null){
                set.add(headA);
                headA=headA.next;
            }
            if(headB!=null&&set.contains(headB)){
                return headB;
            }
            if(headB!=null){
                set.add(headB);
                headB=headB.next;
            }
        }
        return null;
    }

    public ListNode twoPoint(ListNode headA,ListNode headB){
        if(headA==null||headB==null){
            return null;
        }
        ListNode p=headA,q=headB;
        while(p!=q){
            p=p==null?headB:p.next;
            q=q==null?headA:q.next;
        }
        return p;
    }

}

