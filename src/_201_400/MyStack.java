package _201_400;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//225.用队列实现栈
/*请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。

实现 MyStack 类：

void push(int x) 将元素 x 压入栈顶。
int pop() 移除并返回栈顶元素。
int top() 返回栈顶元素。
boolean empty() 如果栈是空的，返回 true ；否则，返回 false */
/*进阶：你能否仅用一个队列来实现栈。*/
//仅使用两个队列
//初步思路:两个队列 一个用来放最后一个入栈的A 然后出栈后 另一个队列B将元素转移到A 只留一个在B
//如果是入栈 将A的元素加到B 然后要入栈的放到A
//说实话没啥好进阶的 就是入栈后n个元素 马上出队n-1个元素 再依次入队 这样队头就是最近的元素
//出栈还是一样 假设出栈前n个元素 出栈后出队n-2个元素 再依次入对
public class MyStack {
    Queue<Integer> a, b;

    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    public void push(int x) {
        if (!a.isEmpty()) b.offer(a.poll());
        a.offer(x);
    }

    public int pop() {
        int re = a.poll();
        if (b.size() == 1) {
            a.offer(b.poll());
            return re;
        }
        while (b.size() > 1) {
            a.offer(b.poll());
        }
        Queue<Integer> t = a;
        a = b;
        b = t;
        return re;
    }

    public int top() {
        return a.peek();
    }

    public boolean empty() {
        return a.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.empty());
    }
}
