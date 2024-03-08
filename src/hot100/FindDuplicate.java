package hot100;

//寻找重复数

/*给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。

假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。

你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。*/

//二分查找 cnt[i],nums中小于等于i的个数,假设重复数target,cunt[1:target-1]<=i cnt[target:n]>i
//二进制解法,看不懂
//快慢指针，因为有重复数字,所以有环
public class FindDuplicate {
    public int binary(int[] nums) {
        int length=nums.length;
        int l=0,r=length-1;
        int re=0;
        while(l<=r){
            int cnt=0;
            int mid=(l+r)>>1;
            for(int i=0;i<length;i++){
                if(nums[i]<=nums[mid]){
                    cnt++;
                }
            }
            if(cnt<=mid){
                l=mid+1;
            }
            else{
                re=nums[mid];
                r=mid-1;
            }
        }
        return re;
    }

    public int fastAndSlowPoint(int[] nums){
        int slow=0;
        int fast=0;
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        return slow;
    }
}
