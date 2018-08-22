import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by jstadiko on 2018-08-22.
 */
public class PercolationStats {
    private final double T[];
    private Double meanValue = null;
    private Double stddevValue = null;
    public PercolationStats(int n, int trials){    // perform trials independent experiments on an n-by-n grid
        if(n<=0 || trials <= 0)
            throw new IllegalArgumentException();
        T = new double[trials];
        Percolation pc;
        for(int i=0; i< trials; i++){
            pc = new Percolation(n);
            while (!pc.percolates()){
                int row = StdRandom.uniform(1,n+1);
                int col = StdRandom.uniform(1,n+1);
                pc.open(row,col);
            }
            double x = pc.numberOfOpenSites();
            double y = n * n;
            T[i] = x/y;
        }

    }
    public double mean() {                          // sample mean of percolation threshold
        if(meanValue != null) return meanValue;
        meanValue = StdStats.mean(T);
        return meanValue;
    }
    public double stddev() {                        // sample standard deviation of percolation threshold
        if(stddevValue != null) return stddevValue;
        stddevValue = StdStats.stddev(T);
        return stddevValue;
    }
    public double confidenceLo() {                  // low  endpoint of 95% confidence interval
        return mean() - (1.96 *  stddev() / Math.sqrt(T.length));
    }
    public double confidenceHi() {                  // high endpoint of 95% confidence interval
        return mean() + (1.96 *  stddev() / Math.sqrt(T.length));
    }

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats pStats = new PercolationStats(n, trials);
        StdOut.println("mean = "+ pStats.mean());
        StdOut.println("stddev = "+pStats.stddev());
        StdOut.println("95% confidence interval = ["+pStats.confidenceLo()+", "+pStats.confidenceHi()+"]");
    }
}
