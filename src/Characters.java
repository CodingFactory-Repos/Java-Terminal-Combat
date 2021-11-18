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

        int createId = 1;

        showTitle("Mes%20Caracteres");

        System.out.println("Voici la liste de tous les personnages :");
        System.out.print("0: Retour");
        for (int i = 0; i < listJson().size(); i++) {
            System.out.print(" - " + (i + 1) + ": " + listJson().get(i));
            createId++;
        }

        System.out.println(" - " + createId + " Créer un caractère");
        System.out.println("Quel personnage voulez-vous sélectionner ?");
        System.out.print("> ");

        int choice = scanner.nextInt();

        if (choice == 0) {
            showMenu();
        } else if(createId == choice) {
            charactersCreate(null);
        } else {
            if ((choice - 1) < listJson().size()) {
                characterSelected((String) listJson().get(choice - 1));
            } else {
                System.out.println("Vous avez sélectionné un personnage inexistant");
            }
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
        // Initialize
        Scanner scanner = new Scanner(System.in);

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
        // Initialize
        Scanner scanner = new Scanner(System.in);

        String name;
        String className;
        Double attack;
        double health;
        double initiative;

        if (defineName != null) {
            name = defineName;
        } else {
            showTitle("Créer%20un%20personnage");

            System.out.println("Quel est le nom de votre personnage ?");
            System.out.print("> ");

            name = scanner.nextLine();
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

            createJson(name, className, attack, health, initiative, scanner.nextDouble(), 0.0);
        } else if(className == "Magicien"){
            showTitle("La%20Magie");
            System.out.println("Quel est le niveau de la magie de votre personnage ?");
            System.out.print("> ");

            double magic = scanner.nextDouble();

            showTitle("L'attaque%20de%20la%20magie");
            System.out.println("Quel est le niveau de l'attaque de la magie de votre personnage ?");
            System.out.print("> ");

            double attack_magic = scanner.nextDouble();

            createJson(name, className, attack, health, initiative, magic, attack_magic);
        } else {
            createJson(name, className, attack, health, initiative, 0.0, 0.0);
        }

        charactersList();
    }

    public void charactersDelete(String name) {
        // Initialize
        Scanner scanner = new Scanner(System.in);

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
