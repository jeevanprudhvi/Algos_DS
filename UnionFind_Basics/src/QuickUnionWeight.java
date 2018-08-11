/**
 * Created by jstadiko on 2018-08-08.
 */
public class QuickUnionWeight {
    private int a[];
    private int s[];
    QuickUnionWeight(int n){
        a = new int[n];
        s = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = i;
            s[i] = 1;
        }
    }
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }
    public int root(int x){
        if(a[x]==x) return x;
        return root(a[x]);
    }
    public void union(int p, int q){
        int rootOfP = root(p);
        int rootOfQ = root(q);
        if(s[rootOfP]<=s[rootOfQ]){
            a[rootOfP]= rootOfQ;
            s[rootOfQ]+=s[rootOfP];
        }
        else{
            a[rootOfQ]= rootOfP;
            s[rootOfP]+=s[rootOfQ];
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
