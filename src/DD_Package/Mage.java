package DD_Package;

public class Mage extends Player{
    protected Mana mana;
    protected int mana_cost;
    protected int spell_power;
    protected int hits_count;
    protected int ability_range;

    public Mage(int x, int y, String name, int h_p, int attack_points, int defense_points, int mana_pool, int mana_cost, int spell_power, int hits_count, int ability_range) {
        super(new Coordinate(x, y), name, new Health(h_p, h_p), attack_points, defense_points);
        this.mana = new Mana(mana_pool, mana_pool / 4);
        this.mana_cost = mana_cost;
        this.spell_power = spell_power;
        this.hits_count = hits_count;
        this.ability_range = ability_range;
    }

    public void Level_Up(){
        super.Level_Up();
        ////////////////////////////  now addons  ////////////////////////////  /////  add print here or somewhere else
        this.mana.setMana_pool(this.mana.getMana_pool() + (25*this.getPlayer_Level()));
        this.mana.setCurrent_mana(Math.min(this.mana.getCurrent_mana() + (this.mana.getMana_pool()/4), this.mana.getMana_pool()));
        this.spell_power = this.spell_power + (10*this.getPlayer_Level());
    }

    @Override
    public void Ability_Cast() {
        if(this.mana.getCurrent_mana() < this.mana_cost){
            System.out.println("You don't have enough Mana in order to use your ability");
        }else{
            this.mana.setCurrent_mana(this.mana.getCurrent_mana() - this.mana_cost);
            int hits = 0;
            while(hits < this.hits_count && ){
                //////////// continue casting the ability
                hits += 1;
            }
        }
    }

    public void On_Tick_Do() {
        this.mana.setCurrent_mana(Math.min(this.mana.getMana_pool(), this.mana.getCurrent_mana() + this.getPlayer_Level()));
        ///////////  continue
    }

    @Override
    public String toString() { return this.getCharacter(); }

    @Override
    public void interact(Tile other) {
        other.interact(this);
    }
}
