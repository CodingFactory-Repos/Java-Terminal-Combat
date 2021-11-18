import java.io.*;
import java.net.*;
import java.net.http.*;
import java.util.*;

public class GlobalFunctions {
    public static void showTitle(String text) {
        System.out.print("\033[H\033[2J");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://artii.herokuapp.com/make?text=" + text))
                .method("GET", HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String callJson(String name) {
        try {
            FileReader fis = new FileReader("./data/characters/" + name + ".json");

            int charCode;
            String result = "";
            while((charCode = fis.read()) != -1) {
                result += (char) charCode;
            }

            return result;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public static boolean createJson(String name) {
        //Write JSON file
        try (FileWriter file = new FileWriter("./data/" + name + ".json")) {

            file.write("{\"" + name + "\": []}"); 
            file.flush();

            return true;
 
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList listJson() {
        File repertoire = new File("./data/characters/");
        ArrayList aList = new ArrayList();

        String liste[] = repertoire.list();  
 
        if (liste != null) {         
            for (int i = 0; i < liste.length; i++) {
                aList.add(liste[i].replace(".json", ""));
            }

            return aList;
        } else {
            return null;
        }
    }

    public static boolean deleteJson(String name) {
        File file = new File("./data/characters/" + name + ".json");
        
        return file.delete();
    }

    public static void showMenu() {
        // Initialize
        Scanner scanner = new Scanner(System.in);
        Play play = new Play();
        Characters characters = new Characters();
        
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
    }
}
