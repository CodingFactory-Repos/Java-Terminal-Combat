public class Play extends GlobalFunctions {
    private String[] player1;
    private String[] player2;

    public void main() {
        if (listJson().size() < 2) {
            showTitle("Aie");
            System.out.println("Vous n'avez pas encore assez de personnages. Créons-en un !");
            System.out.println("");
            System.out.print("> Ok");

            scanner.nextLine();
            scanner.nextLine();

            showMenu();
        } else {
            fightPreparation();
        }
    }

    public void fightPreparation() {
        int returnId = 1;

        for (int i = 1; i <= 2; i++) {
            showTitle("Jouer");

            System.out.println("Choisissez votre personnage numero " + i);
            System.out.println("");

            for (int j = 0; j < listJson().size(); j++) {
                if (j == 0) {
                    System.out.print((j + 1) + ": " + listJson().get(j));
                } else {
                    System.out.print(" - " + (j + 1) + ": " + listJson().get(j));
                }
                returnId++;
            }

            System.out.println(" - " + returnId + " Retour\n");
            System.out.print("> ");

            int choice = scanner.nextInt();

            if (returnId == choice) {
                showMenu();
            } else {
                if ((choice - 1) < listJson().size()) {
                    setPlayer(i, (String) listJson().get(choice - 1));
                } else {
                    System.out.println("Vous avez sélectionné un personnage inexistant");
                }
            }
        }

        System.out.println("Les joueurs sont configurés ! " + player1[0] + " et " + player2[0]);

        new Fights(player1, player2);
    }

    public void setPlayer (int position, String information) {

        String temp = callJson(information);
        temp = temp.replace("[", "").replace("]", "");
        String[] stats = temp.split(", ");

        if(position == 1) {
            this.player1 = stats;
        } else if(position == 2) {
            this.player2 = stats;
        }

        return;
    }
}
