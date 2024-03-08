package WeekContest._377;

import typical150.DynamicPrograming.MaximalSquare;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
//100169. 移除栅栏得到的正方形田地的最大面积
/*有一个大型的 (m - 1) x (n - 1) 矩形田地，其两个对角分别是 (1, 1) 和 (m, n) ，田地内部有一些水平栅栏和垂直栅栏，分别由数组 hFences 和 vFences 给出。

水平栅栏为坐标 (hFences[i], 1) 到 (hFences[i], n)，垂直栅栏为坐标 (1, vFences[i]) 到 (m, vFences[i]) 。

返回通过 移除 一些栅栏（可能不移除）所能形成的最大面积的 正方形 田地的面积，或者如果无法形成正方形田地则返回 -1。

由于答案可能很大，所以请返回结果对 109 + 7 取余 后的值。

注意：田地外围两个水平栅栏（坐标 (1, 1) 到 (1, n) 和坐标 (m, 1) 到 (m, n) ）以及两个垂直栅栏（坐标 (1, 1) 到 (m, 1) 和坐标 (1, n) 到 (m, n) ）所包围。这些栅栏 不能 被移除*/

public class MaximizeSquareArea {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        PriorityQueue<Integer> hQueue = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> vQueue = new PriorityQueue<>((a, b) -> b - a);
        Set<Integer> hSet = new HashSet<>();
        Set<Integer> vSet = new HashSet<>();
        hSet.add(m - 1);
        vSet.add(n - 1);
        for (int i = 0; i < hFences.length; i++) {
            hSet.add(hFences[i] - 1);
            hSet.add(m - hFences[i]);
            for (int j = i + 1; j < hFences.length; j++) {
                hSet.add(Math.abs(hFences[j] - hFences[i]));
            }
        }

        for (int i = 0; i < vFences.length; i++) {
            vSet.add(vFences[i] - 1);
            vSet.add(n - vFences[i]);
            for (int j = i + 1; j < vFences.length; j++) {
                vSet.add(Math.abs(vFences[j] - vFences[i]));
            }
        }
        hQueue.addAll(hSet);
        vQueue.addAll(vSet);
        while (!hQueue.isEmpty() && !vQueue.isEmpty()) {
            int h = hQueue.peek();
            int v = vQueue.peek();
            if (h == v) {
                return (int) ((long) h * v % 1000000007);
            }
            if (h < v) {
                vQueue.poll();
            } else {
                hQueue.poll();
            }
        }
        return -1;
    }

    public void test() {
        maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2});
    }

    public static void main(String[] args) {
        new MaximizeSquareArea().test();
    }
}
