class Main extends GlobalFunctions {
    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.println("Chargement...");

        showMenu();

        // while (true) {
        //     try {
        //         showMenu();
        //     } catch (Exception e) {
        //         System.out.println("Erreur : Une erreur c'est produite (" + e.getMessage() + ")");
        //     }
        // }
    }
}
