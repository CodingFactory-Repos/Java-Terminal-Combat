public class Play extends GlobalFunctions {
    public void main() {
        // Initialize
        // Scanner scanner = new Scanner(System.in);

        // Object[] player1Datas = playersSelector(1);
        // Object[] player2Datas = playersSelector(2);

        showTitle("Play");

        // Initialize
        Player player1 = new Player("Axel ", 120, 300.0, 9);
        Player player2 = new Player("Louis", 35 , 100, 4);

        double playerTurns;

        if(player1.getInitiative() > player2.getInitiative()){
            playerTurns = 0;
        } else {
            playerTurns = 1;
        }

        boolean turns = true;

        while(turns) {
            if (player1.getHealth() <= 0 || player2.getHealth() <= 0) {
                turns = false;
                System.out.println("Le combat est terminé en " + playerTurns + " tours, " + player1.getName() + " est a " + player1.getHealth() + " et le " + player2.getName() + " est a " + player2.getHealth());

                //player1.getHealth() <= 0 ? System.out.println(player1.getName()+" est mort, donc il est perdant") : System.out.println(player1.getName()+" est vivant, donc il est gagnant");
               // player2.getHealth() <= 0 ? System.out.println(player2.getName()+" est mort, donc il est perdant") : System.out.println(player2.getName()+" est vivant, donc il est gagnant");
            } else {
                if (Math.floor(playerTurns / 2) == (playerTurns / 2)) {
                    player2.damage(player1.getAttack());
                    System.out.println(player2.getName() + " reçois l'attaque de " + player1.getName());
                    System.out.println("-" + player2.getAttack());
                    System.out.println("La vie de " + player2.getName() + " est de " + player2.getHealth());
                } else {
                    player1.damage(player2.getAttack());
                    System.out.println(player1.getName() + " reçois l'attaque de " + player2.getName());
                    System.out.println("-" + player1.getAttack());
                    System.out.println("la vie de " + player1.getName() + " est de " + player1.getHealth());
                }

                playerTurns++;
            }
        }
    }

    

    // public String[] playersSelector(int playerNumber) {
    //     String[] player = new String[4];
    //     Scanner scanner = new Scanner(System.in);

    //     showTitle();
    //     System.out.println("Quel est le nom du joueur " + playerNumber + " ?");
    //     System.out.print("> ");
    //     player[0] = scanner.nextLine();

    //     showTitle();
    //     System.out.println("Quel est l'attaque du joueur " + playerNumber + " ?");
    //     System.out.print("> ");
    //     player[1] = scanner.nextLine();

    //     showTitle();
    //     System.out.println("Quel est la santé du joueur " + playerNumber + " ?");
    //     System.out.print("> ");
    //     player[2] = scanner.nextLine();

    //     showTitle();
    //     System.out.println("Quel est l'initiative du joueur " + playerNumber + " ?");
    //     System.out.print("> ");
    //     player[3] = scanner.nextLine();

    //     return player;
    // }
}
