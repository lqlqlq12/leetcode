package typical150.Matrix;

//48.旋转图像
/*给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。*/
//思路 先将矩阵上下交换 再沿y=-x对称
public class Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int top = 0, bottom = n - 1;
        while (top < bottom) {
            for (int i = 0; i < n; i++) {
                int t = matrix[top][i];
                matrix[top][i] = matrix[bottom][i];
                matrix[bottom][i] = t;
            }
            top++;
            bottom--;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
}