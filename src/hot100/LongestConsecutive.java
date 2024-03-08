package hot100;

import java.util.HashSet;
import java.util.Set;

//最长连续序列
/*给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。*/
//HasSet 针对x,确认x+1,x+2....x+y是否存在,对于x,如果存在x-1,则不从x遍历,因为会从x-1或更小遍历,会被覆盖
//优化一:当判断序列x,x+1,x+2...时,对于已经判断完的数字,可以将其从HashSet中移除
public class LongestConsecutive {

    public int longestConsecutive(int[] nums){
        Set<Integer> set=new HashSet<>();
        int len=nums.length;
        int re=0;
        for (int num : nums) {
            set.add(num);
        }
        for(int i=0;i<len;i++){
            if(set.contains(nums[i]-1)){
                continue;
            }
            int tLength=0;
            for(int t=nums[i];set.contains(t);t++){
                tLength++;
            }
            re=Math.max(re,tLength);
        }
        return re;
    }

}
