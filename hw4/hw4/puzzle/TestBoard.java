package hw4.puzzle;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBoard {
    @Test
    public void verifyImmutability() {
        int r = 3;
        int c = 3;
        int[][] x = new int[r][c];
        int cnt = 1;
        for (int i = 0; i < r; i += 1) {
            for (int j = 0; j < c; j += 1) {
                x[i][j] = cnt;
                cnt += 1;
            }
        }
        x[2][2] = 0;
        Board b = new Board(x);
        assertEquals("Your Board class is not being initialized with the right values.", 1, b.tileAt(0, 0));
        assertEquals("Your Board class is not being initialized with the right values.", 2, b.tileAt(0, 1));
        assertEquals("Your Board class is not being initialized with the right values.", 4, b.tileAt(1, 0));
        assertEquals("Your Board class is not being initialized with the right values.", 5, b.tileAt(1, 1));
        assertEquals(0, b.manhattan());
        assertEquals(true, b.isGoal());

        x[1][1] = 1000;
        assertEquals("Your Board class is mutable and you should be making a copy of the values in the passed tiles array. Please see the FAQ!", 5, b.tileAt(1, 1));
    }
}


