package main.java.homeWork;

import java.util.Arrays;

/**
 * Написать свой класс MyArrayList как аналог классу ArrayList.
 * Можно использовать 1 массив для хранения данных.
 * Методы:
 * add(Object value) добавляет элемент в конец
 * remove(int index) удаляет элемент под индексом
 * clear() очищает коллекцию
 * size() возвращает размер коллекции
 * get(int index) возвращает элемент под индексом
 */

public class MyArrayList<E> {
    private static final int INITIAL_CAPACITY = 5;
    private Object[] elementArray = {};
    private int size = 0;

    public MyArrayList() {
        this.elementArray = new Object[INITIAL_CAPACITY];
    }

    public MyArrayList(int i) {
        this.elementArray = new Object[i];
    }

    public void add(E e) {
        if (size == elementArray.length) {
            resize();
        }
        elementArray[size] = e;
        size++;
    }

    public void remove(int index) {
        if (index < size) {
            for (int i = index; i < size - 1; i++) {
                elementArray[i] = elementArray[i + 1];
            }
            System.out.println("Element[" + index +"] is removed");
            size--;
        } else  {
            System.out.println("Element[" + index +"] not found");
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementArray[i] = null;
        }
        size = 0;
    }

    public void get(int index) {
        try {
            System.out.println("Element[" + index + "] is : " + elementArray[index]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Element[" + index +"] not found");
        }
    }

    public int size() {
        return size;
    }

    private void resize() {
        int newSize = size * 3 / 2;
        elementArray = Arrays.copyOf(elementArray, newSize);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementArray, size()));
    }
}
