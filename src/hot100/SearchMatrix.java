package hot100;

//搜索二维矩阵
/*给你一个满足下述两条属性的 m x n 整数矩阵：
每行中的整数从左到右按非严格递增顺序排列。
每行的第一个整数大于前一行的最后一个整数。
给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。*/
//两次二分直接搞定
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int row=-1,col=-1;
        for(int i=0,j=m-1;i<=j;){
            int mid=(i+j)>>1;
            if(matrix[mid][0]>target){
                j=mid-1;
            }
            else if(matrix[mid][0]<target){
                row=mid;
                i=mid+1;
            }
            else{
                return true;
            }
        }
        if(row==-1){
            return false;
        }
        for(int i=0,j=n-1;i<=j;){
            int mid=(i+j)>>1;
            if(matrix[row][mid]>target){
                j=mid-1;
            }
            else if(matrix[row][mid]<target){
                i=mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
