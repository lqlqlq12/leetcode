package typical150.Math;

import java.util.ArrayList;
import java.util.List;

//9.回文数
/*给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

例如，121 是回文，而 123 不是。*/
//进阶：你能不将整数转为字符串来解决这个问题吗？
//思路 将每一位都求出来放到list里 然后list双指针遍历 O(n)
//官解:反转一半 整个反转可能会溢出 O(logn)
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            list.add(x % 10);
            x /= 10;
        }
        for (int left = 0, right = list.size() - 1; left < right; left++, right--) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
        }
        return true;
    }

    //1221 12 21   12321  half:123 x:12
    public boolean optimize(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int half = 0;
        while (half < x) {
            half = half * 10 + x % 10;
            x /= 10;
        }
        return half == x || half / 10 == x;
    }
}
