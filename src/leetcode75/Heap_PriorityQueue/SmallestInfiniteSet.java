package leetcode75.Heap_PriorityQueue;

import java.util.PriorityQueue;
import java.util.TreeSet;

//2336.无限集中的最小数字
/*现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...] 。

实现 SmallestInfiniteSet 类：

SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
int popSmallest() 移除 并返回该无限集中的最小整数。
void addBack(int num) 如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集最后。*/
//对于被移除后又放入的数字 放到最小堆中 而对于另一种本来就存在于集合中的,用一个数字num表示[num,num+1,.....]
//因为是有序集合 可以使用TreeSet
public class SmallestInfiniteSet {
    int index;
    TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        index = 1;
        set = new TreeSet<>();
    }

    public int popSmallest() {
        if (!set.isEmpty()) {
            return set.pollFirst();
        }
        return index++;
    }

    public void addBack(int num) {
        if (num < index) {
            set.add(num);
        }
    }
}
