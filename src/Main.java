import java.util.Scanner;

class Main extends GlobalFunctions{

    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.println("Chargement...");

        // Initialize
        Scanner scanner = new Scanner(System.in);
        Play play = new Play();
        Characters characters = new Characters();

        // Clear console output
        System.out.print("\033[H\033[2J");

        showTitle("TerminalCombat");

        String[] menuArray = {"Jouer", "Caractères", "Quitter"};

        for(int i=0; i<menuArray.length; i++){
            System.out.println((i + 1) + ": " + menuArray[i]);
        }

        System.out.print("> ");

        switch (scanner.nextInt()) {
            case 1:
                System.out.println("\n");
                play.main(); 
                break;
            case 2:
                System.out.println("\n");
                characters.main(); 
                break;
            case 3:
                System.out.print("\033[H\033[2J");
                System.exit(0);
                break;
            default:
                System.out.println("\n");
                System.out.println("Erreur");
                break;
        }

    //     
    }
}
