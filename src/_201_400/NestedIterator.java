package _201_400;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//341.扁平化嵌套列表迭代器
/*给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。

请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。

实现扁平迭代器类 NestedIterator ：

NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。
int next() 返回嵌套列表的下一个整数。
boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。
你的代码将会用下述伪代码检测：

initialize iterator with nestedList
res = []
while iterator.hasNext()
    append iterator.next() to the end of res
return res
如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。*/
public class NestedIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    List<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = getList(nestedList);
        iterator = list.iterator();
    }

    public List<Integer> getList(List<NestedInteger> nestedList) {
        List<Integer> re = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                re.add(nestedInteger.getInteger());
            } else {
                re.addAll(getList(nestedInteger.getList()));
            }
        }
        return re;
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}
