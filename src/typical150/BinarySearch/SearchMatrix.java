package typical150.BinarySearch;

//74.搜索二维矩阵
/*给你一个满足下述两条属性的 m x n 整数矩阵：

每行中的整数从左到右按非严格递增顺序排列。
每行的第一个整数大于前一行的最后一个整数。
给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。*/
//思路 target将矩阵分成两个区间 二分的关键就是分割出两个区间 target存在的话只会存在某一行
//对于每一行 如果一行的最后一个元素比target小 则可以排除这一行
//如果某行的第一个元素大于target 则可以排除这一行
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1;
        if (matrix[top][0] > target || matrix[bottom][n - 1] < target) {
            return false;
        }
        while (top < bottom) {
            while (top < bottom && matrix[top][n - 1] < target) {
                top++;
            }
            while (top < bottom && matrix[bottom][0] > target) {
                bottom--;
            }
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (matrix[top][mid] == target) {
                return true;
            }
            if (matrix[top][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
