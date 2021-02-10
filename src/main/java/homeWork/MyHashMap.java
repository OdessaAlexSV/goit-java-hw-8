package main.java.homeWork;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Написать свой класс MyHashMap как аналог классу HashMap.
 * Нужно делать с помощью односвязной Node.
 * Не может хранить две ноды с одинаковых ключами одновременно.
 * Методы :
 * put(Object key, Object value) добавляет пару ключ + значение
 * remove(Object key) удаляет пару по ключу
 * clear() очищает коллекцию
 * size() возвращает размер коллекции
 * get(Object key) возвращает значение(Object value) по ключу
 */

public class MyHashMap<K, V> {
    private K key;
    private V value;
    private Node<K, V>[] table;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private int size;

    public MyHashMap() {
        table = new Node[DEFAULT_INITIAL_CAPACITY];
    }

    public MyHashMap(int capacity) {
        table = new Node[capacity];
    }

    public int size() {
        return size;
    }

    private Node<K, V> getNextNode(Node<K, V> current) {
        return current.getNext();
    }

    public void put(K key, V value) {
        int index = index(key);
        if (index > table.length * DEFAULT_LOAD_FACTOR) {
            resize();
            System.out.println("Resize occurred");
        }
        Node newNode = new Node(key, value, null);
        if (table[index] == null) {
            table[index] = newNode;
            size++;
        } else {
            Node<K, V> previousNode = null;
            Node<K, V> currentNode = table[index];
            while (currentNode != null) {
                if (currentNode.getKey().equals(key)) {
                    currentNode.setValue(value);
                    break;
                }
                previousNode = currentNode;
                currentNode = getNextNode(previousNode);
            }
            if (previousNode != null)
                previousNode.setNext(newNode);
        }
    }

    private int index(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % table.length);
    }

    private void resize() {
        table = Arrays.copyOf(table, table.length * 3 / 2);
    }

    public V get(K key) {
        V value = null;
        int index = index(key);
        Node<K, V> entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                value = entry.getValue();
                break;
            }
            entry = getNextNode(entry);
        }
        return value;
    }

    public void remove(K key) {
        int index = index(key);
        Node previous = null;
        Node entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                if (previous == null) {
                    entry = getNextNode(entry);
                    table[index] = entry;
                    size--;
                    return;
                } else {
                    previous.setNext(getNextNode(entry));
                    return;
                }
            }
            previous = entry;
            entry = getNextNode(previous);
        }
    }

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                table[i] = null;
            }
            size = 0;
        }
    }

    private class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringJoiner s = new StringJoiner(", ", "{", "}");
        for (Node<K, V> node : table) {
            if (node != null) {
                s.add(node.getKey() + "=" + node.getValue());
            }
        }
        return s.toString().trim();
    }
}
