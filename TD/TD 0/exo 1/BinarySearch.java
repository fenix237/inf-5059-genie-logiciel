
public class BinarySearch {

    public static int rechercheBinaire(int[] liste, int valeur) {
        int indice_debut = 0;
        int indice_fin = liste.length - 1;

        while (indice_debut <= indice_fin) {
            int mid = indice_debut + (indice_fin - indice_debut) / 2;
            if (liste[mid] == valeur) {
                return mid;
            }

            if (liste[mid] < valeur) {
                indice_debut = mid + 1;
            } else {

                indice_fin = mid - 1;
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

        int result = rechercheBinaire(tableauTrie, valeur);

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