package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//三数之和
/*给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。*/
public class TreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> re=new ArrayList<>();
        int len=nums.length;
        for(int i=0;i<len-2;i++){
            if(i==0||nums[i]!=nums[i-1]){
                if(nums[i]>0){
                    break;
                }
                int k=nums.length-1;
                for(int j=i+1;j<k;j++){
                    if(j==i+1||nums[j]!=nums[j-1]){
                        while(nums[i]+nums[j]+nums[k]>0&&j<k){
                            k--;
                        }
                        if(j==k){
                            break;
                        }
                        if(nums[i]+nums[j]+nums[k]==0){
                            re.add(Arrays.asList(nums[i],nums[j],nums[k--]));
                            k--;
                        }
                    }
                }
            }

        }
        return re;
    }
}
