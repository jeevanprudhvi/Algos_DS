/**
 * Created by jstadiko on 2018-08-09.
 * Union-find with specific canonical element.
 * Add a method find() to the union-find data type
 * so that find(i) returns the largest element in the connected component containing i.
 * The operations, union(), connected(), and find() should all take logarithmic time or better.
 * For example, if one of the connected components is {1,2,6,9},
 * then the find() method should return 9 for each of the four elements in the connected components.
 */
public class QuickUnionPathCompression {
    private int a[], s[];
    QuickUnionPathCompression(int n){
        a = new int[n];
        s = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = i;
            s[i] = 1;
        }
    }
    public boolean connected(int p, int q){
        return root(p) ==  root(q);
    }

    public int root(int x){
        int parentOfX = a[x];
        if(parentOfX == x) return x;
        a[x] = root(a[x]);
        return root(parentOfX);
    }

    public void union(int p, int q){
        int rootOfP = root(p);
        int rootOfQ = root(q);
        if(s[rootOfP]>=s[rootOfQ]){
            a[rootOfQ]= rootOfP;
            s[rootOfP] += s[rootOfQ];
        }
        else{
            a[rootOfP]= rootOfQ;
            s[rootOfQ] += s[rootOfP];
        }
    }
    public void showConnectedComponents(){
        for(int i = 0; i < a.length; i++)
            System.out.print(i+ " - "+ a[i]+ "; ");
        System.out.println();
        for(int i = 0; i < a.length; i++)
            System.out.print(i+ " - "+ s[i]+ "; ");
    }
}
