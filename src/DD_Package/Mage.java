package DD_Package;

public class Mage extends Player{
    //// Special Ability explanation
    private Mana mana;
    private int mana_cost;
    private int spell_power;
    private int hits_count;
    private int ability_range;

    public Mage(int mana_pool, int mana_cost, int spell_power, int hits_count, int ability_range){
        this.mana = new Mana(mana_pool, mana_pool / 4);
        this.mana_cost = mana_cost;
        this.spell_power = spell_power;
        this.hits_count = hits_count;
        this.ability_range = ability_range;
    }

    //// upon leveling up explanation

    //// on game tick do:

    //// on ability cast do:

}
