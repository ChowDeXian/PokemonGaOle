public class firePokemon extends Pokemon {
    public firePokemon(String name, int hp, String attackName, int attackDamage) {
        super(name, "Fire", hp, attackName, attackDamage);
    }
    @Override
    public String toString() {
        return String.format("%s (Fire) - HP: %d, Fire Move: %s (%d)", getName(), getHp(), getAttackName(), getAttackDamage());
    }
}
