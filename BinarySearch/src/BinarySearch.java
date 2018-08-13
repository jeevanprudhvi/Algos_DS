/**
 * Created by jstadiko on 2018-08-13.
 * BinarySearch
 * Time Complexity log(n)
 * 2^f(n) = n  =>  f(n) = log(n)
 */
public class BinarySearch {
    private int[]a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    public BinarySearch() {
    }
    public int find(int x){
        int high = a.length;
        int low = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(a[mid] == x){
                return mid;
            }
            else if(a[mid]>x)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
    public static void main(String[] args){
        BinarySearch bs = new BinarySearch();
        int index = bs.find(13);
        System.out.println("Element is found at index :"+index);
    }
}
