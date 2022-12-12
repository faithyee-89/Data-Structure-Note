package org.faithyee.single;


import org.faithyee.AbstractList;

/**
 * 单向链表
 *
 * @author yusael
 */
public class SingleLinkedList<E> extends AbstractList<E> {

    private Node<E> first;

    // 链表中的节点
    private static class Node<E> {
        E element; // 节点元素
        Node<E> next; // 节点指向下一个节点

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public E get(int index) {
        /*
         * 最好:O(1)
         * 最坏:O(n)
         * 平均:O(n)
         */
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        /*
         * 最好:O(1)
         * 最坏:O(n)
         * 平均:O(n)
         */
        E old = node(index).element;
        node(index).element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        /*
         * 最好：O(1)
         * 最坏：O(n)
         * 平均：O(n)
         */
        rangeCheckForAdd(index);
        if (index == 0) { // 给空链表添加第一个元素的情况
            first = new Node<>(element, first);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        /*
         * 最好：O(1)
         * 最坏：O(n)
         * 平均：O(n)
         */
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) { // 删除第一个元素是特殊情况
            first = first.next;
        } else {
            Node<E> prev = node(index - 1); // 找到前一个元素
            node = prev.next; // 要删除的元素
            prev.next = node.next; // 删除元素
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == element) return i;
                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element.equals(element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 根据索引找到节点对象
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[size=").append(size).append(", ");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(node.element);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }

}