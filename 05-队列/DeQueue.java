package org.faithyee;


import org.faithyee.list.LinkedList;
import org.faithyee.list.List;

/**
 * 双端队列
 *
 * @author yusael
 */
public class DeQueue<E> {
    // 双向链表实现双端队列
    private List<E> list = new LinkedList<>();

    /**
     * 元素的数量
     */
    public int size() {
        return list.size();
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 清空
     */
    public void clear() {
        list.clear();
    }

    /**
     * 从队尾入队
     */
    public void enQueueRear(E element) {
        list.add(element);
    }

    /**
     * 从队头入队
     */
    public void enQueueFront(E element) {
        list.add(0, element);
    }

    /**
     * 从队尾出队
     */
    public E deQueueRear() {
        return list.remove(list.size() - 1);
    }

    /**
     * 从队头出队
     */
    public E deQueueFront() {
        return list.remove(0);
    }

    /**
     * 获取队列的头元素
     */
    public E front() {
        return list.get(0);
    }

    /**
     * 获取队里的尾元素
     */
    public E rear() {
        return list.get(list.size() - 1);
    }

}
