package hot100;

//搜索二维矩阵II
/*编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。*/

//暴力查找 O(mn)
//每一行二分查找O(mlogn)
//Z字形查找O(m+n)
public class SearchMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = n - 1;
        for(;x<m&&y>=0;){
            if(target==matrix[x][y]){
                return true;
            }
            if(target>matrix[x][y]){
                x++;
            }
            else{
                y--;
            }
        }
        return false;
    }
}
