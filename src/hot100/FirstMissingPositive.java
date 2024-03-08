package hot100;

import com.sun.jndi.cosnaming.CNCtx;

//缺失的第一个正数
/*给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案*/
//方法一:哈希表 将给的数组作为一个哈希,先将<=0的数变为N+1,如果nums[i]=x 则nums[x-1]=-nums[x-1](打上标记){x<=N}
//方法二:置换 将数组变为nums[i]=i+1的形式 将数字交换到正确的位置
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            int t = Math.abs(nums[i]);
            if (t <= len && nums[t - 1] > 0) {
                nums[t - 1] = -nums[t - 1];
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public int swap(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (;nums[i]>=1&&nums[i]<=len&&nums[nums[i]-1]!=nums[i];) {
                int t=nums[i];
                nums[i]=nums[t-1];
                nums[t-1]=t;
            }

        }
        for(int i=0;i<len;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return len+1;
    }
}
