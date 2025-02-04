public class Kadane {

    public static int[] sousTableauMaximal(int[] tableau) {
        int sommeActuelle = 0;
        int sommeMax = Integer.MIN_VALUE; 
        int debut = 0, fin = 0; 
        int tempDebut = 0; 

        for (int i = 0; i < tableau.length; i++) {
            sommeActuelle += tableau[i];

           
            if (sommeActuelle > sommeMax) {
                sommeMax = sommeActuelle;
                debut = tempDebut; 
                fin = i; 
            }

           
            if (sommeActuelle < 0) {
                sommeActuelle = 0;
                tempDebut = i + 1; 
            }
        }

      
        

        return java.util.Arrays.copyOfRange(tableau, debut, fin + 1);
    }

    public static void main(String[] args) {
       
        int[][] ensembleTableaux = {
            {1, -2, 3, 4, -1, 2, 1, -5, 4}, 
            {-4, -3, -6, -7},           
            {2, 3, -2, 5, -1, 6},           
            {5, 4, -1, 7, -8},              
            {-1, -2, -3, -5}                
        };

        for (int[] tableau : ensembleTableaux) {
            int[] sousTableauMax = sousTableauMaximal(tableau);
          
            int sommeMax = 0;
            for (int num : sousTableauMax) {
                sommeMax += num;
            }
            System.out.println("Sous-tableau avec la somme maximale : " + java.util.Arrays.toString(sousTableauMax) + 
                               " avec une somme maximale de : " + sommeMax);
        }
    }
}