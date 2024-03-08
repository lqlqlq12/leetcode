package typical150.Heap;

import java.util.PriorityQueue;

//215.数组中的第k个最大元素
/*给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。*/
//思路 忘了O(n)怎么搞了 但是可以用容量为k的小顶堆  这样是O(nlogn)
//官解 快速选择 快速排序:每次选一个元素 使其左边都小于它 右边都大于等于它 如果排序完这个元素刚好是第k个就可以了
//然后如果 下标>k 说明只要递归左区间了 否则右区间 这样就有O(n)
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int i;
        for (i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        for (; i < len; i++) {
            if (queue.peek() < nums[i]) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }

    public int optimize(int[] nums, int k) {
        int len = nums.length;
        return quick_select(nums, 0, len - 1, k);
    }

    //在nums[left:right]中找到第k大的元素
    public int quick_select(int[] nums, int left, int right, int k) {
        //用双指针进行排序
        int l = left, r = right;
        int number = nums[left];
        //使[left:l-1]<number [r+1:right]>number [l:r]=number
        for (int i = l; i < r; ) {
            if (nums[i] < number) {
                int t = nums[l];
                nums[l] = nums[i];
                nums[i] = t;
                l++;
                i++;
            } else if (nums[i] > number) {
                int t = nums[r];
                nums[r] = nums[i];
                nums[i] = t;
                r--;
            } else {
                i++;
            }
        }
        if (right - r + 1 <= k && right - l + 1 >= k) {
            return nums[l];
        }
        if (right - r + 1 > k) {
            return quick_select(nums, r + 1, right, k);
        } else {
            return quick_select(nums, left, r - 1, k - (right - r + 1));
        }
    }

    public void test() {
        optimize(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }

    public static void main(String[] args) {
        new FindKthLargest().test();
    }
}
