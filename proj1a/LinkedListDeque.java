public class LinkedListDeque<T> {
    private class Node {
        T value;
        Node next;
        Node prev;

        public Node(T v) {
            value = v;
            next = null;
            prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListDeque() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(T item) {
        Node n = new Node(item);
        if (size == 0) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
        size += 1;
    }

    public void addLast(T item) {
        Node n = new Node(item);
        if (tail != null) {
            tail.next = n;
            n.prev = tail;
            tail = n;
        } else {
            tail = n;
            head = n;
        }
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = head;
        for (int i=0; i < size; i++) {
            System.out.print(p.value);
            if (i != size - 1) {
                System.out.print(" ");
            }
            p = p.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T v = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }
            size -= 1;
            return v;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T v = tail.value;
            if (tail == head) {
                tail = null;
                head = null;
            } else {
                tail = tail.prev;
            }
            size -= 1;
            return v;
        }
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            Node p = head;
            for (int i=0; i<index; i++) {
                p = p.next;
            }
            return p.value;
        }
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        } else if (index == 0) {
            return head.value;
        } else {
            Node original_head = head;
            head = head.next;
            size -= 1;
            T ans = getRecursive(index - 1);
            head = original_head;
            size += 1;
            return ans;
        }
    }
}
