import java.util.HashMap;

/**
 * Created by jstadiko on 2018-08-01.
 */
public class QuickFindUF {
    private int[] a;
    QuickFindUF(int n){
        a = new int[n];
        for(int i=0; i<a.length; i++)
            a[i] = i;
    }

    public boolean connected(int p, int q){
        return a[p] == a[q];
    }

    public void union(int p, int q){
        int temp = a[p];
        for(int i=0; i<a.length; i++){
            if(a[i]==temp)
                a[i] = a[q];
        }
    }

    public void showConnectedComponents(){
        for(int i = 0; i < a.length; i++){
            System.out.print(i+ " - "+ a[i]+ "; ");
        }
    }
}

// 