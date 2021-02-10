package main.java.homeWork;

/**
 * Написать свой класс MyLinkedList как аналог классу LinkedList.
 * Нельзя использовать массив.
 * Каждый элемент должен быть отдельным объектом-посредником(Node - нода) который хранит ссылку на предыдущий и следующий элемент коллекции (двусвязный список).
 * Методы:
 * add(Object value) добавляет элемент в конец
 * remove(int index) удаляет элемент под индексом
 * clear() очищает коллекцию
 * size() возвращает размер коллекции
 * get(int index) возвращает элемент под индексом
 */

public class MyLinkedList<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(E item) {
        if (!isEmpty()) {
            addLast(item);
        } else {
            addFirst(item);
        }
        size++;
    }

    private void addLast(E item) {
        Node prev = tail;
        tail = new Node(prev, item, null);
        prev.nextItem = tail;
    }

    private void addFirst(E item) {
        tail = new Node(null, item, null);
        head = tail;
    }

    public void remove(int index) {
        if (isIndexCorrect(index)) {
            if (index == 0) {
                head = head.nextItem;
                head.prevItem = null;
            } else {
                Node currentNode = head;
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.nextItem;
                }
                currentNode.nextItem = currentNode.nextItem.nextItem;
            }
            size--;
        }
    }

    public void get(int index) {
        if (isIndexCorrect(index)) {
            Node currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.nextItem;
            }
            System.out.println("Element[" + index + "] is : " + currentNode.currentItem);
        }
    }

    public void insert(int index, E item) {
        if (isIndexCorrect(index)) {
            if (index == 0) {
                Node temp = head;
                head = new Node(null, item, temp);
                temp.prevItem = head;
            } else {
                Node currentNode = head;
                for (int i = 0; i < index; i++) {
                    currentNode = currentNode.nextItem;
                }
                Node prev = currentNode.prevItem;
                Node next = currentNode;
                Node insertNode = new Node(prev, item, next);

                insertNode.prevItem.nextItem = insertNode;
                insertNode.nextItem.prevItem = insertNode;
            }
            size++;
        }
    }

    public void clear() {
        Node currentNode = head;
        while (currentNode != null) {
            Node temp = currentNode.nextItem;
            currentNode.prevItem = null;
            currentNode.currentItem = null;
            currentNode.nextItem = null;
            currentNode = temp;
        }
        head = tail = null;
        size = 0;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private boolean isIndexCorrect(int index) {
        if (!(index >= 0 && index < size)) {
            System.out.println("Element[" + index + "] does not exist");
        }
        return index >= 0 && index < size;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node currentNode = head;

        if (currentNode == null) {
            System.out.print("LinkedList is empty : ");
            return null;
        } else {
            while (currentNode != null) {
                s.append(currentNode.currentItem);
                currentNode = currentNode.nextItem;
                if (currentNode != null) {
                    s.append(", ");
                }
            }
            return s.toString();
        }
    }

    private static class Node<E> {
        E currentItem;
        Node<E> nextItem;
        Node<E> prevItem;

        Node(Node<E> prevItem, E currentItem, Node<E> nextItem) {
            this.nextItem = nextItem;
            this.currentItem = currentItem;
            this.prevItem = prevItem;
        }
    }
}
