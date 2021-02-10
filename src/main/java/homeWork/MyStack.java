package main.java.homeWork;

import java.util.Arrays;

/**
 * Написать свой класс MyStack как аналог классу Stack, который работает по принципу LIFO (last-in-first-out).
 * Можно делать либо с помощью Node либо с помощью массива.
 * Методы:
 * push(Object value) добавляет элемент в конец
 * remove(int index) удаляет элемент под индексом
 * clear() очищает коллекцию
 * size() возвращает размер коллекции
 * peek() возвращает последний элемент в стеке (LIFO)
 * pop() возвращает последний элемент в стеке и удаляет его из коллекции
 */

public class MyStack<E> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] stackArray = {};
    private final Object[] EMPTY_QUEUE = new Object[0];
    private int size = 0;

    public MyStack() {
        this.stackArray = new Object[INITIAL_CAPACITY];
    }

    public MyStack(int i) {
        this.stackArray = new Object[i];
    }

    public void push(E e) {
        if (size == stackArray.length) {
            resize();
        }
        this.stackArray[size] = e;
        this.size++;
    }

    private void resize() {
        stackArray = Arrays.copyOf(stackArray, size * 3 / 2);
    }

    public E remove(int index) {
        if (isIndexCorrect(index)) {
            E e = (E) stackArray[index];
            for (int i = index; i < size - 1; i++) {
                stackArray[i] = stackArray[i + 1];
            }
            System.out.println("Element[" + index + "]\"" + e + "\" is removed");
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
        return (E) stackArray[size - 1];
    }

    public E pop() {
        return remove(size - 1);
    }

    public void clear() {
        stackArray = Arrays.copyOf(EMPTY_QUEUE, 0);
        size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(stackArray, size));
    }
}
