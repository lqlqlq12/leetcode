package leetcode75.Stack;

import java.util.Deque;
import java.util.LinkedList;

//735.小行星碰撞
/*给定一个整数数组 asteroids，表示在同一行的小行星。

对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。
每一颗小行星以相同的速度移动。

找出碰撞后剩下的所有小行星。碰撞规则：两个小行星相互碰撞，较小的小行星会爆炸。如果两颗小行星大小相同，则两颗小行星都会爆炸。
两颗移动方向相同的小行星，永远不会发生碰撞。*/
//用栈吧 和栈顶同向直接入栈 反向的行星要看会不会撞和栈顶的比较大小
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            //同向
            if (stack.isEmpty() || stack.peek() * asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                //分道扬镳
                if (stack.peek() < 0) {
                    stack.push(asteroids[i]);
                    continue;
                }
                while (!stack.isEmpty() && stack.peek() > 0 && (-asteroids[i]) > stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else {
                    if (stack.peek() == -1 * asteroids[i]) {
                        stack.pop();
                    }
                }
            }
        }
        int[] re = new int[stack.size()];
        for (int i = 0; !stack.isEmpty(); i++) {
            re[i] = stack.pollLast();
        }
        return re;
    }

    public int[] optimize(int[] asteroids) {
        int len = asteroids.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
                continue;
            }
            if (stack.peek() < 0) {
                stack.push(asteroids[i]);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < (-asteroids[i])) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroids[i]);
                continue;
            }
            if (stack.peek() == -asteroids[i]) {
                stack.pop();
            }
        }
        int[] re = new int[stack.size()];
        for (int i = 0; !stack.isEmpty(); i++) {
            re[i] = stack.pollLast();
        }
        return re;
    }

    public void test() {
        int[] ints = optimize(new int[]{5, 10, -5});
    }

    public static void main(String[] args) {
        new AsteroidCollision().test();
    }

}
