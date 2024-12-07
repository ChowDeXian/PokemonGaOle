import java.util.*;

public class Battle {
    private ArrayList<Pokemon> userPokemons;
    private ArrayList<Pokemon> enemyPokemons;
    private ArrayList<Pokemon> availablePokemons; 
    private ArrayList<Pokemon> faintedPokemons;
    private int userTotalScore = 0;
    private int computerTotalScore = 0;

    public Battle(ArrayList<Pokemon> userPokemons, ArrayList<Pokemon> availablePokemons) {
        this.userPokemons = userPokemons;
        this.availablePokemons = availablePokemons;
        this.faintedPokemons = new ArrayList<>();
        this.enemyPokemons = new ArrayList<>();
        initializeEnemyPokemons(availablePokemons);
    }
    
    public ArrayList<Pokemon> getUserPokemons() {
        return userPokemons;
    }
    public ArrayList<Pokemon> getEnemyPokemons() {
        return enemyPokemons;
    }
    public ArrayList<Pokemon> getAvailablePokemons() {
        return availablePokemons;
    }
    public ArrayList<Pokemon> getFaintedPokemons() {
        return faintedPokemons;
    }
    public int getUserTotalScore() {
        return userTotalScore;
    }
    public int getComputerTotalScore() {
        return computerTotalScore;
    }

    private void initializeEnemyPokemons(ArrayList<Pokemon> availablePokemons) {
        enemyPokemons = new ArrayList<>(availablePokemons);
        enemyPokemons.removeAll(userPokemons);
        // Randomly choose 2 enemy Pokemon
        Collections.shuffle(enemyPokemons);
        enemyPokemons = new ArrayList<>(enemyPokemons.subList(0, 2));
    }

    public void displayBattleDetails() {
        System.out.println("\nNow...\nTwo wild Pokémons have appeared: " + enemyPokemons.get(0).getName() + " and " + enemyPokemons.get(1).getName() + "\n");
        System.out.println("The battle is about to start. Here are the details of the upcoming encounter:");

        System.out.println("\n------------------------------------------------------------");
        // Displaying the details of Allied Pokémons
        System.out.println("\nAllied Pokémons:\n");
        for (Pokemon userPokemon : userPokemons) {
            System.out.println(userPokemon);
        }

        // Displaying the details of Enemy Pokémons
        System.out.println("\nEnemy Pokémons:\n");
        for (Pokemon enemyPokemon : enemyPokemons) {
            System.out.println(enemyPokemon);
        }
        System.out.println("\n------------------------------------------------------------");
    }

    private Pokemon chooseUserPokemonForBattle(int round) {
        Scanner scanner = new Scanner(System.in);
    
        // Display user's Pokémon
        System.out.println("\nYour Pokémons:");
        for (int i = 0; i < userPokemons.size(); i++) {
            char choice = (char) ('a' + i);
            System.out.printf("%c. %s\n", choice, userPokemons.get(i));
        }
        System.out.println("\nRound " + round + ": Choose 1 Pokémon for the battle (a-c):");

        char choice = scanner.nextLine().toLowerCase().charAt(0);

        if (choice < 'a' || choice > 'c') {
            System.out.println("Invalid input. Please choose a valid Pokemon (a-c).");
            return null; // Return null in case of invalid input
        }

        int index = choice - 'a';
        Pokemon chosenPokemon = userPokemons.get(index);
        
        // Display a message indicating the chosen Pokémon
        System.out.println(chosenPokemon.getName() + " is chosen for the battle.");
    
        return chosenPokemon;
    }

