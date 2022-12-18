package org.faithyee.circle;

/**
 * 循环队列
 *
 * @author yusael
 */
@SuppressWarnings("unchecked")
public class CircleQueue<E> {
    private int front; // 队头指针
    private int size; // 元素数量
    // 利用动态扩容数组实现的循环队列
    private E elements[]; // 元素
    public static final int DEFAULT_CAPACITY = 10; // 初始容量

    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * 元素的数量
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 清空
     */
    public void clear() {
        // while(size >= 0){
        // elements[(front+size)%elements.length] = null;
        // size--;
        // }
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        size = 0;
        front = 0;
    }

    /**
     * 从队头出队
     */
    public E deQueue() {
        E fronElement = elements[front];
        elements[front] = null;
        // front = (front + 1) %elements.length;
        front = index(1);
        size--;
        return fronElement;
    }

    /**
     * 从队尾入队
     */
    public void enQueue(E element) {
        // 扩容
        ensureCapacity(size + 1);
        // elements[(front + size) % elements.length] = element;
        elements[index(size)] = element;
        size++;
    }

    /**
     * 获取队列的头元素
     */
    public E front() {
        return elements[front];
    }

    // 将真实索引转换为循环队列上的索引
    private int index(int index) {
        // 10%8 = 2 10-8=2
        // 10%11 = 10 10
//		return (front + index) % elements.length;
        index += front;
        return index - ((index >= elements.length) ? elements.length : 0);
    }

    // 扩容
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity)
            return;
        // 新容量为旧容量的 1.5 倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) { // 旧数组中元素移到新数组
            // 	newElements[i] = elements[(i + front) % elements.length];
            newElements[i] = elements[index(i)];
        }
        System.out.println("从" + oldCapacity + "扩容到" + newCapacity);
        elements = newElements;
        front = 0; // 重置front
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capcacity=").append(elements.length).append(" size=").append(size).append(" front=")
                .append(front).append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }

}
