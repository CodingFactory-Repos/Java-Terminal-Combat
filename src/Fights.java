public class Fights extends GlobalFunctions {
    public Fights(String[] playerData1, String[] playerData2) {
        // Initialize
        showTitle("Play");

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

                System.out.print("> Retour");
                scanner.nextLine();
                scanner.nextLine();
                showMenu();
            } else {
                if (Math.floor(playerTurns / 2) == (playerTurns / 2)) {
                    player2.damage(player1.getAttack());

                    

                    if(player2.getHealth() <= 0){
                        player2.setHealth(0);
                    }
                } else {
                    player1.damage(player2.getAttack());

                    if(player1.getHealth() <= 0){
                        player1.setHealth(0);
                    }
                }

                playerTurns++;
            }
        }
    }
}
