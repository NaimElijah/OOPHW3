package DD_Package;

public class Trap extends Enemy{
    protected TrapVisibility visibility;

    public Trap(int vis_t, int invis_t, String na, String ch, int experience_value, int a_p, int d_p, int h_p, int x, int y){
        this.setAttack_points(a_p);
        this.setDefense_points(d_p);
        this.setHealth(new Health(h_p, h_p));
        this.setName(na);
        this.setCharacter(ch);
        this.setExperience_value(experience_value);
        this.setCoordinate(new Coordinate(x, y));

        this.visibility = new TrapVisibility(vis_t, invis_t);

    }

    public TrapVisibility getVisibility() {
        return this.visibility;
    }
    public void setVisibility(TrapVisibility visibility) {
        this.visibility = visibility;
    }

    public void On_Tick_Do() {
        super.On_Tick_Do();
        this.visibility.setVisible(this.visibility.getTicks_count() < this.visibility.getVisibility_time());
        if (this.visibility.getTicks_count() == this.visibility.getVisibility_time() + this.visibility.getInvisibility_time()){ // visibility mode changing
            this.visibility.setTicks_count(0);
        }else{
            this.visibility.setTicks_count(this.visibility.getTicks_count() + 1);
        }
        if ()//////// if the range is within 2 then attack the Player
        ///////////  continue
    }

}
