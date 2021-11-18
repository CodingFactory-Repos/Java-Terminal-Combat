import java.util.*;

public class Characters extends GlobalFunctions {
    public void main() {
        // Initialize
        Scanner scanner = new Scanner(System.in);

        showTitle("Caracteres");

        // if(callJson() == null) {
        // System.out.println("Un fichier characters.json a été crée");
        // createJson("characters");
        // } else {
        // System.out.println("Le fichier characters.json existe déjà");
        // }

        if (listJson() == null) {
            System.out.println("Aucun personnage n'a été crée");
        } else {
            System.out.println("Voici la liste de tous les personnages :");
            for (int i = 0; i < listJson().size(); i++) {
                if (i == 0) {
                    System.out.print(i + ": " + listJson().get(i));
                } else {
                    System.out.print(" - " + i + ": " + listJson().get(i));
                }
            }

            System.out.println("");
            System.out.println("Quel personnage voulez-vous sélectionner ?");
            System.out.print("> ");

            int choice = scanner.nextInt();

            if (choice < listJson().size()) {
                showTitle((String) listJson().get(choice));

                System.out.println("Vous avez sélectionné " + listJson().get(choice));

                String temp = callJson((String) listJson().get(choice));
                temp = temp.replace("[", "").replace("]", "");
                String[] stats = temp.split(", ");
                
                System.out.println("");

                System.out.println("Sa puissance d'attaque est de " + stats[0]);
                System.out.println("Sa vie est de " + stats[1]);
                System.out.println("Son initiative est de " + stats[2]);
                
            } else {
                System.out.println("Vous avez sélectionné un personnage inexistant");
            }
        }
    }
}
