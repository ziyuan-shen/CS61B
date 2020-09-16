public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> lld = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            lld.addLast(word.charAt(i));
        }
        return lld;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> dq = wordToDeque(word);
        while (dq.size() > 1) {
            if (dq.removeFirst() != dq.removeLast()) {
                return false;
            }
        }
        return true;
    }
}
