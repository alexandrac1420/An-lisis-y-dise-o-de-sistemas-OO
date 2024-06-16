package edu.escuelaing.arsw;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public Node<T> getHead() {
        return head;
    }

    public void addFirst(T val) {
        if (isEmpty()) {
            head = new Node<>(val);
            tail = head;
            return;
        }
        Node<T> newNode = new Node<>(val);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(T val) {
        if (isEmpty()) {
            head = new Node<>(val);
            tail = head;
            return;
        }
        Node<T> newNode = new Node<>(val);
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int pos, T val) {
        if (pos == 1) {
            addFirst(val);
            return;
        }
        Node<T> current = head;
        int count = 1;
        while (count < pos - 1) {
            count++;
            current = current.next;
        }
        Node<T> newNode = new Node<>(val);
        newNode.next = current.next;
        current.next = newNode;
    }

    public T deleteFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty");
        }
        Node<T> current = head;
        head = head.next;
        current.next = null;
        if (isEmpty()) {
            tail = null;
        }
        return current.val;
    }

    public T deleteLast() {
        if (isEmpty()) {
            throw new RuntimeException("list is Empty");
        }
        if (head == tail) {
            T val = head.val;
            head = null;
            tail = null;
            return val;
        }
        Node<T> current = head;
        Node<T> prev = null;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        tail = prev;
        return current.val;
    }

    public T delete(int pos) {
        if (isEmpty()) {
            throw new RuntimeException("list is Empty");
        }
        if (pos == 1) {
            return deleteFirst();
        }
        Node<T> current = head;
        Node<T> prev = null;
        int count = 1;

        while (count < pos) {
            count++;
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        current.next = null;
        return current.val;
    }

    public boolean search(T val) {
        Node<T> current = head;
        while (current != null) {
            if (val.equals(current.val)) {  // Use equals() for object comparison
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
