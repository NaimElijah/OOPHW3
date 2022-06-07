package DD_Package;

public class Rogue extends Player{

    private int cost;
    private int current_energy;

    public Rogue(int cost, String na, char ch, int a_p, int d_p, int h_p, int x, int y){
        super.setExperience(0);
        super.setPlayer_Level(1);
        super.setAttack_points(a_p);
        super.setDefense_points(d_p);
        super.setHealth(new Health(h_p, h_p));
        super.setName(na);
        super.setCharacter(ch);
        super.setCoordinate(new Coordinate(x, y));

        this.cost = cost;
        this.current_energy = 100;
    }

    public void Level_Up(){
        super.Level_Up();
        //////////  now addons
    }

    @Override
    public void Ability_Cast() {

    }
}
