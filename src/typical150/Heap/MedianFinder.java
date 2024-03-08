package typical150.Heap;

import java.util.PriorityQueue;

//295.数据流中的中位数
/*中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。

例如 arr = [2,3,4] 的中位数是 3 。
例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
实现 MedianFinder 类:

MedianFinder() 初始化 MedianFinder 对象。

void addNum(int num) 将数据流中的整数 num 添加到数据结构中。

double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。*/
//思路 用两个根堆 大顶堆和小顶堆 小顶堆存储大于等于中位数的数 大顶堆存储小于中位数的数
//动态维持两个堆的大小差不大于1 小顶堆size>=大顶堆size
//添加元素时 和大小顶堆的peek比较 小顶堆a 大顶堆b val<=a.peek()&&a.size()>b.size()-> b.offer(val)
// val>a.peek() ->
public class MedianFinder {
    //小顶堆
    PriorityQueue<Integer> right;
    //大顶堆
    PriorityQueue<Integer> left;

    public MedianFinder() {
        right = new PriorityQueue<>();
        left = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (right.size() > left.size()) {
            if (num <= right.peek()) {
                left.offer(num);
            } else {
                left.offer(right.poll());
                right.offer(num);
            }
        } else {
            if (right.isEmpty()) {
                right.offer(num);
                return;
            }
            if (num >= left.peek()) {
                right.offer(num);
            } else {
                right.offer(left.poll());
                left.offer(num);
            }
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return ((double) left.peek() + right.peek()) / 2;
        }
        return right.peek();
    }
}
