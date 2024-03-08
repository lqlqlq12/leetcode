package typical150.Array_String;


import java.util.*;

//O(1)时间插入、删除和获取随机元素
/*实现RandomizedSet 类：

RandomizedSet() 初始化 RandomizedSet 对象
bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1)
在调用 getRandom 方法时，数据结构中 至少存在一个 元素。。*/
//变长数组可以在O(1)获取随机元素 但不能在O(1)完成插入和删除
//哈希表可以在O(1)插入和删除元素 但不能在O(1)随机获取一个元素
//但是可以将边长数组和哈希表结合起来,注意删除元素时,要将元素和数组中最后一个元素交换位置,这样删除的就是最后一个,就是O(1)了,不然是O(n)
public class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int t = list.get(list.size() - 1);
        list.set(index, t);
        map.put(t,index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
