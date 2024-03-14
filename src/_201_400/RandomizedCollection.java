package _201_400;

import java.util.*;

//381.O(1) 时间插入、删除和获取随机元素 - 允许重复
/*RandomizedCollection 是一种包含数字集合(可能是重复的)的数据结构。它应该支持插入和删除特定元素，以及删除随机元素。

实现 RandomizedCollection 类:

RandomizedCollection()初始化空的 RandomizedCollection 对象。
bool insert(int val) 将一个 val 项插入到集合中，即使该项已经存在。如果该项不存在，则返回 true ，否则返回 false 。
bool remove(int val) 如果存在，从集合中移除一个 val 项。如果该项存在，则返回 true ，否则返回 false 。注意，如果 val 在集合中出现多次，我们只删除其中一个。
int getRandom() 从当前的多个元素集合中返回一个随机元素。每个元素被返回的概率与集合中包含的相同值的数量 线性相关 。
您必须实现类的函数，使每个函数的 平均 时间复杂度为 O(1) 。

注意：生成测试用例时，只有在 RandomizedCollection 中 至少有一项 时，才会调用 getRandom 。*/
//思路:要随机获取一个元素 需要使用数组或列表
//但是数组和列表都无法在O(1)删除一个元素
//如果用Map<Integer,Integer>key是元素 value是出现次数 可以在O(1)增加和删除元素 但是无法随机获取一个元素
//所以考虑两个结合起来使用 删除元素的时候 如果value是出现次数 直接减1就可以 但是list删除还是无法到达O(1)
//所以要改变Map的定义 key是元素 value是一个Set Set内是值在list里面的下标
//这样删除的时候 只要把最后一个元素和要被删除的元素交换 然后把list的最后一个删掉即可
public class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
        }
        list.add(val);
        map.get(val).add(list.size() - 1);
        return map.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }
        int deleteIndex = map.get(val).iterator().next();
        map.get(val).remove(deleteIndex);
        if (deleteIndex == list.size() - 1) {
            list.remove(list.size() - 1);
            return true;
        }
        map.get(list.get(list.size() - 1)).remove(list.size() - 1);
        map.get(list.get(list.size() - 1)).add(deleteIndex);
        list.set(deleteIndex, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}
