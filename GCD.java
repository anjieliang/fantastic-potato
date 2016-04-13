/**
 * Created by anjieliang on 4/12/16.
 */
import java.util.*;

public class GCD {

    static int[] tree;
    static int[] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int a = 0; a < t; a++) {
            int n = scan.nextInt();
            int q = scan.nextInt();
            arr = new int[n];
            tree = new int[n*2];

            for (int i = 0;  i < n; i++) {
                arr[i] = scan.nextInt();
            }
            build(0,n-1,0);
            for (int i = 0; i < q; i++) {
                System.out.println(get(0, n-1, scan.nextInt(),
                        scan.nextInt(), 0));
            }
        }
    }

    static int build(int start, int end, int idx) {
        if (start == end) {
            tree[idx] = arr[start];
            return arr[start];
        }

        int mid = start + (end - start) / 2;
        tree[idx] = gcd(build(start, mid, idx * 2 + 1),
                build(mid + 1, end, idx * 2 + 2 ));
        return tree[idx];
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;

        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }

        return a;
    }

    static int get(int ts, int te, int qs, int qe, int idx) {
        if (qs <= ts && qe >= te) {
            return tree[idx];
        }
        if (te < qs || ts > qe) {
            return 0;
        }

        int mid = ts + (te - ts) / 2;
        return gcd(get(ts, mid, qs, qe, idx * 2 + 1),
                get(mid + 1, te, qs, qe, idx * 2 + 2));
    }
}


