package hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//多数元素
/*给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。*/
//哈希表
//排序,n/2下标的就是target
//布尔摩尔投票算法
public class MajorityElement {
    public int majorityElement(int[] nums){
        HashMap<Integer,Integer> map=new HashMap<>();
        int len=nums.length/2;
        for (int num : nums) {
            int value=map.getOrDefault(num,0);
            if(value+1>len){
                return num;
            }
            map.put(num,value+1);
        }
        return -1;
    }

    public int sort(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int boyer(int[] nums){
        int count=0;
        int candidate=-1;
        for (int num : nums) {
            if(count==0){
                candidate=num;
            }
            count+=(candidate==num)?1:-1;
        }
        return candidate;
    }
}
