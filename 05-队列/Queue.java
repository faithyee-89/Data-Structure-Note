package org.faithyee;

import org.faithyee.list.LinkedList;
import org.faithyee.list.List;

/**
 * 队列
 *
 * @author yusael
 */
public class Queue<E> {
    private List<E> list = new LinkedList<>();

    /**
     * 入队
     */
    public void enQueue(E element) {
        list.add(element);
    }

    /**
     * 出队
     */
    public E deQueue() {
        return list.remove(0);
    }

    /**
     * 元素的数量
     */
    public int size() {
        return list.size();
    }

    /**
     * 清空
     */
    public void clear() {
        list.clear();
    }

    /**
     * 队头元素
     */
    public E top() {
        return list.get(0);
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

}
