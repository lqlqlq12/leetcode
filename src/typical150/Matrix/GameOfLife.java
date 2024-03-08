package typical150.Matrix;

//生命游戏
/*根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。

给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。
每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。*/

/*你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？*/
//直接复制一个数组的空间复杂度很高 可以自定义规则,或者观察到只要0,1表示状态只要一位,而int有32位
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[] neighbors = {-1, 0, 1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] % 10 == 0) {
                    continue;
                }
                for (int s = 0; s < 3; s++) {
                    if(i + neighbors[s] < 0 || i + neighbors[s] >= m){
                        continue;
                    }
                    for (int t = 0; t < 3; t++) {
                        if(j + neighbors[t] < 0 || j + neighbors[t] >= n){
                            continue;
                        }
                        if (s == 1 && t == 1) {
                            continue;
                        }
                        board[i + neighbors[s]][j + neighbors[t]] += 10;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] % 10 == 1 && (board[i][j] / 10 < 2 || board[i][j] / 10 > 3)) {
                    board[i][j] = 0;
                } else if (board[i][j] % 10 == 0 && board[i][j] / 10 == 3) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = board[i][j] % 10;
                }
            }
        }
    }

    public void test() {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
    }

    public static void main(String[] args) {
        new GameOfLife().test();
    }

}
