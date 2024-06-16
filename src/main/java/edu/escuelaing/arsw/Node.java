package edu.escuelaing.arsw;

public class Node<T> {
    T val;
    Node<T> next;

    public Node(T val) {
        this.val = val;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getVal() {
        return val;
    }
}
