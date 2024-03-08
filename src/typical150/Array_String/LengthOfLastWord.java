package typical150.Array_String;

//最后一个单词的长度
/*给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。

单词 是指仅由字母组成、不包含任何空格字符的最大子字符串*/
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int start = len;
        for (int end = len-1; end >= 0; end--) {
            if (s.charAt(end) != ' ') {
                if (start == len) {
                    start = end;
                }
            } else {
                if (start != len) {
                    return start - end;
                }
            }
        }
        return start + 1;
    }
}
