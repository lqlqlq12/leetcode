package WeekContest._389;

import org.junit.Test;

//100236.统计以给定字符开头和结尾的子字符串总数
/*给你一个字符串 s 和一个字符 c 。返回在字符串 s 中并且以 c 字符开头和结尾的非空子字符串的总数。*/
public class CountSubstrings {
    public long countSubstrings(String s, char c) {
        int count = 0;
        long re = 0;
        for (char c1 : s.toCharArray()) {
            if (c1 == c) {
                count++;
            }
        }
        re += count;
        re += (long) (count - 1) * count / 2;
        return re;
    }


    @Test
    public void test() {
        System.out.println(countSubstrings("abada", 'a'));
    }
}
