public class grassPokemon extends Pokemon {
    public grassPokemon(String name, int hp, String attackName, int attackDamage) {
        super(name, "Grass", hp, attackName, attackDamage);
    }
    @Override
    public String toString() {
        return String.format("%s (Grass) - HP: %d, Grass Move: %s (%d)", getName(), getHp(), getAttackName(), getAttackDamage());
    }
}
