package hot100;

import java.util.Arrays;
import java.util.HashMap;

//两数之和
public class Two_number_sum {
    public static void main(String[] args) {
        int[] nums=new int[]{2,7,11,15};
        int target=9;
        int[] re = twoSum(nums, target);
        System.out.println(Arrays.toString(re));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] re=new int[2];
        int length=nums.length;
        Integer value=0;
        for (int i = 0; i < length; i++) {
            //不使用containsKey()好像更快一点
            value=map.get(target-nums[i]);
            if(value==null){
                map.put(nums[i],i);
            }
            else{
                re[0]=i;
                re[1]=value;
                //结束循环
                break;
            }
        }
        return re;
    }


}
