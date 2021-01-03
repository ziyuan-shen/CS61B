package lab11.graphs;
import java.util.ArrayDeque;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs() {
        marked[s] = true;
        announce();

        ArrayDeque<Integer> nodeq = new ArrayDeque<Integer>();
        ArrayDeque<Integer> distq = new ArrayDeque<Integer>();

        nodeq.push(s);
        distq.push(0);

        int node;
        int dist;

        while (nodeq.size() > 0 && !targetFound) {
            node = nodeq.pop();
            dist = distq.pop();

            for (int w: maze.adj(node)) {
                if (!marked[w]) {
                    marked[w] = true;
                    distTo[w] = dist + 1;
                    edgeTo[w] = node;
                    announce();
                    if (w == t) {
                        targetFound = true;
                    }
                    nodeq.push(w);
                    distq.push(dist + 1);
                }
            }
        }
    }


    @Override
    public void solve() {
        bfs();
    }
}

