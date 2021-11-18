import java.util.*;

public class Characters extends GlobalFunctions {
    public void main() {
        // if(callJson() == null) {
        // System.out.println("Un fichier characters.json a été crée");
        // createJson("characters");
        // } else {
        // System.out.println("Le fichier characters.json existe déjà");
        // }

        if (listJson() == null) {
            System.out.println("Aucun personnage n'a été crée");
        } else {
            charactersList();
        }
    }

    public void charactersList() {
        // Initialize
        Scanner scanner = new Scanner(System.in);

        showTitle("MesCaracteres");

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
            characterSelected((String) listJson().get(choice));
        } else {
            System.out.println("Vous avez sélectionné un personnage inexistant");
        }
    }

    public void characterSelected(String name) {
        // Initialize
        Scanner scanner = new Scanner(System.in);

        showTitle(name);

        System.out.println("Vous avez sélectionné " + name);

        String temp = callJson(name);
        temp = temp.replace("[", "").replace("]", "");
        String[] stats = temp.split(", ");

        System.out.println("");

        System.out.println("Sa puissance d'attaque est de " + stats[0]);
        System.out.println("Sa vie est de " + stats[1]);
        System.out.println("Son initiative est de " + stats[2] + "\n");

        String[] menuArray = { "Modifier", "Supprimer", "Retour" };

        for (int i = 0; i < menuArray.length; i++) {
            System.out.println((i + 1) + ": " + menuArray[i]);
        }

        System.out.print("> ");

        switch (scanner.nextInt()) {
        case 1:
            // charactersModify(name);
            break;
        case 2:
            charactersDelete(name);
            break;
        case 3:
            charactersList();
            break;
        default:
            System.out.println("\n");
            System.out.println("Erreur");
            break;
        }
    }

    public void charactersDelete(String name) {
        // Initialize
        Scanner scanner = new Scanner(System.in);

        showTitle("Supprimer" + name);

        System.out.println("Vous allez supprimer " + name);
        System.out.println("Etes-vous sûr de vouloir continuer ?");
        System.out.println("1: Oui");
        System.out.println("2: Non");
        System.out.print("> ");

        switch (scanner.nextInt()) {
        case 1:
            deleteJson(name);
            charactersList();
            break;
        case 2:
            characterSelected(name);
            break;
        default:
            System.out.println("\n");
            System.out.println("Erreur");
            break;
        }
    }
}
