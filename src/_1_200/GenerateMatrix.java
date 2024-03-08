package _1_200;

//59.螺旋矩阵II
/*给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。*/
//思路:做过很多次螺旋矩阵了 用四个变量记录上左下右的可取的位置
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] re = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int number = 1;
        while (number <= n * n) {
            for (int i = left; i <= right; i++) re[top][i] = number++;
            if (number > n * n) break;
            top++;
            for (int i = top; i <= bottom; i++) re[i][right] = number++;
            if (number > n * n) break;
            right--;
            for (int i = right; i >= left; i--) re[bottom][i] = number++;
            if (number > n * n) break;
            bottom--;
            for (int i = bottom; i >= top; i--) re[i][left] = number++;
            left++;
        }
        return re;
    }
}
