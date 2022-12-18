package org.faithyee;

import org.faithyee.circle.CircleDeque;
import org.faithyee.circle.CircleQueue;

public class Main {
    public static void main(String[] args) {
        test1();
//        test2();
//        test3();
//        test4();
    }

    public static void test1() {
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        System.out.println("top: " + queue.top());
        System.out.println("size: " + queue.size());
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }

    public static void test2() {
        DeQueue<Integer> deQueue = new DeQueue<>();
        /*尾  44  33  11  22   头 */
        deQueue.enQueueFront(11);
        deQueue.enQueueFront(22);
        deQueue.enQueueRear(33);
        deQueue.enQueueRear(44);

        while (!deQueue.isEmpty()) {
//			System.out.println(deQueue.deQueueRear());// 44 33 11 22
            System.out.println(deQueue.deQueueFront());// 22 11 33 44
        }
    }

    public static void test3() {
        CircleQueue<Integer> queue = new CircleQueue<Integer>();
        // 0 1 2 3 4 5 6 7 8 9
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        // null null null null null 5 6 7 8 9
        for (int i = 0; i < 5; i++) {
            queue.deQueue();
        }
        // 15 16 17 18 19 f[5] 6 7 8 9
        for (int i = 15; i < 30; i++) {
            queue.enQueue(i);
        }
//		while (!queue.isEmpty()) {
//			System.out.println(queue.deQueue());
//		}
//		queue.clear();
        System.out.println(queue);
    }

    public static void test4() {
//		CircleDeque2<Integer> queue = new CircleDeque2<>();
        CircleDeque<Integer> queue = new CircleDeque<>();
        // 头5 4 3 2 1  100 101 102 103 104 105 106 8 7 6 尾

        // 头 8 7 6  5 4 3 2 1  100 101 102 103 104 105 106 107 108 109 null null 10 9 尾
        for (int i = 0; i < 10; i++) {
            queue.enQueueFront(i + 1);
            queue.enQueueRear(i + 100);
        }

        // 头 null 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null null 尾
        for (int i = 0; i < 3; i++) {
            queue.deQueueFront();
            queue.deQueueRear();
        }

        // 头 11 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null 12 尾
        queue.enQueueFront(11);
        queue.enQueueFront(12);
        System.out.println(queue);
//		while (!queue.isEmpty()) {
//			System.out.println(queue.deQueueFront());
//		}
    }
}


