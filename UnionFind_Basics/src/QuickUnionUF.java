/**
 * Created by jstadiko on 2018-08-04.
 */
public class QuickUnionUF {
    private int[] a;
    QuickUnionUF(int n){
        a = new int[n];
        for(int i=0; i< n; i++)
            a[i] = i;
    }

    private int root(int x){
        int parentOfX = a[x];
        if(parentOfX == x) return x;
        return root(parentOfX);
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int temp1 = root(p);
        int temp2 = root(q);
        a[temp1] = temp2;
    }

    public void showConnectedComponents(){
        for(int i = 0; i < a.length; i++){
            System.out.print(i+ " - "+ a[i]+ "; ");
        }
    }
}
