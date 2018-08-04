import java.util.Scanner;

/**
 * Created by jstadiko on 2018-08-01.
 */
public class UnionFindClient {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int N = scanner.nextInt();
        QuickFindUF uf = new QuickFindUF(N);
        while(true){
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if(uf.connected(p,q)){
                System.out.println(p+" and "+q+" are already connected..!");
                continue;
            }
            else
                uf.union(p,q);

            System.out.println("==============================");
            System.out.println("Connected components ::");
            uf.showConnectedComponents();
        }
    }
}
