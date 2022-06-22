package DD_Package;

public class Trap extends Enemy{
    protected TrapVisibility visibility;

    protected Trap(int vis_t, int invis_t, String character, int x, int y, String name, int h_p, int attack_points, int defense_points, int experience_value) {
        super(character, new Coordinate(x, y), name, new Health(h_p, h_p), attack_points, defense_points, experience_value);
        this.visibility = new TrapVisibility(vis_t, invis_t);
    }

    public TrapVisibility getVisibility() {
        return this.visibility;
    }
    public void setVisibility(TrapVisibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        if (this.visibility.getVisible()){
            return this.getCharacter();
        }else {
            return ".";
        }
    }

    @Override
    public void On_Tick_Do(Player player, Game_Board game_board) {
        this.visibility.setVisible(this.visibility.getTicks_count() < this.visibility.getVisibility_time());
        if (this.visibility.getTicks_count() == this.visibility.getVisibility_time() + this.visibility.getInvisibility_time()){ // visibility mode changing
            this.visibility.setTicks_count(0);
        }else{
            this.visibility.setTicks_count(this.visibility.getTicks_count() + 1);
        }
//        if ()//////// if the range is within 2 then attack the Player   ///////  continue
//        ///////////  continue
    }


    @Override
    public void move(Tile tile) {

    }

    @Override
    public void interact(Tile other) {
        other.interact(this);
    }


    @Override
    public String description() {      /////////   returns full information of the current unit, maybe just .send(what we return here), maybe...
        return super.description();  ////////  if we don't need to .send(what we return here) then delete this method here, it's already in Enemy.
    }

    @Override
    public void attack(Unit unit) {

    }

    @Override
    public void defense(Unit unit) {

    }
}
