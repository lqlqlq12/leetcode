package _1_200;

//37.解数独
/*编写一个程序，通过填充空格来解决数独问题。

数独的解法需 遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
数独部分空格内已填入了数字，空白格用 '.' 表示。*/
//思路:回溯
//官解优化:用比特位的0和1代替数组 所以一个[0:9]的数组就可以用一个长度为9的数字代替了 大大减少了空间 甚至都不要int 2个字节的short就可以了
public class SolveSudoku {

    boolean[][] row;
    boolean[][] col;
    boolean[][][] block;

    public void solveSudoku(char[][] board) {
        row = new boolean[9][10];
        col = new boolean[9][10];
        block = new boolean[3][3][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int number = board[i][j] - '0';
                    row[i][number] = true;
                    col[j][number] = true;
                    block[i / 3][j / 3][number] = true;
                }
            }
        }
        backTrack(board);
    }

    public boolean backTrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        if (!row[i][k] && !col[j][k] && !block[i / 3][j / 3][k]) {
                            row[i][k] = col[j][k] = block[i / 3][j / 3][k] = true;
                            board[i][j] = (char) ('0' + k);
                            if (backTrack(board)) return true;
                            row[i][k] = col[j][k] = block[i / 3][j / 3][k] = false;
                        }
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }

    public void test() {
        solveSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
    }

    public static void main(String[] args) {
        new SolveSudoku().test();
    }

}
