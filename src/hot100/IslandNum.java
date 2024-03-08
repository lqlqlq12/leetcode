package hot100;

//岛屿数量
/*给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

        此外，你可以假设该网格的四条边均被水包围。*/
public class IslandNum {


    public int numIslands(char[][] grid) {
        int row_length=grid.length;
        int col_length=grid[0].length;
        int number=0;
        for(int i=0;i<row_length;i++){
            for(int j=0;j<col_length;j++){
                if(grid[i][j]!='0'){
                    number++;
                    dfs(grid,i,j);
                }
            }
        }
        return number;
    }

    public static void dfs(char[][] grid,int x,int y){
        grid[x][y]='0';
        if(x>0&&grid[x-1][y]!='0'){
            dfs(grid,x-1,y);
        }
        if(x<grid.length-1&&grid[x+1][y]!='0'){
            dfs(grid,x+1,y);
        }
        if(y>0&&grid[x][y-1]!='0'){
            dfs(grid,x,y-1);
        }
        if(y<grid[0].length-1&&grid[x][y+1]!='0'){
            dfs(grid,x,y+1);
        }
    }

}
