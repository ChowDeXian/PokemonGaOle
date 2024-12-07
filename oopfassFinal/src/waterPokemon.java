public class waterPokemon extends Pokemon {
    public waterPokemon(String name, int hp, String attackName, int attackDamage) {
        super(name, "Water", hp, attackName, attackDamage);
    }
    @Override
    public String toString() {
        return String.format("%s (Water) - HP: %d, Water Move: %s (%d)", getName(), getHp(), getAttackName(), getAttackDamage());
    }
}
