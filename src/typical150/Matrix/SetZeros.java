package typical150.Matrix;

//73.矩阵置零
/*给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。*/
/*一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个仅使用常量空间的解决方案吗？*/
//O(mn)再搓一个矩阵
//O(m+n)用两个boolean数组表示某行和某列是否需要置0
//O(1)用矩阵的第一行和第一列代替上个方法说的两个数组 但需要两个变量来记录原本第一行和第一列是否需要置0
//而且要置0的话需要等其他位置先操作完
//将上面方法第一行是否需要置0的变量用第一列的第一个替代 只要1个变量了
public class SetZeros {
    public void setZeros(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean hasZero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                hasZero = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //将列置0
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        //将行置0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
            if (hasZero) {
                matrix[i][0] = 0;
            }
        }
    }
}
