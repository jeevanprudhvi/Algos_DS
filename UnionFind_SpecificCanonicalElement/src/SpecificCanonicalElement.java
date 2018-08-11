import java.util.Scanner;

/**
 * Created by jstadiko on 2018-08-11.
 *
 */
public class SpecificCanonicalElement {
    private int a[], s[], large[];
    public SpecificCanonicalElement(int N) {
        a = new int[N];
        s = new int[N];
        large = new int[N];
        for(int i=0; i < N; i++){
            a[i] = i;
            s[i] = 1;
            large[i] = i;
        }
    }

    public int root(int x){
        int parentOfX = a[x];
        if(x == parentOfX) return x;
        return root(parentOfX);
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p , int q){
        int rootOfP = root(p);
        int rootOfQ = root(q);
        if(s[rootOfP]>=s[rootOfQ]){
            a[rootOfQ] = rootOfP;
            s[rootOfP] += s[rootOfQ];
            large[rootOfP] = (large[rootOfP] >= large[rootOfQ]) ? large[rootOfP] : large[rootOfQ];
        }
        else{
            a[rootOfP] = rootOfQ;
            s[rootOfQ] += s[rootOfP];
            large[rootOfQ] = (large[rootOfP] >= large[rootOfQ]) ? large[rootOfP] : large[rootOfQ];
        }
    }

    public void showConnectedComponents(){
        for(int i = 0; i < a.length; i++)
            System.out.print(i+ " - "+ a[i]+ "; ");
        System.out.println();
        for(int i = 0; i < a.length; i++)
            System.out.print(i+ " - "+ s[i]+ "; ");
        System.out.println();
//        for(int i = 0; i < a.length; i++)
//            System.out.print(i+ " - "+ large[i]+ "; ");
    }

    public int largeInConnectedCompContaining(int i){
        return large[root(i)];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N = 11  -- 0,1,2...9,10,11
        SpecificCanonicalElement sce = new SpecificCanonicalElement(N);
        // 0-5; 7-2; 7-10; 1-4; 7-1; 6-3; 5-6; 7-9; 5-8
        while(true){
            // enter a negative value to come out
            int p = sc.nextInt();
            int q = sc.nextInt();
            if(p<0 || q< 0) break;
            if(!sce.connected(p,q))
                sce.union(p,q);
            sce.showConnectedComponents();
        }
        int m = sce.largeInConnectedCompContaining(4);
        System.out.println("largest element in connected component containing 4 ::"+ m);
        m = sce.largeInConnectedCompContaining(0);
        System.out.println("largest element in connected component containing 0 ::"+ m);
    }
}
