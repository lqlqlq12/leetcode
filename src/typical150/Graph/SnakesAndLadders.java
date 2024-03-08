package typical150.Graph;

import java.util.LinkedList;
import java.util.Queue;

//蛇梯棋
/*给你一个大小为 n x n 的整数矩阵 board ，方格按从 1 到 n2 编号，编号遵循 转行交替方式 ，从左下角开始 （即，从 board[n - 1][0] 开始）每一行交替方向。

玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。

每一回合，玩家需要从当前方格 curr 开始出发，按下述要求前进：

选定目标方格 next ，目标方格的编号符合范围 [curr + 1, min(curr + 6, n2)] 。
该选择模拟了掷 六面体骰子 的情景，无论棋盘大小如何，玩家最多只能有 6 个目的地。
传送玩家：如果目标方格 next 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 next 。
当玩家到达编号 n2 的方格时，游戏结束。
r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。编号为 1 和 n2 的方格上没有蛇或梯子。

注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，玩家也 不能 继续移动。

举个例子，假设棋盘是 [[-1,4],[-1,3]] ，第一次移动，玩家的目标方格是 2 。那么这个玩家将会顺着梯子到达方格 3 ，但 不能 顺着方格 3 上的梯子前往方格 4 。
返回达到编号为 n2 的方格所需的最少移动次数，如果不可能，则返回 -1。*/
//思路 bfs
public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.offer(1);
        visited[1] = true;
        int re = 0;
        while (!queue.isEmpty()) {
            re++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int point = queue.poll();
                for (int j = point + 1; j <= point + 6; j++) {
                    if (j == n * n) {
                        return re;
                    }
                    int[] pos = getPosition(n, j);
                    int x = pos[0], y = pos[1];
                    if(board[x][y]==n*n){
                        return re;
                    }
                    if(board[x][y]!=-1){
                        if(!visited[board[x][y]]){
                            visited[board[x][y]]=true;
                            queue.offer(board[x][y]);
                        }
                    }
                    else{
                        if(!visited[j]){
                            visited[j]=true;
                            queue.offer(j);
                        }
                    }
                }

            }
        }
        return -1;
    }

    public int[] getPosition(int n, int point) {
        int x = (n - 1) - (point - 1) / n;
        int y;
        //从左到右
        if ((n - x) % 2 != 0) {
            y = (point - 1) % n;
        } else {
            y = n - 1 - (point - 1) % n;
        }
        return new int[]{x, y};
    }

    public void test() {
//        int[][] board = new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
//        int[][] board = new int[][]{{-1, -1, -1}, {-1, 9, 8}, {-1, 8, 9}};
        int[][] board = new int[][]{{-1, 7, -1}, {-1, 6, 9}, {-1, -1, 2}};
        System.out.println(snakesAndLadders(board));
    }

    public static void main(String[] args) {
        new SnakesAndLadders().test();
    }
}
