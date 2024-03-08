package leetcode75.Stack;

import java.util.Deque;
import java.util.LinkedList;

//901.股票价格跨度
/*设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。

当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。

例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。

实现 StockSpanner 类：

StockSpanner() 初始化类对象。
int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。*/
// 思路:price[i]<price[i-1] 那么next[i]=1
// 如果:price[i]>=price[i-1]则要直到前面连续有多少个比他小的
// 用一个栈来保存 栈内元素递减的 且元素尽量大
// 100 push() {100:1}
// 80<stack.peek() push() {81:1}
// 60同理 push() {60:1} stack{100,80,60}
// 70 while(70>stack.peek()) {stack.pop(),next+=弹出元素的跨度} {70:2} stack{100,80,70}
// 60<stack.peek() {60:1} stack{100,80,70,60}
// 75 while(75>stack.peek()) stack.pop() {75:4} stack{100,80,75}
// 85 while(85>stack.peek()) stack.pop() {85:6} stack{100,85}
// 解释 栈内元素递减 并且记录了每个元素对应的跨度 如果ele>peek()则跨度加上去 直到ele<peek() 说明不能延续下去了
// 用两个栈 一个保存递减的元素 另一个同push同pop保存跨度

// 自己想出来的 我最牛
public class StockSpanner {
    Deque<Integer> eleStack;
    Deque<Integer> nextVal;

    public StockSpanner() {
        eleStack = new LinkedList<>();
        nextVal = new LinkedList<>();
    }

    public int next(int price) {
        int val = 1;
        while (!eleStack.isEmpty() && price >= eleStack.peek()) {
            eleStack.pop();
            val += nextVal.pop();
        }
        eleStack.push(price);
        nextVal.push(val);
        return val;
    }
}
