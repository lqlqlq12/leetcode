package typical150.Stack;

import java.util.Deque;
import java.util.LinkedList;

//逆波兰表达式求值
/*给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。

请你计算该表达式。返回一个表示表达式值的整数。

注意：

有效的算符为 '+'、'-'、'*' 和 '/' 。
每个操作数（运算对象）都可以是一个整数或者另一个表达式。
两个整数之间的除法总是 向零截断 。
表达式中不含除零运算。
输入是一个根据逆波兰表示法表示的算术表达式。
答案及所有中间计算结果可以用 32 位 整数表示*/
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(token.length()-1))) {
                int number = Integer.parseInt(token);
                stack.push(number);
            } else {
                int a = stack.pop();
                int b = stack.pop();
                switch (token.charAt(0)) {
                    case '+': {
                        stack.push(a + b);
                        break;
                    }
                    case '-': {
                        stack.push(b - a);
                        break;
                    }
                    case '*': {
                        stack.push(a * b);
                        break;
                    }
                    default: {
                        stack.push(b / a);
                    }
                }
            }
        }
        return stack.pop();
    }

    public void test() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static void main(String[] args) {
        new EvalRPN().test();
    }
}
