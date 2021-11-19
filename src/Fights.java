public class Fights extends GlobalFunctions {
    public Fights(String[] playerData1, String[] playerData2) {
        // Initialize
        showTitle("Chargement");

        // Prepare Fight
        Player player1 = new Player(playerData1[0], playerData1[1], Double.parseDouble(playerData1[2]), Double.parseDouble(playerData1[3]), Double.parseDouble(playerData1[4]), Double.parseDouble(playerData1[5]));
        Player player2 = new Player(playerData2[0], playerData2[1], Double.parseDouble(playerData2[2]), Double.parseDouble(playerData2[3]), Double.parseDouble(playerData2[4]), Double.parseDouble(playerData2[5]));

        // Fight
        startFight(player1, player2);
    }

    private void startFight(Player player1, Player player2) {
        double playerTurns;
        String logs = "";

        if(player1.getInitiative() > player2.getInitiative()){
            playerTurns = 0;
        } else {
            playerTurns = 1;
        }

        boolean turns = true;

        while(turns) {
            if (player1.getHealth() <= 0 || player2.getHealth() <= 0) {
                turns = false;
                showTitle(player1.getHealth() <= 0 ? player1.getName()+"%20est%20KO%20!" : player2.getName() + "%20est%20KO%20!");

                System.out.println("Le combat est terminé en " + playerTurns + " tours, " + player1.getName() + " est a " + player1.getHealth() + " et le " + player2.getName() + " est a " + player2.getHealth());

                System.out.println("1: Voir les logs - 2: Retour");

                System.out.print("> ");
                scanner.nextLine();
                
                switch (scanner.nextLine()) {
                    case "1":
                        System.out.println(logs);

                        System.out.println("Appuyez sur enter pour retourner au menu");

                        System.out.print("> ");
                        scanner.nextLine();

                        showMenu();
                        break;
                    case "2":
                        showMenu();
                        break;
                    default:
                        break;
                }
            } else {
                double playerAttack;

                if (Math.floor(playerTurns / 2) == (playerTurns / 2)) {
                    playerAttack = player1.getAttack();

                    player2.damage(playerAttack);

                    if(player2.getHealth() <= 0){
                        player2.setHealth(0);
                    }

                    logs += "[Player 1 turn] " + player2.getName() + " 🥊 " + player1.getName() + " (-" + playerAttack + " ♥)\n";
                    logs += "[Player 1 turn] ♥ " + player2.getName() + ": " + player2.getHealth() + "\n\n";
                } else {
                    playerAttack = player2.getAttack();

                    player1.damage(playerAttack);

                    if(player1.getHealth() <= 0){
                        player1.setHealth(0);
                    }

                    logs += "[Player 2 turn] " + player1.getName() + " 🥊 " + player2.getName() + " (-" + playerAttack + " ♥)\n";
                    logs += "[Player 2 turn] ♥ " + player1.getName() + ": " + player1.getHealth() + "\n\n";
                }

                playerTurns++;
            }
        }
    }
}
