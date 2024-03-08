package typical150.Stack;

import java.util.Deque;
import java.util.LinkedList;

//224.基本计算器
/*给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。*/
//只有+和-
//两种方法:1.转成中缀表达式 2.用一个栈来维护当前数字应该是正好还是符号
public class Calculate {
    public int calculate(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int i = 0, re = 0, sign = 1;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(sign);
        while (i < len) {
            switch (charArray[i]) {
                case '+': {
                    sign = stack.peek();
                    break;
                }
                case '-': {
                    sign = -stack.peek();
                    break;
                }
                case '(': {
                    stack.push(sign);
                    break;
                }
                case ')': {
                    stack.pop();
                    break;
                }
                case ' ': {
                    break;
                }
                default: {
                    long num = 0;
                    while (i < len && Character.isDigit(charArray[i])) {
                        num = num * 10 + charArray[i] - '0';
                        i++;
                    }
                    re += (sign * num);
                    continue;
                }
            }
            i++;
        }
        return re;
    }
}
