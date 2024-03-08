package hot100;


import com.sun.org.apache.xerces.internal.impl.xs.models.XSAllCM;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//最小栈
/*设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

实现 MinStack 类:

MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。*/
//使用一个辅助栈存储当前的最小值,和工作栈同时进出栈 空间复杂度为O(n)
//若想不额外使用空间,使用常数的空间,思路是用栈保存和最小值的差值
//public class MinStack {
//    Deque<Integer> stack;
//    Deque<Integer> xStack;
//
//    public MinStack() {
//        stack = new LinkedList<>();
//        xStack = new LinkedList<>();
//    }
//
//    public void push(int val) {
//        stack.push(val);
//        if (xStack.isEmpty()) {
//            xStack.push(val);
//        } else {
//            int min = xStack.peek();
//            xStack.push(Math.min(val, min));
//        }
//    }
//
//    public void pop() {
//        if (!stack.isEmpty()) {
//            stack.pop();
//            xStack.pop();
//        }
//    }
//
//    public int top() {
//        if (!stack.isEmpty())
//            return stack.peek();
//        return -1;
//    }
//
//    public int getMin() {
//        if (!xStack.isEmpty()) {
//            return xStack.peek();
//        }
//        return -1;
//    }
//}


public class MinStack {
    Deque<Long> stack;
    Integer min;

    public MinStack() {
        stack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            Long diff = (long) val - (long) min;
            stack.push(diff);
            min = Math.min(min, val);
        }
    }

    public void pop() {
        Long pop = stack.pop();
        if (pop < 0) {
            min = (int) (min - pop);
        }
    }

    public int top() {
        Long peek = stack.peek();
        if (peek <= 0) {
            return min;
        } else {
            return (int) (peek + min);
        }
    }

    public int getMin() {
        return min;
    }
}


