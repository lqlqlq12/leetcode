package typical150.Array_String;

import java.util.HashMap;
import java.util.Map;

//罗马数字转整数
/*罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。

 */
//巧解:把小值放在大值左边就做减法， 否则做加法
//进一步优化:小数据量体现不出HashMap的优势,反而用switch case更快
public class RomanToInt {
    public int romanToInt(String s) {
        int re = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int len = s.length();
        for (int i = len - 1; i >= 0; ) {
            if (i >= 1 && map.containsKey(s.substring(i - 1, i + 1))) {
                re += map.get(s.substring(i - 1, i + 1));
                i -= 2;
            } else {
                re += map.get(s.substring(i, i + 1));
                i--;
            }
        }
        return re;
    }

    public int method_2(String s) {
        int re = 0;
        int len = s.length();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            switch (s.charAt(i)) {
                case 'I':
                    arr[i] = 1;
                    break;
                case 'V':
                    arr[i] = 5;
                    break;
                case 'X':
                    arr[i] = 10;
                    break;
                case 'L':
                    arr[i] = 50;
                    break;
                case 'C':
                    arr[i] = 100;
                    break;
                case 'D':
                    arr[i] = 500;
                    break;
                case 'M':
                    arr[i] = 1000;
            }
            if (i > 0) {
                if (arr[i] <= arr[i - 1]) {
                    re += arr[i];
                } else {
                    re += (arr[i] - arr[i - 1] - arr[i - 1]);
                }
            } else {
                re += arr[i];
            }
        }
        return re;
    }
}
