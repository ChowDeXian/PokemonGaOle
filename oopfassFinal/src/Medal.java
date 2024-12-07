import java.util.*;

public class Medal {
    private int medals;
    private List<MiracleItem> items;
    private Random random;

    class MiracleItem {
        private String name;

        public MiracleItem(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public Medal() {
        this.medals = 0;
        this.items = new ArrayList<>();
        this.random = new Random();

        // Initialize the miracle items
        items.add(new MiracleItem("Attack Capsule"));
        items.add(new MiracleItem("Defense Capsule"));
        items.add(new MiracleItem("Quick Move Drink"));
        items.add(new MiracleItem("Spirit Drink"));
        items.add(new MiracleItem("Target Scope"));
        items.add(new MiracleItem("Poké Ball Power"));
    }

    public void handleMedals() {
        int goldenChips = (int) (Math.random() * 15);
        int goldenSands = (int) (Math.random() * 5);

        convertDropsToMedals(goldenChips, goldenSands);
        activateMiracleItemChance();
    }

    private void convertDropsToMedals(int goldenChips, int goldenSands) {
        this.medals += goldenChips + goldenSands;
        System.out.println("\nAfter the battle, defeated Pokémon dropped " + goldenChips + " Golden Chips and " + goldenSands +" Golden Sands. ");
        System.out.println("\nThese have been converted into Ga-Olé medals.");
        System.out.println("\n------Total Medals------");
        System.out.println("\n         "+this.medals+"\n");
        System.out.println("------------------------");
    }

    private void activateMiracleItemChance() {
        if (this.medals >= 10) { // Assuming 10 medals are needed for a Miracle Item Chance
            this.medals -= 10;
            MiracleItem miracleItem = items.get(random.nextInt(items.size()));

            System.out.println("\nMiracle Item Chance activated! You got a " + miracleItem.getName()+"!");
        } else {
            System.out.println("\nUnfortunately, there's not enough Ga-Olé medals for a Miracle Item Chance. Better luck next time.");
        }
    }
}
