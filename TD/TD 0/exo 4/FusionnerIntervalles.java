import java.util.*;


public class FusionnerIntervalles {

    public static int[][] fusionnerIntervalles(int[][] intervalles) {

        Arrays.sort(intervalles, Comparator.comparingInt(a -> a[0]));

        List<int[]> fusionnes = new ArrayList<>();
        int[] dernierIntervalle = intervalles[0];

        for (int i = 1; i < intervalles.length; i++) {
            int[] intervalleCourant = intervalles[i];

            if (dernierIntervalle[1] >= intervalleCourant[0]) {

                dernierIntervalle[1] = Math.max(dernierIntervalle[1], intervalleCourant[1]);
            } else {

                fusionnes.add(dernierIntervalle);
                dernierIntervalle = intervalleCourant;
            }
        }

        fusionnes.add(dernierIntervalle);

        return fusionnes.toArray(new int[fusionnes.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervallesTest = {
                { 1, 3 },
                { 2, 4 },
                { 5, 7 },
                { 6, 8 },
                { 9, 10 },
                { 10, 14 },
                { 8, 9 }
        };

        int[][] resultats = fusionnerIntervalles(intervallesTest);

        System.out.println("Intervalles fusionnés :");
        for (int[] intervalle : resultats) {
            System.out.println(Arrays.toString(intervalle));
        }
    }
}