public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> lld = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            lld.addLast(word.charAt(i));
        }
        return lld;
    }
}
