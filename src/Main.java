import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.println("Chargement...");

        // Initialize
        Scanner scanner = new Scanner(System.in);

        // Clear console output
        System.out.print("\033[H\033[2J");

        String[] titleArray = {"  _______                  _             _    _____                _           _   ", "|__   __|                (_)           | |  / ____|              | |         | |  ", "   | | ___ _ __ _ __ ___  _ _ __   __ _| | | |     ___  _ __ ___ | |__   __ _| |_ ", "   | |/ _ \\ '__| '_ ` _ \\| | '_ \\ / _` | | | |    / _ \\| '_ ` _ \\| '_ \\ / _` | __|", "   | |  __/ |  | | | | | | | | | | | (_| | | | |___| (_) | | | | | | |_) | (_| | | ", "   |_|\\___|_|  |_| |_| |_|_|_| |_|\\__,_|_|  \\_____\\___/|_| |_| |_|_.__/ \\__,_|\\_, | ", ""};

        for (String title : titleArray) {
            System.out.println(title);
        }

        String[] menuArray = {"Jouer", "Option", "Quitter"};

        for(int i=0; i<menuArray.length; i++){
            System.out.println((i + 1) + ": " + menuArray[i]);
        }

        System.out.print("> ");

        switch (scanner.nextInt()) {
            case 1:
                System.out.println("\n");
                Play play = new Play();
                play.main(); 
                break;
            case 2:
                System.out.println("\n");
                Options options = new Options();
                options.main(); 
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
