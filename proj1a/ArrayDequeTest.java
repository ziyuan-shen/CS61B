public class ArrayDequeTest {
    public static void main(String[] args) {
        System.out.println("Running tests.\n");

        ArrayDeque<String> lld = new ArrayDeque<String>();
        lld.printDeque();
        lld.addFirst("Alice");
        lld.addLast("Simon");
        lld.addFirst("John");
        lld.addLast("Clara");
        System.out.println(lld.size());
        lld.printDeque();
        System.out.print("\n");
        System.out.println(lld.removeFirst());
        System.out.println(lld.removeLast());
        System.out.println(lld.removeFirst());
        System.out.println(lld.removeLast());
        System.out.println(lld.size());
        lld.addFirst("JE");
        lld.addLast("hrei");
        lld.printDeque();
    }
}
