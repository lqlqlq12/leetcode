package typical150.Array_String;

//14.最长公共前缀
/*编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。*/
//思路:一次遍历 维护一个前缀字符串 横向遍历
//方法二:纵向遍历
//方法三:分治
//方法四:二分 有点笨 [0:minLength]里边二分筛选一半 O(mnlogm) m是最小长度  上面几个都是O(mn)
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        StringBuilder re = new StringBuilder(strs[0]);
        for (int i = 1; i < len; i++) {
            StringBuilder t = new StringBuilder();
            for (int j = 0; j < Math.min(re.length(), strs[i].length()) && strs[i].charAt(j) == re.charAt(j); j++) {
                t.append(strs[i].charAt(j));
            }
            if (t.length() == 0) {
                return "";
            }
            re.replace(0, re.length(), t.toString());
        }
        return re.toString();
    }


    public String optimize(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return strs[0];
        }
        String re = strs[0];
        for (int i = 1; i < len; i++) {
            re = getCommon(re, strs[i]);
            if (re.length() == 0) {
                return "";
            }
        }
        return re;
    }

    public String getCommon(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int index = 0;
        for (; index < len && str1.charAt(index) == str2.charAt(index); index++) ;
        return str1.substring(0, index);
    }


    public String colForeach(String[] strs) {
        int len = strs.length;
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < len; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
