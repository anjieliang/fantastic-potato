import java.util.Arrays;

/**
 * Created by anjieliang on 9/8/15.
 */
public class patient_zero {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {2, 3, 4}, {3, 2, 1}};
        printArray(answer(matrix, 0, 0, 2));
        int[][] matrix2 = {{6, 7, 2, 7, 6}, {6, 3, 1, 4, 7}, {0, 2, 4, 1, 10}, {8, 1, 1, 4, 9}, {8, 7, 4, 9, 9}};
        printArray(answer(matrix2, 2, 1, 5));
    }

    static int[][] answer(int[][] population, int x, int y, int strength) {
        if (population[y][x] > strength) {
            return population;
        }

        int[][] infected = new int[population.length][population[0].length];

        for (int i = 0; i < infected.length; i++) {
            for (int j = 0; j < infected[0].length; j++) {
                infected[i][j] = population[i][j];
            }
        }

        population = recur(infected, population, x, y, strength);

        return population;
    }

    static int[][] recur(int[][] infected, int[][] population, int x, int y, int strength) {
        if (y >= 0 && y < population.length && x >= 0 && x < population[y].length && infected[y][x] != -1) {
            infected[y][x] = -1;
            if (population[y][x] != -1 && population[y][x] <= strength) {
                population[y][x] = -1;
                recur(infected, population, x + 1, y, strength);
                recur(infected, population, x - 1, y, strength);
                recur(infected, population, x, y + 1, strength);
                recur(infected, population, x, y - 1, strength);
            }
        }

        return population;
    }

    static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
