/**
 * Created by jstadiko on 2018-08-14.
 * Recursive BinarySearch
 */
public class BitonicPoint {
    public BitonicPoint() {
    }
    public static int binarySearch(int a[], int l, int r){
        if (l<=r){
            int mid = (l+r)/2;
            if(a[mid]>a[mid-1] && a[mid]>a[mid+1])
                return  a[mid];
            else if(a[mid]<a[mid-1])
                return binarySearch(a,l, mid-1);
            else
                return binarySearch(a, mid+1, r);
        }
        return -1;
    }
    public static void main(String[] args){
        int[] a = {-14,-8, -3, -1, 3,5,7,12,15,17,16,9,4,1,-2,-9,-13,-16};
        int bitonicPoint = BitonicPoint.binarySearch(a, 0, a.length);
        System.out.println("Bitonic Point ::"+ bitonicPoint);
    }
}
