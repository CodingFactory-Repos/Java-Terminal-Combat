import java.util.*;

public class Characters extends GlobalFunctions {    
    public void main() {
        if (listJson().size() == 0) {
            charactersCreate(null);
        } else {
            charactersList();
        }
    }

    public void charactersList() {
        int returnId = 1;

        showTitle("Mes%20Personnage");

        System.out.println("Voici la liste de tous les personnages :");
        System.out.print("0: Créer un Personnage");
        for (int i = 0; i < listJson().size(); i++) {
            System.out.print(" - " + (i + 1) + ": " + listJson().get(i));
            returnId++;
        }

        System.out.println(" - " + returnId + " Retour");
        System.out.println("Quel personnage voulez-vous sélectionner ?");
        System.out.print("> ");

        int choice = scanner.nextInt();

        if (choice == 0) {
            charactersCreate(null);
        } else if(returnId == choice) {
            showMenu();
        } else {
            if ((choice - 1) < listJson().size()) {
                characterSelected((String) listJson().get(choice - 1));
            } else {
                System.out.println("Vous avez sélectionné un personnage inexistant");
            }
        }
    }

    public void characterSelected(String name) {


        showTitle(name);

        System.out.println("Vous avez sélectionné " + name);

        String temp = callJson(name);
        temp = temp.replace("[", "").replace("]", "");
        String[] stats = temp.split(", ");

        System.out.println("");

        System.out.println("Il appartient a la classe de " + stats[0]);
        System.out.println("Sa puissance d'attaque est de " + stats[1]);
        System.out.println("Sa vie est de " + stats[2]);
        System.out.println("Son initiative est de " + stats[3] + "\n");

        String[] menuArray = { "Modifier", "Supprimer", "Retour" };

        for (int i = 0; i < menuArray.length; i++) {
            System.out.println((i + 1) + ": " + menuArray[i]);
        }

        System.out.print("> ");

        switch (scanner.nextInt()) {
        case 1:
            characterModify(name);
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

    public void characterModify(String name) {


        showTitle("Modifier%20" + name);

        System.out.println("Vous allez modifier " + name);
        System.out.println("Êtes-vous sûr de vouloir continuer ?");
        System.out.println("1: Oui");
        System.out.println("2: Non");
        System.out.print("> ");

        switch (scanner.nextInt()) {
        case 1:
            deleteJson(name);
            charactersCreate(name);
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

    private void charactersCreate(String defineName) {
        String name;
        String className;
        Double attack;
        double health;
        double initiative;

        System.out.println(defineName);

        if (defineName == null) {
            showTitle("Créer%20un%20personnage");

            System.out.println("Quel est le nom de votre personnage ?");
            System.out.print("> ");

            scanner.nextLine();
            name = scanner.nextLine();
        } else {
            name = defineName;
        }

        showTitle("Classes");
        System.out.println("Quel est classe de votre personnage ?");
        String[] classArrays = { "Guerrier", "Magicien", "Voleurs", "Par default" };
        for (int i = 0; i < classArrays.length; i++) {
            System.out.println((i + 1) + ": " + classArrays[i]);
        }
        System.out.print("> ");

        className = classArrays[scanner.nextInt() - 1];

        showTitle("L'attaque");
        System.out.println("Quel est la puissance d'attaque de votre personnage ?");
        System.out.print("> ");

        attack = scanner.nextDouble();

        showTitle("La%20Vie");
        System.out.println("Quel est la vie de votre personnage ?");
        System.out.print("> ");

        health = scanner.nextDouble();

        showTitle("L'initiative");
        System.out.println("Quel est l'initiative de votre personnage ?");
        System.out.print("> ");

        initiative = scanner.nextDouble();

        System.out.println(name + " " + className + " " + attack + " " + health + " " + initiative);

        if (className == "Guerrier") {
            showTitle("Le%20bouclier");
            System.out.println("Quel est la puissance de protection du bouclier ?");
            System.out.print("> ");

            createJson(name, className, attack, health, initiative, scanner.nextDouble());
        } else if(className == "Magicien"){
            showTitle("La%20Magie");
            System.out.println("Quel est le niveau de la magie de votre personnage ?");
            System.out.print("> ");

            createJson(name, className, attack, health, initiative, scanner.nextDouble());
        } else {
            createJson(name, className, attack, health, initiative, 0.0);
        }

        charactersList();
    }

    public void charactersDelete(String name) {


        showTitle("Supprimer%20" + name);

        System.out.println("Vous allez supprimer " + name);
        System.out.println("Êtes-vous sûr de vouloir continuer ?");
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
