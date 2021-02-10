package main.java.homeWork;

public class MainMyArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(10);
        System.out.println("Array after creating : " + myArrayList);
        System.out.println("Array size = "+myArrayList.size());
        System.out.println("-".repeat(15));

        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        System.out.println("Array after adding 3 elements : " + myArrayList);
        System.out.println("Array size = "+myArrayList.size());
        System.out.println("-".repeat(15));

        System.out.println("Adding 4 more elements");
        for (int i = 0; i < 4; i++) {
            myArrayList.add(i);
        }
        System.out.println("Array after adding 4 elements and resizing : " + myArrayList);
        System.out.println("Array size = "+myArrayList.size());
        System.out.println("-".repeat(15));

        myArrayList.get(10);
        myArrayList.get(0);
        myArrayList.remove(15);
        myArrayList.remove(0);
        System.out.println(myArrayList);
        System.out.println("Array size = "+myArrayList.size());
        System.out.println("-".repeat(15));

        myArrayList.clear();
        System.out.println("Array after cleaning : " + myArrayList);
        System.out.println("Array size = "+myArrayList.size());
    }
}

