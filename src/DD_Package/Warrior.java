package DD_Package;

public class Warrior extends Player{

    private int ability_cooldown;
    private int remaining_cooldown;

    public Warrior(int ability_cooldown, String na, char ch, int a_p, int d_p, int h_p, int x, int y){
        super.setExperience(0);
        super.setPlayer_Level(1);
        super.setAttack_points(a_p);
        super.setDefense_points(d_p);
        super.setHealth(new Health(h_p, h_p));
        super.setName(na);
        super.setCharacter(ch);
        super.setCoordinate(new Coordinate(x, y));

        this.ability_cooldown = ability_cooldown;
        this.remaining_cooldown = 0;
//        super.
    }

    public void Level_Up(){
        super.Level_Up();
        //////////  now addons
        this.remaining_cooldown = 0;
        super.set
    }

    @Override
    public void Ability_Cast() {

    }



}
