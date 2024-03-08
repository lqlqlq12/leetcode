package hot100;

//跳跃游戏II
/*给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

0 <= j <= nums[i]
i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]*/
//贪心?每次都选下一条最远的
public class Jump {

    public int jump(int[] nums){
        int count=0;
        int len=nums.length;
        if(len==1){
            return count;
        }
        for(int now=0,maxLen=nums[0];maxLen<len-1;count++){
            int t=maxLen;
            for(int j=now+1;j<=maxLen&&j<len;j++){
                if(t<j+nums[j]){
                    t=j+nums[j];
                    now=j;
                }
            }
            maxLen=t;
        }
        return count++;
    }
}
