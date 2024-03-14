package _201_400;

import hot100.PathSum;

import java.util.Random;

//382.链表随机节点
/*给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。

实现 Solution 类：

Solution(ListNode head) 使用整数数组初始化对象。
int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。*/
//思路:用一个list保存链表的节点值 然后random返回
//官解O(1):水塘抽样 遍历到第i个元素 去random[0:i) 如果等于0 就选为既定答案 否则继续
//可以证明每个节点的概率都是1/n 选第i个的概率:后面i+1都不为0 第i个为0 (1/i)*(i/i+1)*(i+1/i+2)*..*(n-1/n)
//计算结果1/n
public class GetRandom {
    Random random;
    ListNode head;

    public GetRandom(ListNode head) {
        random = new Random();
        this.head = head;
    }

    public int getRandom() {
        int re = 0;
        ListNode node = head;
        for (int i = 1; node != null; node = node.next, i++) {
            re = random.nextInt(i) == 0 ? node.val : re;
        }
        return re;
    }

}
