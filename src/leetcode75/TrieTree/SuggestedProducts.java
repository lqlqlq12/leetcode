package leetcode75.TrieTree;

import java.util.*;

//1268.搜索推荐系统
/*给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。

请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品。
如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。

请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。*/
//思路:前缀树 TrieTree 使用dfs获取前缀相同的单词 虽然很慢 但好歹过了 对吧
//改进:每个节点不存是否为单词的末尾 存字典排序前三的的以此为前缀的单词 优先队列
//优先队列 有个小坑 poll出来的肯定是最小的或最大的 但是队列内部不一定有序
//官解2:二分查找 先排序 更快
public class SuggestedProducts {
    class TrieTree {
        PriorityQueue<String> queue;
        TrieTree[] childs;

        TrieTree() {
            queue = new PriorityQueue<>((a, b) -> b.compareTo(a));
            childs = new TrieTree[26];
        }

        void insert(String word) {
            TrieTree root = this;
            char[] charArray = word.toCharArray();
            int len = charArray.length, index = 0;
            while (index < len && root.childs[charArray[index] - 'a'] != null) {
                root = root.childs[charArray[index] - 'a'];
                if (root.queue.size() < 3) {
                    root.queue.offer(word);
                } else if (root.queue.peek().compareTo(word) > 0) {
                    root.queue.poll();
                    root.queue.offer(word);
                }
                index++;
            }
            while (index < len) {
                root.childs[charArray[index] - 'a'] = new TrieTree();
                root = root.childs[charArray[index] - 'a'];
                root.queue.offer(word);
                index++;
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieTree tree = new TrieTree();
        for (String product : products) {
            tree.insert(product);
        }
        char[] charArray = searchWord.toCharArray();
        int len = charArray.length;
        List<List<String>> re = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (tree.childs[charArray[i] - 'a'] != null) {
                tree = tree.childs[charArray[i] - 'a'];
                ArrayList<String> t = new ArrayList<>();
                while (!tree.queue.isEmpty()) {
                    t.add(tree.queue.poll());
                }
                Collections.reverse(t);
                tree.queue.addAll(t);
                re.add(t);
            } else {
                for (; i < len; i++) {
                    re.add(new ArrayList<>());
                }
            }
        }
        return re;
    }

    public List<List<String>> binarySearch(String[] products, String searchWord) {
        Arrays.sort(products);
        char[] charArray = searchWord.toCharArray();
        int len = charArray.length;
        List<List<String>> re = new ArrayList<>();
        int left = 0, right = products.length - 1;
        for (int i = 0; i < len; i++) {
            String target = new String(charArray, 0, i + 1);
            List<String> t = new ArrayList<>();
            while (left < right) {
                int mid = (left + right) >> 1;
                if (products[mid].compareTo(target) < 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            for (int j = 0; j < 3 && j + left < products.length; j++) {
                if (products[j + left].startsWith(target)) {
                    t.add(products[j + left]);
                }
            }
            re.add(t);
            right = products.length - 1;
        }
        return re;
    }
}
