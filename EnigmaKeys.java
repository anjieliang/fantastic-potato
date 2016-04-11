/**
 * Created by anjieliang on 4/7/16.
 */
import java.util.*;

public class EnigmaKeys {
    static int[] dp;
    static int types;
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int a = 0; a < t; a++) {
            int n = scan.nextInt();
            int[] nums = new int[n];
            dp = new int[n];
            types = 1;
            for (int i = 0; i < n; i++)  {
                nums[i] = scan.nextInt();
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] != 0) {
                    count++;
                }
            }
            System.out.println(count + " " + dp[count - 1]);
        }
    }

    static void lis(int grid[], int size)
    {
        for (int i = 1; i < grid.length; i++) {
            dp [i] = 1;
            for (int j = 1; j < i - 1; j++) {
                if (grid[j] < grid[i]) {
                    dp[i] = dp[i] + dp[j];
                }
            }
        }
    }

    static int search(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }

        return r;
    }
}
