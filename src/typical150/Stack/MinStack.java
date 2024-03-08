package typical150.Stack;

import java.util.Deque;
import java.util.LinkedList;

//155.最小栈
/*设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

实现 MinStack 类:

MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素*/
//思路:用额外的一个栈来存储当前最小值 它随元素栈同进同出
//如果要求不用额外的常数空间 则在栈中存此元素和上一个最小值的差diff 并用x表示当前最小值
//如果diff=0 那么此元素就是x 最小值还是x
//如果diff>0 那么此元素值!=最小值 该元素的值为x+diff 最小值还是x
//如果diff<0 那么此元素是最小值 该元素的值为x 并且最小值变为x-diff
public class MinStack {
    //方法一 额外空间O(n)
//    Deque<Integer> ele;
//    Deque<Integer> min;
//
//    public MinStack() {
//        ele = new LinkedList<>();
//        min = new LinkedList<>();
//        min.push(Integer.MAX_VALUE);
//    }
//
//    public void push(int val) {
//        ele.push(val);
//        if (val < min.peek()) {
//            min.push(val);
//        } else {
//            min.push(min.peek());
//        }
//    }
//
//    public void pop() {
//        ele.pop();
//        min.pop();
//    }
//
//    public int top() {
//        return ele.peek();
//    }
//
//    public int getMin() {
//        return min.peek();
//    }

    //方法二:不用额外空间
    Deque<Long> diff;
    int min;

    public MinStack() {
        diff = new LinkedList<>();
    }

    public void push(int val) {
        if (diff.isEmpty()) {
            diff.push(0L);
            min = val;
            return;
        }
        if (val == min) {
            diff.push(0L);
        } else if (val > min) {
            diff.push((long) val - min);
        } else {
            diff.push((long) val - min);
            min = val;
        }
    }

    public void pop() {
        long poll = diff.poll();
        if (poll < 0) {
            min -= poll;
        }
    }

    public int top() {
        long peek = diff.peek();
        if (peek <= 0) {
            return min;
        } else {
            return (int) (min + peek);
        }
    }

    public int getMin() {
        return min;
    }

    public void test() {

    }
}
