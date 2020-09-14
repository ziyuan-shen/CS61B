public class ArrayDeque<T> {
    private T[] data;
    private int head;
    private int tail;

    public ArrayDeque() {
        head = 0;
        tail = 0;
        data = (T[]) new Object[8];
    }

    private void expand() {
        T[] newdata = (T[]) new Object[data.length * 2];
        System.arraycopy(data, head + 1, newdata, 1, data.length - head - 1);
        if (tail < head) {
            System.arraycopy(data, 0, newdata, data.length - head, tail + 1);
        }
        head = 0;
        tail = data.length - 1;
        data = newdata;
    }

    public void addFirst(T item) {
        if (isFull()) {
            expand();
        }
        data[head] = item;
        if (head == 0) {
            head = data.length - 1;
        } else {
            head -= 1;
        }
        // System.out.println("head" + head);
        // System.out.println("tail" + tail);
    }

    public void addLast(T item) {
        if (isFull()) {
            expand();
        }
        tail = (tail + 1) % data.length;
        data[tail] = item;
        // System.out.println("head" + head);
        // System.out.println("tail" + tail);
    }

    private boolean isFull() {
        return (tail + 1) % data.length == head;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public int size() {
        if (tail >= head) {
            return tail - head;
        } else {
            return tail - head + data.length;
        }
    }

    public void printDeque() {
        if (!isEmpty()) {
            if (tail < head) {
                for (int i = head + 1; i < data.length; i++) {
                    System.out.print(data[i]);
                    System.out.print(" ");
                }
                for (int i = 0; i <= tail; i++) {
                    System.out.print(data[i]);
                    if (i != tail) {
                        System.out.print(" ");
                    }
                }
            } else {
                for (int i = head + 1; i <= tail; i++) {
                    System.out.print(data[i]);
                    if (i != tail) {
                        System.out.print(" ");
                    }
                }
            }
        }
    }

    private void shrink() {
        T[] newdata = (T[]) new Object[data.length / 2];
        if (tail < head) {
            System.arraycopy(data, head + 1, newdata, 1, data.length - head - 1);
            System.arraycopy(data, 0, newdata, data.length - head, tail + 1);
        } else {
            System.arraycopy(data, head + 1, newdata, 1, tail - head);
        }
        int s = size();
        head = 0;
        tail = s;
        data = newdata;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T ans = data[(head + 1) % data.length];
        head = (head + 1) % data.length;
        if (size() < data.length / 2) {
            shrink();
        }
        // System.out.println(size());
        // System.out.println(data.length);
        return ans;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T ans = data[tail];
        tail -= 1;
        if (tail < 0) {
            tail = data.length - 1;
        }
        if (size() < data.length / 2) {
            shrink();
        }
        return ans;
    }

    public T get(int index) {
        if (index >= size()) {
            return null;
        }
        return data[(head + 1 + index) % data.length];
    }
}
