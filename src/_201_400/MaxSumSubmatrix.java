package _201_400;

import java.util.TreeSet;

//363.矩形区域不超过K的最大数值和
/*给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。

题目数据保证总会存在一个数值和不超过 k 的矩形区域。*/
//我超巨难
//官解:原本递归上下左右边界 需要O(n^4)
//就想办法降低这个复杂度 首先还是遍历上下边界 然后再左右边界 通过计算前缀和 然后前缀和求差
//用一个有序集合记录前面的前缀和 找到比当前前缀和小sum[i]-k的最大的一个前缀和 ceil方法
public class MaxSumSubmatrix {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, re = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {
                for (int s = 0; s < n; s++) {
                    sum[s] += matrix[j][s];
                }
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(0);
                int total = 0;
                for (int s : sum) {
                    total += s;
                    Integer ceiling = treeSet.ceiling(total - k);
                    if (ceiling != null) {
                        re = Math.max(re, total - ceiling);
                    }
                    treeSet.add(total);
                }
            }
        }
        return re;
    }
}
