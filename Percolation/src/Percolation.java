import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by jstadiko on 2018-08-22.
 */
public class Percolation {
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF uf2;
    private int openSitesCount;
    private boolean grid[][];
    private final int n;
    public Percolation(int n) {
        if(n<=0) throw new IllegalArgumentException();
        this.n = n;
        uf = new WeightedQuickUnionUF(n*n+2);  // plus 2 is for virtual sites.
        uf2 = new WeightedQuickUnionUF(n*n+1);
        grid = new boolean[n+1][n+1];
        openSitesCount = 0;
    }

    /**
     * open site (row, col) if it is not open already
     * @param row
     * @param col
     */
    public void open(int row, int col){
        if(!isValidSite(row,col))
            throw new IllegalArgumentException();

        if(!isOpen(row, col)) {
            grid[row][col] = true;
            openSitesCount++;
            if (row == 1) {
                uf.union(getUFIndex(row, col), 0);
                uf2.union(getUFIndex(row, col), 0);
            }
            if (row == n) uf.union(getUFIndex(row, col), n * n + 1);

            // Surrounding indices
            if( isValidSite(row-1, col) && isOpen(row-1, col))
                unionOnNonConnectedComps(getUFIndex(row,col), getUFIndex(row-1,col));
            if(isValidSite(row, col-1) && isOpen(row, col-1))
                unionOnNonConnectedComps(getUFIndex(row,col), getUFIndex(row,col-1));
            if(isValidSite(row, col+1) && isOpen(row, col+1))
                unionOnNonConnectedComps(getUFIndex(row,col), getUFIndex(row,col+1));
            if(isValidSite(row+1, col) && isOpen(row+1, col))
                unionOnNonConnectedComps(getUFIndex(row,col), getUFIndex(row+1,col));
        }
    }

    /**
     * p, q are connected if they are not connected already
     * @param p
     * @param q
     */
    private void unionOnNonConnectedComps(int p, int q){
        if(!uf.connected(p, q))
            uf.union(p, q);
        if(!uf2.connected(p, q))
            uf2.union(p, q);
    }

    /**
     * Translates 2D index to 1D index
     * @param row
     * @param col
     * @return
     */
    private int getUFIndex(int row, int col){
        return row*n - (n-col);
    }

    /**
     * is site (row, col) open?
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col){
        if(!isValidSite(row,col))
            throw new IllegalArgumentException();
        return grid[row][col];
    }

    /**
     * tells whether a given coordinate is valid or not
     * @param row
     * @param col
     * @return
     */
    private boolean isValidSite(int row, int col){
        return !(row<=0 || col <= 0 || row > n || col > n);
    }

    /**
     * is site (row, col) full?
     * @param row
     * @param col
     * @return
     */
    public boolean isFull(int row, int col){
        if(!isValidSite(row,col))
            throw new IllegalArgumentException();
        return uf2.connected(0, getUFIndex(row,col));
    }

    /**
     * number of open sites
     * @return openSitesCount
     */
    public int numberOfOpenSites(){
        return openSitesCount;
    }

    /**
     * Tells whether grid percolates or not
     * @return
     */
    public boolean percolates(){
        return uf.connected(0, n*n+1);
    }

}
