package hot100;

//颜色分类
/*给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

必须在不使用库内置的 sort 函数的情况下解决这个问题*/
/*你能想出一个仅使用常数空间的一趟扫描算法吗？*/
//单指针两次遍历 第一次遍历将0换到左边 第二次将1换到0的后面
//双指针一次遍历 0换到左指针 2换到右指针
public class SortColors {
    public void sortColors(int[] nums){

    }

    public void single(int[] nums){
        int l=0,len=nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                int t=nums[l];
                nums[l]=nums[i];
                nums[i]=t;
                l++;
            }
        }
        for(int i=l;i<len;i++){
            if(nums[i]==1){
                int t=nums[l];
                nums[l]=nums[i];
                nums[i]=t;
                l++;
            }
        }
    }

    public void tow(int[] nums){
        int len= nums.length;
        int l=0,r=len-1;
        for(int i=0;i<len;){
            if (nums[i] == 0){
                int t=nums[l];
                nums[l]=nums[i];
                nums[i]=t;
                l++;
            }
            else if(nums[i]==2){
                int t=nums[r];
                nums[r]=nums[i];
                nums[i]=t;
                r--;
            }
            else{
                i++;
            }
        }
    }
}
