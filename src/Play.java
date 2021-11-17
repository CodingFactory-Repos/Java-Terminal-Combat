import jdk.swing.interop.SwingInterOpUtils;

public class Play {
    public void main() {
        Player player1 = new Player("Axel ", 30.0, 300.0, 35);
        Player player2 = new Player("Louis", 30, 150.0, 60);

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
            } else {
                if (Math.floor(playerTurns / 2) == (playerTurns / 2)) {
                    player2.damage(player1.getAttack());
                    System.out.println(" le " + player1.getName() + " reçois l'attaque de" + player2.getName());
                    System.out.println("-" + player2.getAttack());
                    System.out.println("la vie de " + player2.getName() + " est de" + player2.getHealth());
                } else {
                    player1.damage(player2.getAttack());
                    System.out.println("la vie de " + player1.getName() + " est de" + player1.getHealth());
                    System.out.println(player2.getName() + " reçois l'attaque de" + player1.getName());
                    System.out.println("-" + player1.getAttack());
                }

                if(player1.getHealth()<= 0){
                    System.out.println(player2.getName()+"à gagné");
                }
                if(player2.getHealth()<= 0){
                    System.out.println(player1.getName()+"à gagné");
                }


                playerTurns++;

            }
        }


    }
}
