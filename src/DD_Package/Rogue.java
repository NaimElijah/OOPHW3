package DD_Package;

public class Rogue extends Player{

    protected int cost;
    protected int current_energy;

    public Rogue(int cost, String na, String ch, int a_p, int d_p, int h_p, int x, int y){
        this.setExperience(0);
        this.setPlayer_Level(1);
        this.setAttack_points(a_p);
        this.setDefense_points(d_p);
        this.setHealth(new Health(h_p, h_p));
        this.setName(na);
        this.setCharacter(ch);
        this.setCoordinate(new Coordinate(x, y));

        this.cost = cost;
        this.current_energy = 100;
    }

    public void Level_Up(){
        super.Level_Up();
        ////////////////////////////  now addons  ////////////////////////////
        this.current_energy = 100;
        this.setAttack_points(this.getAttack_points() + (3*this.getPlayer_Level()));
    }

    @Override
    public void Ability_Cast() {
        if(this.current_energy < this.cost){
            System.out.println("You don't have enough Energy in order to use your ability");
        }else{
            this.current_energy = this.current_energy - this.cost;
            /////////// continue casting the ability
        }
    }

    public void On_Tick_Do() {
        super.On_Tick_Do();
        this.current_energy = Math.min(this.current_energy + 10, 100);
        ///////////  continue
    }
}
