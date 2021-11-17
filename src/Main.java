class Main {

    public static void main(String[] args) {
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
