public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int xx = (int) x;
        int yy = (int) y;
        return (xx - yy) == 1 || (xx - yy) == -1;
    }
}
