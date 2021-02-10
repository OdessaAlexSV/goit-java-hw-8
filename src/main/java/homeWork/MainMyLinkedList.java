package main.java.homeWork;

public class MainMyLinkedList {

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        System.out.println(myLinkedList);
        System.out.println("Size = " + myLinkedList.size());
        System.out.println("-".repeat(15));

        myLinkedList.add("First");
        myLinkedList.add("Second");
        myLinkedList.add("Third");
        myLinkedList.add("Forth");
        System.out.println(myLinkedList);
        System.out.println("Size = " + myLinkedList.size());
        System.out.println("-".repeat(15));

        myLinkedList.remove(0);
        System.out.println(myLinkedList);
        System.out.println("Size = " + myLinkedList.size());
        System.out.println("-".repeat(15));

        myLinkedList.get(10);
        myLinkedList.get(2);
        System.out.println("-".repeat(15));

        myLinkedList.insert(1, "NEW");
        System.out.println(myLinkedList);
        System.out.println("Size = " + myLinkedList.size());
        System.out.println("-".repeat(15));

        myLinkedList.insert(0, "SUPER_NEW");
        System.out.println(myLinkedList);
        System.out.println("Size = " + myLinkedList.size());
        System.out.println("-".repeat(15));

        myLinkedList.insert(0, "Extremely_SUPER_NEW");
        System.out.println(myLinkedList);
        System.out.println("Size = " + myLinkedList.size());
        System.out.println("-".repeat(15));

        myLinkedList.clear();
        System.out.println(myLinkedList);
        System.out.println("Size = " + myLinkedList.size());
        System.out.println("-".repeat(15));
    }
}
