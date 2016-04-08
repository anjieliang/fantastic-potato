import java.util.*;

/**
 * Created by anjieliang on 4/7/16.
 */
public class HipAd {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int a = 0; a < t; a++) {
            int tags = scan.nextInt();
            int good = scan.nextInt();
            int bad = scan.nextInt();

            String[] phrases = new String[tags];
            String[] goods = new String[good];
            String[] bads = new String[bad];

            scan.nextLine();

            int max = Integer.MIN_VALUE;
            String maxphrase = "";

            for (int i = 0; i < tags; i++) {
                phrases[i] = scan.nextLine();
            }
            for (int i = 0; i < good; i++) {
                goods[i] = scan.nextLine().toLowerCase();
            }
            for (int i = 0; i < bad; i++) {
                bads[i] = scan.nextLine().toLowerCase();
            }

            for (int i = 0; i < tags; i++) {
                int curr = 0;
                for (int j = 0; j < goods.length; j++) {
                    if (phrases[i].toLowerCase().indexOf(goods[j]) >= 0) {
                        curr++;
                    }
                }
                for (int j = 0; j < bads.length; j++) {
                    if (phrases[i].toLowerCase().indexOf(bads[j]) >= 0) {
                        curr--;
                    }
                }
                if (curr > max) {
                    max = curr;
                    maxphrase = phrases[i];
                }
            }

            System.out.println(maxphrase);
        }
    }

}