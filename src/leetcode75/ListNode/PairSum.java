package leetcode75.ListNode;

import java.util.Deque;
import java.util.LinkedList;

//2130.链表最大孪生和
/*在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。

比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。
孪生和 定义为一个节点和它孪生节点两者值之和。

给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。*/
//思路:其实就是头尾两两配对,感觉用栈 用快慢指针定位到一半 才击败30%呢
//好像每必要用双指针 直接用一个双端队列 然后两头pop
//官解:快慢指针遍历到一半 然后将后半部分反转 少了额外的空间
public class PairSum {
    //击败30%
    public int pairSum(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode hair = new ListNode(0, head), fast = hair, slow = fast;
        int re = 0;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            stack.push(slow.val);
        }
        while (slow.next != null) {
            slow = slow.next;
            re = Math.max(re, slow.val + stack.pop());
        }
        return re;
    }

    //更慢了呢
    public int optimize(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        int re = 0;
        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }
        while (!deque.isEmpty()) {
            re = Math.max(re, deque.pollFirst() + deque.pollLast());
        }
        return re;
    }
}
