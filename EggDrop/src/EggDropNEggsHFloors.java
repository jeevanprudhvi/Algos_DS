import java.util.Scanner;

/**
 * Created by jstadiko on 2018-08-21.
 */
public class EggDropNEggsHFloors {
    static int a = 1;
    public EggDropNEggsHFloors() {
    }
    public static int max(int x, int y){
        return x>y ? x : y;
    }
    public static  int min(int x, int y){
        return x<y ? x: y;
    }
    public static int findDrops(int N, int H){
        System.out.println(a++);
        if(N == 1 || H ==1 || H == 0) return H;
        int drops = Integer.MAX_VALUE;
        for(int i = 1; i <= H ; i++){
            drops = min(1+ max(findDrops(N, H-i), findDrops(N-1,i-1)), drops);
        }
        return drops;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of eggs :: ");
        int N = sc.nextInt();
        System.out.println("Enter no of floors :: ");
        int H = sc.nextInt();
        int drops = findDrops(N, H);
        System.out.println("Minimum drops required "+ drops);
    }
}
