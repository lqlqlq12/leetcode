package typical150.Array_String;

import java.util.HashMap;
import java.util.Map;

//整数转罗马数字
/*罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给你一个整数，将其转为罗马数字。
1 <= num <= 3999
*/
public class IntToRoman {
    //笨蛋方法
    public String intoRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
        if (map.containsKey(num)) {
            return String.valueOf(map.get(num));
        }
        int unit = 1;
        StringBuilder sb = new StringBuilder();
        for (int t = num; t > 0; t /= 10, unit *= 10) {
            int val = t % 10 * unit;
            if (map.containsKey(val)) {
                sb.insert(0, map.get(val));
                continue;
            }
            if (val > unit * 5) {
                for (int i = 0; i < val - 5 * unit; i += unit) {
                    sb.insert(0, map.get(unit));
                }
                sb.insert(0, map.get(unit * 5));
            } else {
                for (int i = 0; i < val; i += unit) {
                    sb.insert(0, map.get(unit));
                }
            }
        }
        return sb.toString();
    }

    //贪心 每次都选最大的那个数
    public String greed(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
        int[] nums = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder sb = new StringBuilder();
        //用二分找小于num的最大数
        int left, right = nums.length - 1;
        while (num > 0) {
            left = 0;
            while (left < right) {
                int mid = (left + right + 1) >> 1;
                if (nums[mid] == num) {
                    sb.append(map.get(nums[mid]));
                    return sb.toString();
                }
                if (nums[mid] > num) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            sb.append(map.get(nums[left]));
            num -= nums[left];
        }
        return sb.toString();
    }


    public String baoLi(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuilder sb = new StringBuilder();
        sb.append(thousands[num / 1000]);
        sb.append(hundreds[num % 1000 / 100]);
        sb.append(tens[num % 100 / 10]);
        sb.append(ones[num % 10]);
        return sb.toString();

    }
}
