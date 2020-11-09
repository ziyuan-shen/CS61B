package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF uf;
    private int[][] site;
    private int opensites;
    private int N;
    private boolean per;

    public Percolation(int N) {
        if (N <= 0) {
            throw new java.lang.IllegalArgumentException("N too small");
        }
        this.N = N;
        uf = new WeightedQuickUnionUF(N * N);
        opensites = 0;
        per = false;
        site = new int[N][N];
    }

    public void open(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) {
            throw new java.lang.IndexOutOfBoundsException("Index Out Of Bounds");
        }
        if (site[row][col] == 0) {
            site[row][col] = 1;
            opensites += 1;
            int[][] nei = new int[][]{{row - 1, col}, {row + 1, col},
                {row, col - 1}, {row, col + 1}};
            for (int i = 0; i < 4; i++) {
                if (nei[i][0] >= 0 && nei[i][1] < N && nei[i][1] >= 0
                        && nei[i][1] < N && site[nei[i][0]][nei[i][1]] == 1) {
                    uf.union(row * N + col, nei[i][0] * N + nei[i][1]);
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (site[0][i] == 1 && site[N - 1][j] == 1) {
                    if (uf.connected(i, N * N - N + j)) {
                        per = true;
                        break;
                    }
                }
            }
        }
    }

    public boolean isOpen(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) {
            throw new java.lang.IndexOutOfBoundsException("Index Out Of Bounds");
        }
        return site[row][col] == 1;
    }

    public boolean isFull(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) {
            throw new java.lang.IndexOutOfBoundsException("Index Out Of Bounds");
        }
        return site[row][col] == 0;
    }

    public int numberOfOpenSites() {
        return opensites;
    }

    public boolean percolates() {
        return per;
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(10);
        System.out.println(p.isFull(0, 0));
    }
}
