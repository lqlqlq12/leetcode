package hot100;

import java.util.*;

//柱状图中最大的矩形
/*给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。*/
//和盛水最多的容器不一样,
//暴力解 O(n^2) 枚举宽度 两重循环
//巨难woc
//单调栈
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> left = new ArrayList<>(len);
        int re = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                left.add(-1);
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left.add(-1);
                stack.push(i);
            } else {
                left.add(stack.peek());
                stack.push(i);
            }
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                re = Math.max(re, (len - left.get(i) - 1) * heights[i]);
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                re = Math.max(re, (len - left.get(i) - 1) * heights[i]);
                stack.push(i);
            } else {
                re = Math.max(re, (stack.peek() - left.get(i) - 1) * heights[i]);
                stack.push(i);
            }
        }
        return re;
    }

    //出栈的过程就可以确定右边界,可以进一步优化
    public int func(int[] heights) {
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right, len);
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        int re = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            re = Math.max((right[i] - left[i] - 1) * heights[i], re);
        }
        return re;
    }
}
