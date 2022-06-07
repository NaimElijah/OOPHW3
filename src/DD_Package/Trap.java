package DD_Package;

public class Trap extends Enemy{
    private TrapVisibility visibility;

    public Trap(int vis_t, int invis_t, String na, char ch, int experience_value, int a_p, int d_p, int h_p, int x, int y){
        super.setAttack_points(a_p);
        super.setDefense_points(d_p);
        super.setHealth(new Health(h_p, h_p));
        super.setName(na);
        super.setCharacter(ch);
        super.setExperience_value(experience_value);
        super.setCoordinate(new Coordinate(x, y));
        this.visibility = new TrapVisibility(vis_t, invis_t);

    }

    public TrapVisibility getVisibility() {
        return this.visibility;
    }
    public void setVisibility(TrapVisibility visibility) {
        this.visibility = visibility;
    }


}
