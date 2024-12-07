import java.util.Random;
import java.util.Scanner;

public class Stage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Insert a coin to start (input 1): ");
        int coin = scanner.nextInt();

        System.out.println("Stage 1 (Gomphan, Tronphan, Jigglykrach, Delibot, Feroongus).\n"
        		+ "Stage 2 (Hariynamo, Misdremena, Hydraugon, Skulkarona, Vulcaroboth). \n"
        		+ "Stage 3 (Pikachu, Geigaton, Tyrameka, Scylamence, Garadiant) ");
        System.out.println("Select Which Stage Do you Want to Battle: 1,2,3 ");
        int scenarioNumber = scanner.nextInt();

        switch (scenarioNumber) {
            case 1:
                System.out.println("Scenario 1: " + simulateEvent(new String[]{"Gomphan", "Tronphan", "Jigglykrach", "Delibot","Feroongus"}));
                break;
            case 2:
                System.out.println("Scenario 2: " + simulateEvent(new String[]{"Hariynamo", "Misdremena", "Hydraugon", "Skulkarona", "Vulcaroboth"}));
                break;
            case 3:
                System.out.println("Scenario 3: " + simulateEvent(new String[]{"Pikachu", "Geigaton", "Tyrameka", "Scylamence", "Garadiant" }));
                break;
            default:
                System.out.println("Invalid scenario number. Please enter 1, 2, or 3.");
        }

        scanner.close();
    }

    private static String simulateEvent(String[] events) {
        Random random = new Random();
        int probability = random.nextInt(100) + 1; // Random number between 1 and 100

        // Event 1 has a 84% chance
        if (probability <= 84) {
            return events[0];
        }

        // Distribute the remaining 16% evenly among the other four events
        int range = 16 / (events.length - 1);
        for (int i = 1; i < events.length; i++) {
            if (probability <= 60 + i * range) {
                return events[i];
            }
        }

        // Fallback, should not normally be reached
        return events[events.length - 1];
    }
}	
        
        
    
