package leetcode75.Array_String;

//443.压缩字符串
/*给你一个字符数组 chars ，请使用下述算法压缩：

从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：

如果这一组长度为 1 ，则将字符追加到 s 中。
否则，需要向 s 追加字符，后跟这一组的长度。
压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。

请在 修改完输入数组后 ，返回该数组的新长度。

你必须设计并实现一个只使用常量额外空间的算法来解决此问题。*/
//思路:双指针 l用来填入字符 r用来遍历
//坑:没考虑出现9次以上的情况
public class Compress {
    public int compress(char[] chars) {
        int left, right, len = chars.length;
        for (left = 0, right = 0; right < len; ) {
            int t;
            for (t = right + 1; t < len; t++) {
                if (chars[t] != chars[right]) {
                    break;
                }
            }
            if (t - right == 1) {
                chars[left++] = chars[right];
            } else {
                int times = t - right, temp = times, length = 0;
                while (temp > 0) {
                    length++;
                    temp /= 10;
                }
                chars[left++] = chars[right];
                for (int i = length; i > 0; i--) {
                    chars[left + i - 1] = (char) (times % 10 + '0');
                    times /= 10;
                }
                left += length;
            }
            right = t;
        }
        return left;
    }

    public void test() {
        char[] chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int compress = compress(chars);
        for (int i = 0; i < compress; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Compress().test();
    }
}
