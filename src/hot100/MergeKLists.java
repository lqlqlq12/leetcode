package hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

//合并k个升序链表
/*给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。*/
//顺序合并,从第一个开始往下,每次合并一个链表进去 第i次合并O(i*n) 所以O(k^2n) 空间O(1)
//分支合并 类似于归并 O(kn*logk) 空间O(logk)
//类似与合并两个,每次都选最小的元素,可以用一个优先队列维护每个链表的最小值 一次插入删除O(logk) 一共O(kn*logk)
public class MergeKLists {


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


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head=new ListNode();
        ListNode p=head;
        PriorityQueue<ListNode> queue=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        int n=lists.length;
        for(int i=0;i<n;i++){
            queue.offer(lists[i]);
        }

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            p.next=node;
            p=p.next;
            if(node.next!=null){
                queue.offer(node.next);
            }
        }
        return head.next;
    }
}
