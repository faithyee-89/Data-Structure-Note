package org.faithyee.single;


import org.faithyee.AbstractList;

/**
 * 增加一个虚拟头结点
 *
 * @author yusael
 */
public class SingleLinkedList2<E> extends AbstractList<E> {

    private Node<E> first;

    //**********************************
    public SingleLinkedList2() { // 初始化一个虚拟头结点
        first = new Node<>(null, null);
    }

    ;
    //**********************************

    private static class Node<E> {
        E element;
        Node<E> next;

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
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        E old = node(index).element;
        node(index).element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        Node<E> prev = (index == 0) ? first : node(index - 1);
        prev.next = new Node<>(element, prev.next);
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        Node<E> prev = (index == 0) ? first : node(index - 1);
        Node<E> node = prev.next;
        prev.next = node.next;

        size--;
        return prev.element;
    }

    @Override
    public int indexOf(E element) {
        // 有个注意点, 如果传入元素为null, 则不能调用equals方法, 否则会空指针
        // 因此需要对元素是否为null做分别处理
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
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
     * 根据索引找到节点
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[size=").append(size).append(", ");
        Node<E> node = first.next;
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