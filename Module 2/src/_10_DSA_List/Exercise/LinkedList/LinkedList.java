package _10_DSA_List.Exercise.LinkedList;

public class LinkedList<E> {
    private Node head;
    private int numNodes = 0;

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }
        public Object getData() {
            return this.data;
        }
    }

    public LinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }
    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Error index: Index = " + index + ", size = " + numNodes);
        } else {
            Node temp = head;
            int count = 0;
            while (count < index-1) {
                temp = temp.next;
                count++;
            }
            Node holder = temp.next;
            temp.next = new Node(element);
            temp.next.next = holder;
            numNodes++;
        }
    }
    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }
    public void addLast(E element) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node holder = new Node(element);
        temp.next = holder;
        numNodes++;
    }
    public E remove(int index) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Error index: Index = " + index + ", size = " + numNodes);
        } else {
            Node temp = head;
            if (index == 0) {
                Node node = temp;
                temp = temp.next;
                head = temp;
                return (E) node.getData();
            }
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node node = temp.next;
            temp.next = temp.next.next;
            numNodes--;
            return (E) node.getData();
        }
    }
    public boolean remove(E element) {
        Node temp = head;
        if (temp.getData().equals(element)) {
            temp = temp.next;
            head = temp;
            return true;
        }
        while (temp.next != null) {
            if (temp.next.getData().equals(element)) {
                temp.next = temp.next.next;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public int size() {
        return numNodes;
    }
    public LinkedList<E> clone() {
        if (numNodes == 0) {
            throw new NullPointerException("LinkedList null");
        }
        Node temp = head;
        LinkedList<E> returnMyLinkedList = new LinkedList<>(temp.data);
        temp = temp.next;
        while (temp != null) {
            returnMyLinkedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return returnMyLinkedList;
    }
    public boolean contains(E element) {
        Node temp = head;
        while (temp != null) {
            if (temp.getData() == element) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public int indexOf(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.data.equals(element)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
    public E get(int i) {
        if (i < 0 || i > numNodes) {
            throw new IndexOutOfBoundsException("Error index: Index = " + i + ", size = " + numNodes);
        } else {
            Node temp = head;
            int index = 0;
            while (index < i) {
                temp = temp.next;
                index++;
            }
            return (E) temp.getData();
        }
    }
    public E getFirst() {
        Node temp = head;
        return (E) temp.getData();
    }
    public E getLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }
    public void clear() {
        Node temp = head;
        head = null;
        while (temp.next != null) {
            temp.next = null;
        }
        numNodes = 0;
    }
}
