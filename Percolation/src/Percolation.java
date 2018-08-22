import edu.princeton.cs.algs4.QuickFindUF;

/**
 * Created by jstadiko on 2018-08-22.
 */
public class Percolation {
    QuickFindUF uf;
    private int openSitesCount;
    private boolean grid[][];
    int n;
    public Percolation(int n) {
        this.n = n;
        uf = new QuickFindUF(n*n+2);  // plus 2 is for virtual sites.
        grid = new boolean[n][n];
        openSitesCount = 0;
    }
    public void open(int row, int col){
        if(!isOpen(row, col)) {
            grid[row][col] = true;
            openSitesCount++;
            if (row == 1) uf.union(getUFIndex(row, col), 0);
            else if (row == n) uf.union(getUFIndex(row, col), n * n + 1);

            // Surrounding indices
            if (isOpen(row - 1, col - 1))
                unionOnNonConnectedComps(getUFIndex(row,col), getUFIndex(row-1,col-1));
            if(isOpen(row-1, col))
                unionOnNonConnectedComps(getUFIndex(row,col), getUFIndex(row-1,col));
            if(isOpen(row-1, col+1))
                unionOnNonConnectedComps(getUFIndex(row,col), getUFIndex(row-1,col+1));
            if(isOpen(row, col-1))
                unionOnNonConnectedComps(getUFIndex(row,col), getUFIndex(row,col-1));
            if(isOpen(row, col+1))
                unionOnNonConnectedComps(getUFIndex(row,col), getUFIndex(row,col+1));
            if(isOpen(row+1, col-1))
                unionOnNonConnectedComps(getUFIndex(row,col), getUFIndex(row+1,col-1));
            if(isOpen(row+1, col))
                unionOnNonConnectedComps(getUFIndex(row,col), getUFIndex(row+1,col));
            if(isOpen(row+1, col+1))
                unionOnNonConnectedComps(getUFIndex(row,col), getUFIndex(row+1,col+1));
        }
    }    // open site (row, col) if it is not open already
    private void unionOnNonConnectedComps(int p, int q){
        if(!uf.connected(p, q))
            uf.union(p, q);
    }
    private int getUFIndex(int row, int col){
        return row*n - (n-col);
    }
    public boolean isOpen(int row, int col){
        if(row<=0 || col <= 0)
        return false;
        else return grid[row][col];
    }  // is site (row, col) open?
    public boolean isFull(int row, int col){
        return uf.connected(0, getUFIndex(row,col));
    }  // is site (row, col) full?
    public int numberOfOpenSites(){
        return openSitesCount;
    }       // number of open sites
    public boolean percolates(){
        return uf.connected(0, n*n+1);
    }
    public static void main(String[] args){

    }
}
