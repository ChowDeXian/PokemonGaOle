// Define Pokemon types
enum PokemonType {
    NORMAL, FIRE, WATER, ELECTRIC, GRASS
}

// Create a class to manage type interactions
public class PokemonTypeInteractions {
    // Define effectiveness matrix
    private static double[][] effectiveness = {
        {1, 1, 1, 1, 1}, // NORMAL
        {1, 0.5, 0.5, 1, 2}, // FIRE
        {1, 2, 0.5, 1, 0.5}, // WATER
        {1, 1, 2, 0.5, 0}, // ELECTRIC
        {1, 0.5, 2, 1, 0.5}, // GRASS
    };

    // Method to get effectiveness of an attack from one type to another
    public static double getEffectiveness(Pokemon attackPokemon, Pokemon defensePokemon) {
        PokemonType attackType = PokemonType.valueOf(attackPokemon.getType().toUpperCase());
        PokemonType defenseType = PokemonType.valueOf(defensePokemon.getType().toUpperCase());
        return effectiveness[attackType.ordinal()][defenseType.ordinal()];
    }
}
