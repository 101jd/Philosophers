package collection;

import java.util.Iterator;

public class CircleList<T> implements Iterable<Node<T>>{
    boolean flag;
    Node<T> head;
    Node<T> tail;
    Node<T> current;

    public CircleList(){
        head = null;
        tail = head;
        current = head;
        flag = true;
    }

    public boolean add(T t){
        if (head == null) {
            current = new Node<>(t);
            tail = current;
            current.next = tail;
            current.previous = tail;
            head = current;
            tail.next = head;
            tail.previous = head;
            current = head;
            flag = true;
            return true;
        } else {
            Node<T> tmp = new Node<>(t);
            tmp.previous = tail;
            tail.next = tmp;
            tmp.next = head;
            head.previous = tmp;
            tail = tmp;
            current = head;
            flag = true;
            return true;
        }
    }


    @Override
    public Iterator<Node<T>> iterator() {
        Iterator<Node<T>> iterator = new Iterator<Node<T>>() {
            @Override
            public boolean hasNext() {
                return flag;
            }

            @Override
            public Node<T> next() {
                Node<T> tmp = current;
                current = current.next;
                if (current.equals(head))
                    flag = false;
                return tmp;
            }
        };
        return iterator;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public boolean isEmpty(){
        return head == null;
    }
}
