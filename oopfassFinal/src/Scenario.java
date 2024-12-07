import java.util.Scanner;

public class Scenario {
    private String welcomeMessage;

    public void chooseScenario() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display available scenarios
            System.out.println("Choose a Battle Stage:");
            System.out.println("A. Alien Invasion");
            System.out.println("B. Treasure Hunt");
            System.out.println("C. Time Travel Dilemma");

            // Get user input
            System.out.print("\nEnter your choice (A, B, or C): ");
            String scenarioChoice = scanner.nextLine().toUpperCase();
            System.out.println("");

            // Modify welcome message based on the scenario choice
            switch (scenarioChoice) {
                case "A":
                    welcomeMessage = "Welcome to the Alien Invasion battle stage!";
                    break;
                case "B":
                    welcomeMessage = "Welcome to the Treasure Hunt battle stage!";
                    break;
                case "C":
                    welcomeMessage = "Welcome to the Time Travel Dilemma battle stage!";
                    break;
                default:
                    System.out.println("Invalid scenario choice. Please choose A, B, or C.");
                    continue; // Continue the loop to ask for input again
            }

            break; // Break the loop if a valid scenario choice is entered
        }
        System.out.println(welcomeMessage);        
    }
}