package _201_400;

import java.util.Deque;
import java.util.LinkedList;

//227.基本计算器II
/*给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

整数除法仅保留整数部分。

你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。

注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。*/
/*s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开*/
//没有括号更好做了
public class Calculate {
    public int calculate(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length, num = 0;
        char preSigh = '+';
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(charArray[i])) {
                num = num * 10 + charArray[i] - '0';
            }
            if ((!Character.isDigit(charArray[i])) && charArray[i] != ' ' || i == len - 1) {
                switch (preSigh) {
                    case '+': {
                        stack.push(num);
                        break;
                    }
                    case '-': {
                        stack.push(-num);
                        break;
                    }
                    case '*': {
                        stack.push(stack.pop() * num);
                        break;
                    }
                    case '/': {
                        stack.push(stack.pop() / num);
                    }
                }
                preSigh = charArray[i];
                num = 0;
            }
        }
        int re = 0;
        while (!stack.isEmpty()) {
            re += stack.pop();
        }
        return re;
    }

    public void test() {
        calculate("3+2*2");
    }

    public static void main(String[] args) {
        new Calculate().test();
    }
}
