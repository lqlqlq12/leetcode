package typical150.Array_String;

//找出字符串中第一个匹配项的字符下标
/*给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
如果 needle 不是 haystack 的一部分，则返回  -1 。*/
//方法一:暴力就完了
//方法二:KMP(Knuth-Morris-Pratt)
public class StrStr {
    public int strStr(String haystack, String needle) {
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        int hayLength = haystacks.length;
        int needleLength = needles.length;
        if (hayLength < needleLength) {
            return -1;
        }
        for (int i = 0; i < hayLength; i++) {
            if (haystacks[i] == needles[0]) {
                int j;
                for (j = 0; j < needleLength && i + j < hayLength; j++) {
                    if (haystacks[i + j] != needles[j]) {
                        break;
                    }
                }
                if (j == needleLength) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int KMP(String haystack, String needle) {
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        int hayLength = haystacks.length;
        int needleLength = needles.length;
        if (hayLength < needleLength) {
            return -1;
        }
        int[] next = new int[needleLength];
        int len = 0; //上一个匹配的长度
        for (int i = 1; i < needleLength; i++) {
            while (needles[len] != needles[i]) {
                if (len == 0) {
                    next[i] = 0;
                    break;
                } else {
                    len = next[len - 1];
                }
            }
            if (needles[len] == needles[i]) {
                next[i] = ++len;
            }
        }
        int i, j;
        for (i = 0, j = 0; i < hayLength && j < needleLength; ) {
            if (haystacks[i] == needles[j]) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j - 1];
                }
            }

        }
        if (j == needleLength) {
            return i - needleLength;
        }
        return -1;
    }

    public void test(){
        String haystack="sadbutsad";
        String needle="sad";
        System.out.println(KMP(haystack,needle));
    }


    public static void main(String[] args) {
        new StrStr().test();
    }
}
