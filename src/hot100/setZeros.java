package hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//矩阵置零
/*给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法*/
public class setZeros {
    public void setZeroes(int[][] matrix) {
        int row_length=matrix.length;
        int col_length=matrix[0].length;
        Set<Integer> rows=new HashSet<>();
        Set<Integer> cols=new HashSet<>();
        for(int i=0;i<row_length;i++){
            for(int j=0;j<col_length;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        Iterator<Integer> iterator_row = rows.iterator();
        Iterator<Integer> iterator_col = cols.iterator();
        while(iterator_row.hasNext()){
            int row=iterator_row.next();
            for(int i=0;i<col_length;i++){
                matrix[row][i]=0;
            }
        }
        while(iterator_col.hasNext()){
            int col=iterator_col.next();
            for(int i=0;i<row_length;i++){
                matrix[i][col]=0;
            }
        }
    }
}
