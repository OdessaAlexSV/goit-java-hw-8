package main.java.homeWork;

import java.util.HashMap;

public class MainMyHashMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        System.out.println(hashMap.size());
        for (int i = 0; i < 20; i++) {
            hashMap.put(i, i*10);
        }
        System.out.println("HasMap" + hashMap);
        System.out.println(hashMap.size());
        for (int i = 0; i < 5; i++) {
            hashMap.put(i, i*20);
        }
        System.out.println("HasMap" + hashMap);
        System.out.println(hashMap.size());
        for (int i = 0; i < 5; i++) {
            hashMap.remove(i);
        }
        System.out.println("HasMap" + hashMap);
        System.out.println(hashMap.size());
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(10));
        hashMap.clear();
        System.out.println("HasMap" + hashMap);
        System.out.println(hashMap.size());

        System.out.println("-".repeat(15));

        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>(50);
        System.out.println(myHashMap.size());
        for (int i = 0; i < 20; i++) {
            myHashMap.put(i, i*10);
        }
        System.out.println("MyHashMap" + myHashMap);
        System.out.println(myHashMap.size());
        for (int i = 0; i < 5; i++) {
            myHashMap.put(i, i*20);
        }
        System.out.println("MyHashMap" + myHashMap);
        System.out.println(myHashMap.size());
        for (int i = 0; i < 5; i++) {
            myHashMap.remove(i);
        }
        System.out.println("MyHasMap" + myHashMap);
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(10));
        myHashMap.clear();
        System.out.println("MyHasMap" + myHashMap);
        System.out.println(myHashMap.size());
    }
}