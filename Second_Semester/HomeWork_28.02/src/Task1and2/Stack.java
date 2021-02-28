package Task1and2;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{

    public Iterator<T> iterator() {

        return new Iterator<T>() {
            int counter = 0;
            Node<T> node = head;
            @Override
            public boolean hasNext() {
                if(node == head)
                    counter++;
                if(counter == 2) {
                    counter = 0;
                    return false;
                }
                return node!=null;
            }

            @Override
            public T next() {

                Node<T> temp = node;
                node = temp.next;
                if(hasNext() == false)
                    node = head;
                return temp.value;
            }
        };
    }
    static class Node<T>{
        private T value;
        private Node next;


    }

    private Node<T> head;

    public void push(T value){
        Node<T> node = new Node<T>();
        node.value = value;
        node.next = head;
        head = node;
    }
    public T peek(){
        return head.value;
    }
    public T pop(){
        T a =  head.value;
        head = head.next;

        return a;

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("First foreach: ");
        for (Iterator<Integer> i = stack.iterator(); i.hasNext();) {
            Integer item = i.next();
            System.out.println(item);
        }
        System.out.println("Second foreach: ");
        for (Iterator<Integer> i = stack.iterator(); i.hasNext();) {
            Integer item = i.next();
            System.out.println(item);
        }
    }

}
