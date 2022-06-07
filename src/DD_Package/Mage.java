package DD_Package;

public class Mage extends Player{
    private Mana mana;
    private int mana_cost;
    private int spell_power;
    private int hits_count;
    private int ability_range;

    public Mage(int mana_pool, int mana_cost, int spell_power, int hits_count, int ability_range, String na, char ch, int a_p, int d_p, int h_p, int x, int y){
        super.setExperience(0);
        super.setPlayer_Level(1);
        super.setAttack_points(a_p);
        super.setDefense_points(d_p);
        super.setHealth(new Health(h_p, h_p));
        super.setName(na);
        super.setCharacter(ch);
        super.setCoordinate(new Coordinate(x, y));

        this.mana = new Mana(mana_pool, mana_pool / 4);
        this.mana_cost = mana_cost;
        this.spell_power = spell_power;
        this.hits_count = hits_count;
        this.ability_range = ability_range;
    }

    public void Level_Up(){
        super.Level_Up();
        //////////  now addons
    }

    @Override
    public void Ability_Cast() {

    }


}
