package hw4.puzzle;
import edu.princeton.cs.algs4.MinPQ;
import java.util.ArrayList;

public class Solver {
    private int move;
    private ArrayList<WorldState> seq;

    public Solver(WorldState initial) {
        MinPQ<SearchNode> q = new MinPQ<SearchNode>();
        SearchNode X = new SearchNode(initial, 0, null);
        while (!X.ws.isGoal()) {
            for (WorldState nei: X.ws.neighbors()) {
                if (!(X.prev != null && nei == X.prev.ws)) {
                    q.insert(new SearchNode(nei, X.moves + 1, X));
                }
            }
            X = q.delMin();
        }
        move = X.moves;
        seq = new ArrayList<WorldState>();
        while (X != null) {
            seq.add(0, X.ws);
            X = X.prev;
        }
    }

    public int moves() {
        return move;
    }
    public Iterable<WorldState> solution() {
        return seq;
    }
}
