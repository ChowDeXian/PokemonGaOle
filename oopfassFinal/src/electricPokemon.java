public class electricPokemon extends Pokemon {
    public electricPokemon(String name, int hp, String attackName, int attackDamage) {
        super(name, "Electric", hp, attackName, attackDamage);
    }
    @Override
    public String toString() {
        return String.format("%s (Electric) - HP: %d, Electric Move: %s (%d)", getName(), getHp(), getAttackName(), getAttackDamage());
    }
}
