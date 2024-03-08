package hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//除自身以外数组的乘积
/*给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。

题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

请 不要使用除法，且在 O(n) 时间复杂度内完成此题。*/
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length=nums.length;
        int[] answer=new int[length];
        answer[0]=1;
        for(int i=1;i<length;i++){
            answer[i]=answer[i-1]*nums[i-1];
        }
        int right=1;
        for(int i=length-1;i>=0;i--){
            answer[i]=answer[i]*right;
            right*=nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        Collections.sort(list,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return o2.compareTo(o1);
            }
        });
    }
}
