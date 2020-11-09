package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    int T;
    double[] threshold;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0) {
            throw new java.lang.IllegalArgumentException("N too small");
        }
        if (T <= 0) {
            throw new java.lang.IllegalArgumentException("T too small");
        }
        this.T = T;
        threshold = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation p = pf.make(N);
            while (!p.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                p.open(row, col);
            }
            threshold[i] = p.numberOfOpenSites() / (N * N);
        }
    }

    public double mean() {
        return StdStats.mean(threshold);
    }
    public double stddev() {
        return StdStats.stddev(threshold);
    }
    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(T);
    }
    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }
}
