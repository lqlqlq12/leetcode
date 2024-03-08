package _1_200;

import java.util.ArrayList;
import java.util.List;

//93.复原IP地址
/*有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。*/
//用回溯来分割
public class RestoreIpAddresses {
    List<String> re;
    StringBuilder t;
    String s;
    int len;

    public List<String> restoreIpAddresses(String s) {
        re = new ArrayList<>();
        this.s = s;
        len = s.length();
        t = new StringBuilder();
        backTrack(0, 0);
        return re;
    }

    public void backTrack(int index, int count) {
        if (index == len && count == 4) {
            re.add(t.substring(0, t.length() - 1));
            return;
        }
        if (count == 4) {
            return;
        }


        //j是子串的长度
        for (int j = 1; j <= 3 && index + j <= len; j++) {
            if (isValid(s.substring(index, index + j))) {
                t.append(s, index, index + j).append(".");
                backTrack(index + j, count + 1);
                t.delete(t.length() - j - 1, t.length());
            }
        }

    }

    //不能有前导0
    //范围是0-255
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        if (charArray[0] == '0') {
            return s.length() == 1;
        }
        for (int i = 0; i < len; i++) {
            if (charArray[i] < '0' || charArray[i] > '9') {
                return false;
            }
        }
        int number = Integer.parseInt(s);
        return number <= 255;
    }

    public void test() {
        restoreIpAddresses("25525511135");
    }

    public static void main(String[] args) {
        new RestoreIpAddresses().test();
    }
}
