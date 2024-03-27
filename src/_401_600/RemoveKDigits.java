package _401_600;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

//402.移掉K位数字
/*给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。

请你以字符串形式返回这个最小的数字。*/
//先考虑如何去掉一个数字 使得结果尽可能小 从左往右遍历 如果左边的数字大于右边的数字
//去掉左边的数字 可以使结果最小 右边的数字为0且0是第二位 不可以移除第一位
//使用栈
public class RemoveKDigits {
    public String removeKDigits(String num, int k) {
        char[] charArray = num.toCharArray();
        int len = charArray.length, index = 1;
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        stack.push(charArray[0]);
        while (index < len && k > 0) {
            if (stack.isEmpty() || stack.peek() <= charArray[index]) {
                stack.push(charArray[index]);
                index++;
            } else if (stack.peek() > charArray[index]) {
                stack.pop();
                k--;
            }
        }
        while (!stack.isEmpty()) {
            if (k > 0) {
                stack.pop();
                k--;
            } else {
                sb.append(stack.pop());
            }
        }
        sb.reverse().append(num.substring(index));
        if (sb.length() == 0) return "0";
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                return sb.substring(i);
            }
        }
        return "0";
    }


    @Test
    public void test() {
        removeKDigits("1432219", 3);
    }
}
