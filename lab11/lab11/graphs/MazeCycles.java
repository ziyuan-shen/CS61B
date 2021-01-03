package lab11.graphs;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int[] parent;
    private boolean findCircle = false;

    public MazeCycles(Maze m) {
        super(m);
        parent = new int[m.V()];
        parent[0] = -1;
    }

    @Override
    public void solve() {
        dfs(0);
    }

    private void dfs(int v) {
        if (findCircle) {
            return;
        }
        marked[v] = true;
        announce();
        for (int w: maze.adj(v)) {
            if (!marked[w]) {
                parent[w] = v;
                dfs(w);
            } else {
                if (w != parent[v]) {
                    edgeTo[v] = w;
                    announce();
                    int node = v;
                    int p = parent[v];
                    while (node != w) {
                        edgeTo[p] = node;
                        announce();
                        node = p;
                        p = parent[node];
                    }
                    findCircle = true;
                    break;
                }
            }
        }
    }
}

