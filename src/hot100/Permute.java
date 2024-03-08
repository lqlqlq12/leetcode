package hot100;

import java.util.ArrayList;
import java.util.List;

//全排列
/*给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。*/
//一眼回溯
public class Permute {

    List<List<Integer>> re;
    List<Integer> t;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        re=new ArrayList<>();
        t=new ArrayList<>();
        this.nums=nums;
        recursion(new boolean[nums.length]);
        return re;
    }

    public void recursion(boolean[] used){
        if(t.size()==nums.length){
            re.add(new ArrayList<>(t));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                used[i]=true;
                t.add(nums[i]);
                recursion(used);
                used[i]=false;
                t.remove(t.size()-1);
            }
        }
    }
}
