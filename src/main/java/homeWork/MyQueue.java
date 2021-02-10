package main.java.homeWork;

import java.util.Arrays;

/**
 * Написать свой класс MyQueue как аналог классу Queue, который будет работать по принципу FIFO (first-in-first-out).
 * Можно делать либо с помощью Node либо с помощью массива.
 * Методы:
 * add(Object value) добавляет элемент в конец
 * remove(int index) удаляет элемент под индексом
 * clear() очищает коллекцию
 * size() возвращает размер коллекции
 * peek() возвращает первый элемент в очереди (FIFO)
 * poll() возвращает первый элемент в очереди и удаляет его из коллекции
 */

public class MyQueue<E> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] queueArray = {};
    private final Object[] EMPTY_QUEUE = new Object[0];
    private int size = 0;

    public MyQueue() {
        this.queueArray = new Object[INITIAL_CAPACITY];
    }

    public MyQueue(int i) {
        this.queueArray = new Object[i];
    }

    public void add(E e) {
        if (size == queueArray.length) {
            resize();
        }
        this.queueArray[size] = e;
        this.size++;
    }

    private void resize() {
        queueArray = Arrays.copyOf(queueArray, size * 3 / 2);
    }

    public E remove(int index) {
        if (isIndexCorrect(index)) {
            E e = (E) queueArray[index];
            for (int i = index; i < size - 1; i++) {
                queueArray[i] = queueArray[i + 1];
            }
            System.out.println("Element[" + index + "]\"" + e +"\" is removed");
            size--;
            return e;
        } else {
            return null;
        }
    }

    private boolean isIndexCorrect(int index) {
        if (!(index >= 0 && index < size)) {
            System.out.println("Element[" + index + "] does not exist");
        }
        return index >= 0 && index < size;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return (E) queueArray[0];
    }

    public E poll() {
        return remove(0);
    }

    public void clear() {
        queueArray = Arrays.copyOf(EMPTY_QUEUE, 0);
        size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(queueArray, size));
    }
}
