/**
 * Created by anjieliang on 4/7/16.
 */
import java.awt.*;
import java.util.*;

public class Viral {

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static long count;
    public static void main(String[] args ){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int a = 0; a < t; a++) {
            int sr = scan.nextInt();
            int sc = scan.nextInt();
            int r = scan.nextInt();
            int c = scan.nextInt();

            long[][] teens = new long[r][c];
            long[][] adults = new long[r][c];
            long[][] old = new long[r][c];

            for (int i = 0; i < r; i++ ){
                for (int j = 0; j < c; j++) {
                    teens[i][j] = scan.nextInt();
                }
            }
            count = 0;
            String ans = "";
            search(new Point(sr,sc), teens);
            ans += count + " ";
            for (int i = 0; i < r; i++ ){
                for (int j = 0; j < c; j++) {
                    adults[i][j] = scan.nextInt();
                }
            }
            count = 0;

            search(new Point(sr,sc), adults);
            ans += count + " ";
            for (int i = 0; i < r; i++ ){
                for (int j = 0; j < c; j++) {
                    old[i][j] = scan.nextInt();
                }
            }
            count = 0;

            search(new Point(sr,sc), old);
            ans += count;
            System.out.println(ans);
        }
    }

    public static void search(Point start, long[][] grid) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(start);
        Point curr = null;
        while(!queue.isEmpty()) {
            curr = queue.remove();
            int row = curr.x;
            int col = curr.y;
            if (grid[row][col] == 0) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dx[i];
                int nextCol = col + dy[i];

                if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length &&
                        (grid[nextRow][nextCol] != -1) && (grid[nextRow][nextCol] != 0)) {
                    Point neighbor = new Point(nextRow, nextCol);
                    count += grid[nextRow][nextCol];
                    grid[nextRow][nextCol] = -1;
                    queue.add(neighbor);
                }
            }
        }
    }
}
