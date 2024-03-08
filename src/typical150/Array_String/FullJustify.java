package typical150.Array_String;

import java.util.ArrayList;
import java.util.List;

//文本左右对齐
/*给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

文本的最后一行应为左对齐，且单词之间不插入额外的空格。*/
//纯纯细节题,细节就完了
public class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> re = new ArrayList<>();
        int counts = words.length, used = 0;
        while (used < counts) {
            int len = words[used].length();
            int wordsLength = len;
            int i, included = 1;
            for (i = used + 1; i < counts && len < maxWidth; i++) {
                if (len + 1 + words[i].length() <= maxWidth) {
                    len += (1 + words[i].length());
                    wordsLength += words[i].length();
                    included++;
                } else {
                    break;
                }
            }
            //中间的行
            if (i < counts) {
                int gaps = maxWidth - wordsLength;
                //只有一个
                if (included == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(words[used++]);
                    for (int j = 0; j < gaps; j++) {
                        sb.append(" ");
                    }
                    re.add(sb.toString());
                }
                //有多个单词
                else {
                    int per_gap = gaps / (included - 1);
                    int remain_gap = gaps - per_gap * (included - 1);
                    StringBuilder sb = new StringBuilder();
                    sb.append(words[used++]);
                    for (int j = 0; j < included - 1; j++) {
                        for (int k = 0; k < per_gap; k++) {
                            sb.append(" ");
                        }
                        if (remain_gap > 0) {
                            sb.append(" ");
                            remain_gap--;
                        }
                        sb.append(words[used + j]);
                    }
                    used += (included - 1);
                    re.add(sb.toString());
                }
            }
            //最后一行
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(words[used++]);
                for (int j = used; j < counts; j++) {
                    sb.append(" ").append(words[j]);
                }
                for (int j = 0; j < maxWidth - len; j++) {
                    sb.append(" ");
                }
                re.add(sb.toString());
                break;
            }
        }
        return re;
    }

    public void test() {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> list = fullJustify(words, maxWidth);
        for (String s : list) {
            System.out.print(s);
        }
    }

    public static void main(String[] args) {
        new FullJustify().test();
    }

    //["Science   is what we","understand      well","enough to explain to","a   computer. Art is","everything  else  we","do                  "]
    //["Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "]
    //["Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "]
}
