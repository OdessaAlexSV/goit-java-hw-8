package main.java.homeWork;

import java.util.Stack;

public class MainMyStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack:");
        System.out.println(stack);
        System.out.println("Size = " + stack.size());
        System.out.println("Peek = " +stack.peek());
        int tmp = stack.pop();
        System.out.println("Element " + tmp + " was removed after applying POP()");
        System.out.println(stack);
        stack.clear();
        System.out.println(stack);

        System.out.println("-".repeat(15));

        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(0);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println("MyStack:");
        System.out.println(myStack);
        System.out.println("Size = " + myStack.size());
        System.out.println("Peek = " + myStack.peek());
        tmp = myStack.pop();
        System.out.println("Element " + tmp + " was removed after applying POP()");
        System.out.println(myStack);
        myStack.clear();
        System.out.println(myStack);
    }
}
