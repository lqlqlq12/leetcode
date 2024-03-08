package leetcode75.Stack;

import java.util.Deque;
import java.util.LinkedList;

//2390.从字符串中移除星号
/*给你一个包含若干星号 * 的字符串 s 。

在一步操作中，你可以：

选中 s 中的一个星号。
移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
返回移除 所有 星号之后的字符串。

注意：

生成的输入保证总是可以执行题面中描述的操作。
可以证明结果字符串是唯一的。*/
//思路:*号和左边的第一个非*号同归于尽 从后往前遍历
//用boolean数组标记是否被*号同归于尽的方法超时
//卧槽了:栈!
//进一步优化:用一个字符数组来模拟栈的操作
public class RemoveStars {
    public String removeStars(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        boolean[] removed = new boolean[len];
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            if (charArray[i] == '*') {
                for (int j = i - 1; j >= 0; j--) {
                    if (charArray[j] != '*' && !removed[j]) {
                        removed[j] = true;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (charArray[i] != '*' && !removed[i]) {
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }

    public String optimize(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        Deque<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (charArray[i] != '*') {
                stack.offer(charArray[i]);
            } else {
                stack.pollLast();
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.poll());
        }
        return sb.toString();
    }

    public String optimizeII(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length, top = 0;
        char[] stack = new char[len];
        for (int i = 0; i < len; i++) {
            if (charArray[i] != '*') {
                stack[top++] = charArray[i];
            } else {
                top--;
            }
        }
        return new String(stack, 0, top);
    }
}