    public void startBattle() {
        Catch pokeCatcher = new Catch();
        Score score = new Score();
    
        for (int round = 1; round <= 2; round++) {
            Pokemon userPokemon = chooseUserPokemonForBattle(round);
            Pokemon computerPokemon = enemyPokemons.get(round - 1);
    
            System.out.println("\nBattle Start!\n");
    
            while (userPokemon.getHp() > 0 && computerPokemon.getHp() > 0) {
                playerTurn(userPokemon, computerPokemon);
                if (computerPokemon.getHp() > 0) {
                    enemyTurn(userPokemon, computerPokemon);
                }
            }
    
            // Display battle results after each battle
            displayBattleResults(userPokemon, computerPokemon);
    
            // Update total scores based on remaining HP
            userTotalScore += userPokemon.getHp();
            computerTotalScore += computerPokemon.getHp();
    
            // Display round information
            System.out.println("Round " + round + ": Total Scores - User: " + userTotalScore + ", Computer: " + computerTotalScore);
        }
    
        // Check if the wild Pokémon has fainted after both battles
        if (enemyPokemons.get(0).getHp() <= 0 || enemyPokemons.get(1).getHp() <= 0) {
            // Add the fainted Pokémons to the list
            if (enemyPokemons.get(0).getHp() <= 0) {
                faintedPokemons.add(enemyPokemons.get(0));
            }
            if (enemyPokemons.get(1).getHp() <= 0) {
                faintedPokemons.add(enemyPokemons.get(1));
            }

            // Call the catchFaintedPokemon function for the fainted Pokémons
            Catch.catchFaintedPokemon(faintedPokemons, pokeCatcher);

            // Calculate remaining HP as the total score
            int remainingHp1 = Math.max(0, enemyPokemons.get(0).getHp());
            int remainingHp2 = Math.max(0, enemyPokemons.get(1).getHp());
            userTotalScore += remainingHp1 + remainingHp2;
            computerTotalScore -= remainingHp1 + remainingHp2;
    
            System.out.println("Total Scores - User: " + userTotalScore + ", Computer: " + computerTotalScore);
        }
    
        // Display overall battle end message
        System.out.println("\nBattle ended! Total Scores - User: " + userTotalScore + ", Computer: " + computerTotalScore);

        //show score
        score.calculateAndShowScore(userTotalScore, computerTotalScore);
    }

    private void playerTurn(Pokemon playerPokemon, Pokemon enemyPokemon) {
        playerPokemon.attack();
        enemyPokemon.takeDamage((int) (Math.random() * 50) + 1);
    }

    private void enemyTurn(Pokemon playerPokemon, Pokemon enemyPokemon) {
        enemyPokemon.attack();
        playerPokemon.takeDamage((int) (Math.random() * 50) + 1);
    }

    private void displayBattleResults(Pokemon playerPokemon, Pokemon enemyPokemon) {
        System.out.println("\nBattle results:\n");
        System.out.printf("Player's Pokémon: %s (%s) - HP: %d\n",playerPokemon.getName(), playerPokemon.getType(), playerPokemon.getHp());
        System.out.printf("Enemy's Pokémon: %s (%s) - HP: %d\n",enemyPokemon.getName(), enemyPokemon.getType(), enemyPokemon.getHp());
    
        // Determine the winner and effectiveness
        boolean playerWins = playerPokemon.getHp() > enemyPokemon.getHp();
        double effectiveness = PokemonTypeInteractions.getEffectiveness(playerPokemon, enemyPokemon);
    
        if (playerWins) {
            System.out.println("\n");
            System.out.println(playerPokemon.getName() + " wins against " + enemyPokemon.getName());
            if (effectiveness > 1) {
                System.out.println(playerPokemon.getName() + " is super effective against " + enemyPokemon.getName());
            } else if (effectiveness < 1) {
                System.out.println(playerPokemon.getName() + " is not very effective against " + enemyPokemon.getName());
            } else {
                System.out.println(playerPokemon.getName() + " has a normal effectiveness against " + enemyPokemon.getName());
            }
        } else {
            System.out.println(enemyPokemon.getName() + " wins against " + playerPokemon.getName());
            System.out.println(playerPokemon.getName() + " is not very effective against " + enemyPokemon.getName());
        }
        System.out.println();
    }
}
