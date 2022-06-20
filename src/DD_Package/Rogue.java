package DD_Package;

public class Rogue extends Player{

    protected int cost;
    protected int current_energy;

    public Rogue(int cost, int x, int y, String name, int h_p, int attack_points, int defense_points) {
        super(new Coordinate(x, y), name, new Health(h_p, h_p), attack_points, defense_points);
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
        this.current_energy = Math.min(this.current_energy + 10, 100);
        ///////////  continue
    }

    @Override
    public String toString() { return this.getCharacter(); }

    @Override
    public void interact(Tile other) {
        other.interact(this);
    }
}
