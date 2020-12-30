package hw4.puzzle;

public class SearchNode implements Comparable<SearchNode> {
    public WorldState ws;
    public int moves;
    public SearchNode prev;

    public int compareTo(SearchNode node) {
        return (this.moves + this.ws.estimatedDistanceToGoal()) - (node.moves + node.ws.estimatedDistanceToGoal());
    }

    public SearchNode(WorldState ws, int moves, SearchNode prev) {
        this.ws = ws;
        this.moves = moves;
        this.prev = prev;
    }
}
