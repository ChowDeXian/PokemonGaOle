import java.util.ArrayList;

public class PokemonList {
    // List to store Pokemon instances
    private static ArrayList<Pokemon> pokemonList = new ArrayList<>();

    // Initialize the Pokemon list with all the Pokemon
    static {
        pokemonList.add(new Pokemon("Rattata", "Normal", 160, "Quick Attack", 3));
        pokemonList.add(new waterPokemon("Squirtle", 188, "Water Gun", 3));
        pokemonList.add(new waterPokemon("Psyduck", 170, "Water Gun", 3));
        pokemonList.add(new electricPokemon("Pikachu",  170, "Thunder Shock", 3));
        pokemonList.add(new Pokemon("Eevee", "Normal", 110, "Tackle", 3));
        pokemonList.add(new grassPokemon("Gloom",  120, "Vine Whip", 3));
        pokemonList.add(new firePokemon("Charmander", 378, "Flame Burst", 4));
        pokemonList.add(new grassPokemon("Leafeon",  330, "Leaf Blade", 4));
        pokemonList.add(new grassPokemon("Bulbasaur", 490, "Vine Whip", 4));
        pokemonList.add(new waterPokemon("Starmie", 320, "Water Pulse", 4));
        pokemonList.add(new waterPokemon("Vaporeon",  480, "Water Pulse", 4));
        pokemonList.add(new electricPokemon("Jolteon",  530, "Thunder", 4));
        pokemonList.add(new firePokemon("Flareon",  330, "Flame Thrower", 4));
        pokemonList.add(new firePokemon("Arcanine", 290, "Fire Blast", 4));
        pokemonList.add(new electricPokemon("Zapdos", 450, "Thunderbolt", 4));
        pokemonList.add(new firePokemon("Magmar", 550, "Ember", 4));
        pokemonList.add(new electricPokemon("Electabuzz", 400, "Thunder Punch", 4));
        pokemonList.add(new Pokemon("Snorlax", "Normal", 250, "Body Slam", 4));
        pokemonList.add(new electricPokemon("Raikou",  800, "Discharge", 5));
        pokemonList.add(new firePokemon("Entei",  800, "Fire Fang", 5));
        pokemonList.add(new waterPokemon("Suicune",  800, "Hydro Pump", 5));
        pokemonList.add(new grassPokemon("Vileplume", 800, "Petal Dance", 5));
    }    

    // Getter for the Pokemon list
    public static ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }
}
