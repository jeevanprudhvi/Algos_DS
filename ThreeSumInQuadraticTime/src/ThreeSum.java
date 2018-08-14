import java.util.Arrays;

/**
 * Created by jstadiko on 2018-08-14.
 */
public class ThreeSum {
    private int[] a = {-1,-10,10,-20,30,-9,19,4,5,6};
    public ThreeSum() {
    }
    public int findNoOfThreeSumSets(){
        int count =0;
        // step1 - Sort the array
        Arrays.sort(a);

        // step2
        for(int i=0; i< a.length; i++){
            int j = i+1;
            int k = a.length-1;
            while (j<k){
                int x = a[i];
                int y = a[j];
                int z = a[k];
                if(x+y+z == 0) {
                    ++count;
                    System.out.println(x + ", " + y + ", " + z);
                    --k; ++j;
                }
                else if(x+y+z > 0)
                    --k;
                else
                    ++j;
            }
        }
        return count;
    }
    public static void main(String[] args){
        ThreeSum obj = new ThreeSum();
        int count = obj.findNoOfThreeSumSets();
        System.out.println("No of Three sum sets ::"+ count);
    }
}
