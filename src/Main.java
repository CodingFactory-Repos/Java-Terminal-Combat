import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        System.out.println("1 : Menu");
        System.out.println("2 : Jouer");
        System.out.println("3 : Option");
        System.out.println("4 : Quitter");
        Scanner sc = new Scanner(System.in);
        String jouer = sc.nextLine();
        int menu = sc.nextInt();
        System.out.println(""+" " +jouer+" "+" "+" "+ menu);

        Player player1 = new Player("Guerrier1", 20.0, 300.0);
        System.out.println ("name :"+player1.getName());
        player1.setAttack(30);
        System.out.println ("vie: "+player1.getHealth()) ;

        Player player2 = new Player ("Guerrier2", 30., 150.0);
        player2.setName("Guerrier2");
        player2.damage(player1.getAttack());
        System.out.println("puissance d'attaque:"+player2.getAttack());

        System.out.println (player1.getAttack());
    }
}
