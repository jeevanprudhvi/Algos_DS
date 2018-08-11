import java.util.Scanner;

/**
 * Created by jstadiko on 2018-08-11.
 * Social network connectivity.
 * Given a social network containing n members and
 * a log file containing m timestamps at which times pairs of members formed friendships,
 * design an algorithm to determine the earliest time at which all members are connected
 * (i.e., every member is a friend of a friend of a friend ... of a friend).
 * Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
 * The running time of your algorithm should be mlogn or better and use extra space proportional to n.
 */
public class SocialNetworkConnectivity {
    private int a[], s[], count ;
    public SocialNetworkConnectivity(int N) {
        a = new int[N];
        s = new int[N];
        count = N;
        for(int i=0; i < N; i++){
            a[i] = i;
            s[i] = 1;
        }
    }
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public int root(int x){
        int parentOfX = a[x];
        if(parentOfX == x) return x;
        a[x] = a[parentOfX];
        return root(parentOfX);
    }

    public void union(int p, int q){
        int rootOfP = root(p);
        int rootOfQ = root(q);
        if(s[rootOfP] <= s[rootOfQ]){
            a[rootOfP] = rootOfQ;
            s[rootOfQ] += s[rootOfP];
        }
        else{
            a[rootOfQ] = rootOfP;
            s[rootOfP] += s[rootOfQ];
        }
        --count;
    }

    public boolean allAreConnected(){
        return count == 1;
    }
    public void showConnectedComponents(){
        for(int i = 0; i < a.length; i++)
            System.out.print(i+ " - "+ a[i]+ "; ");
        System.out.println();
        for(int i = 0; i < a.length; i++)
            System.out.print(i+ " - "+ s[i]+ "; ");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SocialNetworkConnectivity snc = new SocialNetworkConnectivity(N);
        while(true){
            int p = sc.nextInt();
            int q = sc.nextInt();
            if(!snc.connected(p,q)) {
                snc.union(p,q);
                snc.showConnectedComponents();
                if(snc.allAreConnected()){
                    System.out.println("All friends are connected..!");
                    break;
                }
            }
        }
    }
}
