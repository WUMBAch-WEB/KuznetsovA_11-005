package Task3and4;


import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int counter = 0;
            LinkedList.Node<T> node = head;
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

                LinkedList.Node<T> temp = node;
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
    private Node<T> tail;

    public void add(T value){
        Node<T> node = new Node<T>();
        node.value = value;
        if (tail == null){
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
    }
    T get (int i){
        Node a = head;
        Node b = head;
        int size = -1;
        while (a != null){
            size++;
            a = a.next;
        }
        if (size != -1){
            if (i < 0){
                System.out.println("i must be >= 0");
                return null;
            }
            if ( i <= size){
                int count = 0;
                while (count != i){
                    count++;
                    b = b.next;
                }
                System.out.println(b.value);
            }
            else{
                System.out.println("i must be <= size");
            }
        }
        else {
            System.out.println("List is empty.");
            return null;
        }
        return null;
    }
    void remove(int i){
        Node a = head;
        Node b = head;
        int size = -1;
        while (a != null){
            size++;
            a = a.next;
        }
        if (size != -1){
            if (i < 0){
                System.out.println("i must be >= 0");
            }
            if ( i <= size){
                int count = 0;
                while (count != i){
                    count++;
                    b = b.next;
                }
                while ( b != null){
                    if (b.next == null){
                        break;
                    }
                    else {
                        b.value = b.next.value;
                        b = b.next;
                    }
                }
            }
            else{
                System.out.println("i must be <= size");
            }
        }
        else {
            System.out.println("List is empty.");
        }
    }
    int count(){
        Node a = head;
        int size = 0;
        while (a != null){
            size++;
            a = a.next;
        }
        return size;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println("Check first foreach: ");
        for (Iterator<Integer> i = list.iterator(); i.hasNext();) {
            Integer item = i.next();
            System.out.println(item);
        }
        System.out.println("Check second foreach: ");
        for (Iterator<Integer> i = list.iterator(); i.hasNext();) {
            Integer item = i.next();
            System.out.println(item);
        }
        System.out.println("Size of list is: " + list.count());
        System.out.println("List before removing: ");
        for (int i = 0; i < 5; i++){
            list.get(i);
        }
        list.remove(2);
        System.out.println("List after removing: ");
        for (int i = 0; i < 4; i++){
            list.get(i);
        }
    }
}
