package _201_400;

//378.有序矩阵中第k小的元素
/*给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。

你必须找到一个内存复杂度优于 O(n^2) 的解决方案。*/
/*你能否用一个恒定的内存(即 O(1) 内存复杂度)来解决这个问题?
你能在 O(n) 的时间复杂度下解决这个问题吗?这个方法对于面试来说可能太超前了，但是你会发现阅读这篇文章（ this paper ）很有趣。*/
//官解 用二分 最小的时matrix[0][0] 最大的是matrix[n-1][n-1] 答案就在这个范围内 用二分来找这个值
//然后计算小于等于这个值的有多少个 快速计算的方法是 从左下角到右上角的一个锯齿 先向左 要大于了 就向上 再向左
public class KthSmallest {

    int[][] matrix;
    int n;

    public int kthSmallest(int[][] matrix, int k) {
        this.matrix = matrix;
        n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getLessThanNumber(mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int getLessThanNumber(int number) {
        int ans = 0;
        int row = n - 1, col = 0;
        while (row >= 0) {
            while (col < n && matrix[row][col] <= number) {
                ans += row + 1;
                col++;
            }
            row--;
        }
        return ans;
    }

}
