package hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

//回文链表
/*给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。*/
public class IsPalindrome {
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

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        if(head==null){
            return false;
        }
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            stack.push(slow.val);
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast.next!=null){
            stack.push(slow.val);
        }
        slow=slow.next;
        for(;slow!=null;slow=slow.next){
            if(slow.val==stack.peek()){
                stack.pop();
            }
            else{
                return false;
            }
        }
        return stack.isEmpty();
    }

}
