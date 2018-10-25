import java.util.Scanner;

/**
 * Created by jstadiko on 2018-10-17.
 */
public class SortUtils {
    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }
    public static boolean greater(Comparable a, Comparable b){
        return a.compareTo(b) > 0;
    }
    public static void swap(Comparable[] elements, int i, int j){
        Comparable temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
    public static void selectionSort(Comparable[] elements){
        for(int i=0; i< elements.length; i++){
            for(int j=i+1; j<elements.length; j++){
                if(greater(elements[i],elements[j]))
                    swap(elements, i, j);
            }
        }
    }
    public static void insertionSort(Comparable[] elements){
        for(int i=0; i< elements.length; i++){
            for(int j=i; j>0; j--){
                if(less(elements[j],elements[j-1]))
                    swap(elements, j, j-1);
                else
                    break;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String exp = sc.next(); // 12 5 13 2 17 25 22 55 32 27
        exp = "12 5 13 2 17 25 22 55 32 27";
        String[] elems = exp.split(" ");
        Integer[] items = new Integer[elems.length];
        for(int i=0; i< elems.length; i++)
            items[i] = Integer.parseInt(elems[i]);
//        selectionSort(items);
        insertionSort(items);
        for(int i=0; i<items.length; i++)
            System.out.print(items[i]+" ");
    }
}
