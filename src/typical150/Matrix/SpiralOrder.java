package typical150.Matrix;

import java.util.ArrayList;
import java.util.List;

//54.螺旋矩阵
/*给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。*/
//思路:用四个变量 abcd分别记录可取的上下左右界
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        List<Integer> re = new ArrayList<>();
        for (int count = 0; count <= m * n; ) {
            //左到右
            for (int i = left; i <= right; i++) {
                re.add(matrix[top][i]);
                count++;
            }
            top++;
            if (count == m * n) {
                break;
            }
            //上到下
            for (int i = top; i <= bottom; i++) {
                re.add(matrix[i][right]);
                count++;
            }
            right--;
            if (count == m * n) {
                break;
            }
            //右到左
            for (int i = right; i >= left; i--) {
                re.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            if (count == m * n) {
                break;
            }
            //下到上
            for (int i = bottom; i >= top; i--) {
                re.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return re;
    }
}
