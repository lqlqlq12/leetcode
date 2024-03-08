package _1_200;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//85.最大矩形
/*给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。*/
//思路:之前用动规解决过正方形的 dp[i][j]表示以i,j为右下角的正方形的最大面积的长和宽
//好吧 错了,因为单纯记录长和高不太行 比如3X1 和1X3无法同时考虑
//官解 首先记录每个点往左连续最多能有多少个1 O(m*m*n)
//然后用单调栈优化 可以优化成O(mn) 空间复杂度O(mn)空间换时间 单调栈从上往下递增 复习了一下 好难啊woc
//终于做出来了 巨难
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, re = 0;
        int[][] left = new int[m][n];
        for (int j = 0; j < n; j++) {
            Deque<Integer> stack = new LinkedList<>();
            int[] top = new int[m], bottom = new int[m];
            Arrays.fill(bottom, m);
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == '1') {
                    if (j == 0) left[i][j] = 1;
                    else left[i][j] = left[i][j - 1] + 1;
                }
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    bottom[stack.peek()] = i;
                    stack.pop();
                }
                if (stack.isEmpty()) top[i] = -1;
                else {
                    top[i] = stack.peek();
                }
                stack.push(i);

            }
            for (int i = 0; i < m; i++) {
                re = Math.max(re, left[i][j] * (bottom[i] - top[i] - 1));
            }
        }
        return re;
    }

    public void test() {
        maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
    }

    public static void main(String[] args) {
        new MaximalRectangle().test();
    }
}
