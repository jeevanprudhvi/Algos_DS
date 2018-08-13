import java.util.Arrays;

/**
 * Created by jstadiko on 2018-08-13.
 * Find number of sets which can produce sum = 0
 * Design an algorithm for the 3-SUM problem that takes time proportional to n^2 in the worst case.
 * Time Complexity:
 * Sorting nlogn
 * 2 for loops n^2  *  BinarySearch logn
 * TimeComplexity  O(n^2logn+nlogn)
 */
public class ThreeSum {
    private int[] a = {-1,-10,10,-20,30,-9,19,4,5,6};
    private int[] b;
    public ThreeSum() {
    }

    public int find(int x, int low, int high, int ignoreCaseValue){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(a[mid] == x && a[mid] != ignoreCaseValue){
                return mid;
            }
            else if(a[mid]>x)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }

    public int findNoOfThreeSumSets(){
        int count = 0;
        // Step1 :: Sort the array
        Arrays.sort(a);
        // Step2 :: For all possible pairs perform a binary search with -(pair sum)
        for(int i=0; i < a.length; i++){
            for(int j=i+1; j < a.length; j++){
                int x = -(a[i]+a[j]);
                int index = this.find(x, j, a.length, a[j]);
                if(index != -1){
                    ++count;
                    System.out.println(a[i]+ ", "+a[j]+", "+x);
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        ThreeSum obj = new ThreeSum();
        int count = obj.findNoOfThreeSumSets();
        System.out.println("No of threesum sets ::"+ count);
    }
}
