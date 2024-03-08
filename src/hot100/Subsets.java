package hot100;

import java.util.ArrayList;
import java.util.List;

//子集
/*给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。*/
//一眼回溯,递归,迭代
public class Subsets {

    List<List<Integer>> re=new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        re=new ArrayList<>();
        this.nums=nums;
        for(int i=0;i<=nums.length;i++){
            recursion(new ArrayList<>(),i,0);
        }
        return re;
    }

    public void recursion(List<Integer> list,int target,int index){
        if(list.size()==target){
            re.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            recursion(list,target,i+1);
            list.remove(list.size()-1);
        }
    }

}
