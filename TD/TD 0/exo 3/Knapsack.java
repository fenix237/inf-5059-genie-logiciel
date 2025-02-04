import java.util.*;


public class Knapsack {

    static class Result {
        int valeurMax;
        List<int[]> elements;

        Result(int valeurMax, List<int[]> elements) {
            this.valeurMax = valeurMax;
            this.elements = elements;
        }
    }

    public static Result knapsack(int[][] items, int poidsLimite) {
        int n = items.length;
        int[][] dp = new int[n + 1][poidsLimite + 1];

        for (int i = 1; i <= n; i++) {
            int valeur = items[i - 1][0];
            int poids = items[i - 1][1];
            for (int w = 0; w <= poidsLimite; w++) {
                if (poids <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - poids] + valeur);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        int valeurMax = dp[n][poidsLimite];
        List<int[]> elements = new ArrayList<>();

        for (int i = n, w = poidsLimite; i > 0 && valeurMax > 0; i--) {
            if (valeurMax != dp[i - 1][w]) {
                elements.add(items[i - 1]);
                valeurMax -= items[i - 1][0];
                w -= items[i - 1][1];
            }
        }

        return new Result(dp[n][poidsLimite], elements);
    }

    public static void main(String[] args) {

        int[][] items = {
                { 10, 4 },
                { 15, 5 },
                { 20, 6 },
                { 30, 3 }
        };
        int poidsLimite = 6;

        Result result = knapsack(items, poidsLimite);

        System.out.println("Valeur maximale : " + result.valeurMax);
        System.out.print("Éléments inclus : ");
        for (int[] item : result.elements) {
            System.out.print("[" + item[0] + ", " + item[1] + "] ");
        }
    }

}