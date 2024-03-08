package hot100;


import java.util.ArrayList;
import java.util.List;

//螺旋矩阵
/*给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。*/
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer> re=new ArrayList<>();
        int h=0,t=m-1,l=0,r=n-1;
        int count=0,target=m*n;
        while(count<target){
            for(int i=l;i<=r;i++,count++) re.add(matrix[h][i]);
            if(count==target) break;
            h++;
            for(int i=h;i<=t;i++,count++) re.add(matrix[i][r]);
            if(count==target) break;
            r--;
            for(int i=r;i>=l;i--,count++) re.add(matrix[t][i]);
            if(count==target) break;
            t--;
            for(int i=t;i>=h;i--,count++) re.add(matrix[i][l]);
            if(count==target) break;
            l++;
        }
        return re;
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] nums=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = spiralOrder.spiralOrder(nums);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
