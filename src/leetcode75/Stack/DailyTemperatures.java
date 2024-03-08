package leetcode75.Stack;

import java.util.Deque;
import java.util.LinkedList;

//739.每日温度
/*给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
x其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替*/
//官解:单调栈
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] re = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            int diff = 1;
            while (i + diff < len && temperatures[i] >= temperatures[i + diff] && re[i + diff] != 0) {
                diff += re[i + diff];
            }
            if (i + diff < len && temperatures[i] < temperatures[i + diff]) {
                re[i] = diff;
            } else {
                re[i] = 0;
            }
        }
        return re;
    }

    public int[] optimize(int[] temperatures) {
        int len = temperatures.length;
        int[] re = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {
                re[i] = 1;
            } else {
                int j = i + 1;
                while (re[j] > 0 && temperatures[i] >= temperatures[j]) {
                    j += re[j];
                }
                if (temperatures[i] < temperatures[j]) {
                    re[i] = j - i;
                }
            }
        }
        return re;
    }

    //栈内元素递减
    public int[] official(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.poll();
            }
            if (stack.isEmpty()) {
                answer[i] = 0;
            } else {
                answer[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return answer;
    }

    public void test() {
        official(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70});
    }

    public static void main(String[] args) {
        new DailyTemperatures().test();
    }
}
