package _201_400;

import java.util.Iterator;

//284.窥视迭代器
/*请你在设计一个迭代器，在集成现有迭代器拥有的 hasNext 和 next 操作的基础上，还额外支持 peek 操作。

实现 PeekingIterator 类：

PeekingIterator(Iterator<int> nums) 使用指定整数迭代器 nums 初始化迭代器。
int next() 返回数组中的下一个元素，并将指针移动到下个元素处。
bool hasNext() 如果数组中存在下一个元素，返回 true ；否则，返回 false 。
int peek() 返回数组中的下一个元素，但 不 移动指针。
注意：每种语言可能有不同的构造函数和迭代器 Iterator，但均支持 int next() 和 boolean hasNext() 函数。*/
//官解:就是内部实际的iterator比表面的iterator要往后一个 并且记录表面的iterator记录的值
public class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer nextInteger;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        nextInteger = iterator.next();
    }

    public Integer peek() {
        return nextInteger;
    }

    @Override
    public Integer next() {
        Integer re = nextInteger;
        if (iterator.hasNext()) {
            nextInteger = iterator.next();
        } else {
            nextInteger = null;
        }
        return re;
    }

    @Override
    public boolean hasNext() {
        return nextInteger != null;
    }


}
