import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jstadiko on 2018-08-29.
 */
public class BigSorting {
    public BigSorting() {
    }
    // Complete the bigSorting function below.
    static String[] sort(String[] unsorted) {
        Arrays.sort(unsorted, (String a, String b) -> {
            if(a.length()>b.length()) return 1;
            else if(a.length()<b.length()) return -1;
            return a.compareTo(b);
        });
        return unsorted;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.next();
            unsorted[i] = unsortedItem;
        }

        String[] result = sort(unsorted);
        System.out.print(Arrays.toString(result));
        for(int i=0; i< n; i++)
            System.out.println(unsorted[i]);
        scanner.close();
    }
}
