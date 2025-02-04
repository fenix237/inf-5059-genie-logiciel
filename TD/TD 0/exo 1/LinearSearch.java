

public class LinearSearch {

    static int rechercheLineaire(int[] liste, int e) {

        for (int i = 0; i < liste.length; i++) {
            if (e == liste[i]) {

                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] tableauTrie = { 
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50
        };
        int valeur = 49;

        long startTime = System.nanoTime();

        int result = rechercheLineaire(tableauTrie, valeur);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        if (result != -1) {
            System.out.println("Élément trouvé à l'index : " + result);
        } else {
            System.out.println("Élément non trouvé dans le tableau.");
        }

        System.out.printf("Temps d'exécution : %d nanosecondes%n", duration);
    }
}