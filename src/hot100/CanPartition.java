package hot100;

//分割等和子集
/*给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。*/
//动态规划
public class CanPartition {

    public static void main(String[] args) {
        int[] nums=new int[]{2,2,3,5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int length=nums.length;
        int maxNum=Integer.MIN_VALUE;
        int target=0;
        if(length<2){
            return false;
        }
        for(int i=0;i<length;i++){
            maxNum=Math.max(maxNum,nums[i]);
            target+=nums[i];
        }
        if(target%2!=0){
            return false;
        }
        target/=2;
        if(maxNum>target){
            return false;
        }
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for(int i=1;i<=length;i++){
            //从大到小计算
            for(int j=target;j>=0;j--){
                if(j>=nums[i-1]&&dp[j-nums[i-1]]){
                    dp[j]=true;
                }
            }
        }
        return dp[target];
    }
}
