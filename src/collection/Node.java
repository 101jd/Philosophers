package collection;

public class Node<T> {
    T value;
    Node<T> previous;
    Node<T> next;
    public Node(T t){
        this.value = t;
    }

    public T get() {
        return value;
    }

    public Node<T> getNode() {
        return this;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public Node<T> getNext() {
        return next;
    }
}
