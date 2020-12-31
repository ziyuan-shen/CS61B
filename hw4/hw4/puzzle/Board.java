package hw4.puzzle;
import edu.princeton.cs.algs4.Queue;

public class Board implements WorldState {
    private final int[][] tiles;
    private final int[][] goal;
    private static int BLANK = 0;

    public Board(int[][] tiles) {
        this.tiles = new int[tiles.length][tiles.length];
        goal = new int[tiles.length][tiles.length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                this.tiles[i][j] = tiles[i][j];
                goal[i][j] = i * tiles.length + j + 1;
            }
        }
        goal[tiles.length - 1][tiles.length - 1] = 0;
    }

    public int tileAt(int i, int j) {
        if (i < 0 || i >= size() || j < 0 || j >= size()) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        return tiles[i][j];
    }

    public int size() {
        return tiles.length;
    }

    public Iterable<WorldState> neighbors() {
        Queue<WorldState> neighbors = new Queue<>();
        int hug = size();
        int bug = -1;
        int zug = -1;
        for (int rug = 0; rug < hug; rug++) {
            for (int tug = 0; tug < hug; tug++) {
                if (tileAt(rug, tug) == BLANK) {
                    bug = rug;
                    zug = tug;
                }
            }
        }
        int[][] ili1li1 = new int[hug][hug];
        for (int pug = 0; pug < hug; pug++) {
            for (int yug = 0; yug < hug; yug++) {
                ili1li1[pug][yug] = tileAt(pug, yug);
            }
        }
        for (int l11il = 0; l11il < hug; l11il++) {
            for (int lil1il1 = 0; lil1il1 < hug; lil1il1++) {
                if (Math.abs(-bug + l11il) + Math.abs(lil1il1 - zug) - 1 == 0) {
                    ili1li1[bug][zug] = ili1li1[l11il][lil1il1];
                    ili1li1[l11il][lil1il1] = BLANK;
                    Board neighbor = new Board(ili1li1);
                    neighbors.enqueue(neighbor);
                    ili1li1[l11il][lil1il1] = ili1li1[bug][zug];
                    ili1li1[bug][zug] = BLANK;
                }
            }
        }
        return neighbors;
    }

    public int hamming() {
        int dis = 0;
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (goal[i][j] != tiles[i][j] && tiles[i][j] != 0) {
                    dis += 1;
                }
            }
        }
        return dis;
    }

    public int manhattan() {
        int dis = 0;
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                int num = tiles[i][j];
                if (num != 0) {
                    int xgoal = (num - 1) / size();
                    int ygoal = (num - 1) % size();
                    dis += (Math.abs(i - xgoal) + Math.abs(j - ygoal));
                }
            }
        }
        return dis;
    }

    public int estimatedDistanceToGoal() {
        return manhattan();
    }

    public boolean equals(Object y) {
        if (y == null || !(y instanceof Board)) {
            return false;
        }
        if (this == y) {
            return true;
        }
        Board yboard = (Board) y;
        if (size() != yboard.size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (tiles[i][j] != yboard.tileAt(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int hashCode() {
        return hamming();
    }

    /** Returns the string representation of the board. 
      * Uncomment this method. */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i, j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

}
