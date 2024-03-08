package hot100;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。*/
/*你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小*/
//前K个高频元素
//用容量k的最小堆,排序的复杂度O(nlogk) 空间O(n)
//桶排序,数量为n+1,时间复杂度O(n) 空间复杂度O(n)
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        int[] re=new int[k];
        HashMap<Integer,Integer>map=new HashMap<>();
        int length=nums.length;
        for (int num : nums) {
            if(!map.containsKey(num)){
                map.put(num,1);
            }
            else{
                map.put(num,map.get(num)+1);
            }
        }

        List<Integer>[] ans=new List[length+1];

        for (Integer key : map.keySet()) {
            int times=map.get(key);
            if(ans[times]==null){
                ans[times]=new ArrayList<>();
            }
            ans[times].add(key);
        }

        for(int i=ans.length-1,j=0;i>0;i--){
            if(ans[i]!=null){
                for(int m=0;m<ans[i].size();m++){
                    if(j<k){
                        re[j++]=ans[i].get(m);
                    }
                    else{
                        return re;
                    }
                }
            }
        }
        return re;
    }
}
