package _201_400;

//307.区域和检索 -数组可修改
/*给你一个数组 nums ，请你完成两类查询。

其中一类查询要求 更新 数组 nums 下标对应的值
另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
实现 NumArray 类：

NumArray(int[] nums) 用整数数组 nums 初始化对象
void update(int index, int val) 将 nums[index] 的值 更新 为 val
int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）*/
//思路:还是用前缀和 但是多记录一个原数组 然后如果val-num[index]=diff sum[index+1:len]+=val
//超时了 不简单
//官解:
//方法一:分块 n*n=len 将nums拆分为n块 每块的大小为size 长度为n的sum sum[i]就是第i块的块内和
//构造O(n) update O(1) sumRange O(n^0.5)
//方法二:线段树 每个节点node可以保存nums[left:right]的最小、最大、总和等等信息
//此题我们用node保存总和 mid=(left+right)>>1
//node保存sum(nums[left,right] node的左节点保存sum(nums[left,mid]) 右节点保存sum(nums[mid+1,right])
//可以用二叉树 或者用数组 node的下标index 则左节点为2*index+1 右节点为2*index+2
//构造O(n) update O(logn) sumRange O(logn)
//方法三:树状数组 不懂
//接下来使用线段树 2^n-1
//2^h=n 需要节点:2^(h+1)-1=2*2^h-1=2*n-1
//h=log(n-1)+1 2^(log(n-1)+2)-1=4*(n-1)-1 =4n-5
//10 5 3 2 1
//16 8 4 2 1
public class NumArray_2 {
    int[] nums;
    int[] tree;
    int len;

    public NumArray_2(int[] nums) {
        this.nums = nums;
        len = nums.length;
        tree = new int[getLen(len) * 2 - 1];
        build(0, 0, len - 1);
    }

    public int getLen(int n) {
        if ((n & (n - 1)) == 0) return n;
        while ((n & (n - 1)) == 0) {
            n &= (n - 1);
        }
        return n << 1;
    }

    public void build(int index, int left, int right) {
        if (left == right) {
            tree[index] = nums[left];
            return;
        }
        int mid = (left + right) >> 1;
        build(2 * index + 1, left, mid);
        build(2 * index + 2, mid + 1, right);
        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        update(0, len - 1, diff, 0, index);
    }

    public void update(int left, int right, int diff, int index, int target) {
        tree[index] += diff;
        if (left == right) return;
        int mid = (left + right) >> 1;
        if (mid >= target) {
            update(left, mid, diff, 2 * index + 1, target);
        } else {
            update(mid + 1, right, diff, 2 * index + 2, target);
        }
    }

    public int sumRange(int left, int right) {
        return sumRange(0, len - 1, left, right, 0);
    }

    public int sumRange(int left, int right, int l, int r, int index) {
        if (left == l && right == r) return tree[index];
        int mid = (left + right) >> 1;
        if (mid >= r) {
            return sumRange(left, mid, l, r, 2 * index + 1);
        } else if (mid < l) {
            return sumRange(mid + 1, right, l, r, 2 * index + 2);
        } else {
            return sumRange(left, mid, l, mid, 2 * index + 1) + sumRange(mid + 1, right, mid + 1, r, 2 * index + 2);
        }
    }


    public static void main(String[] args) {
        NumArray_2 te = new NumArray_2(new int[]{1, 3, 5});
        System.out.println(te.sumRange(0, 2));
        te.update(1, 2);
        System.out.println(te.sumRange(0, 2));
    }
}
