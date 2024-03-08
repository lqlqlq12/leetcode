package hot100;

/*给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。*/
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int up = 0, down = n - 1;
        while (up < down) {
            reverse(matrix[up], matrix[down]);
            up++;
            down--;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }

    public void reverse(int[] a1, int[] a2) {
        int len = a1.length;
        for (int i = 0; i < len; i++) {
            int temp = a1[i];
            a1[i] = a2[i];
            a2[i] = temp;
        }
    }
}
