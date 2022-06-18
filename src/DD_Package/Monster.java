package DD_Package;

public class Monster extends Enemy{
    protected int vision_range;

    public Monster(String na, String ch, int vision_range, int experience_value, int a_p, int d_p, int h_p, int x, int y){
        this.setAttack_points(a_p);
        this.setDefense_points(d_p);
        this.setHealth(new Health(h_p, h_p));
        this.setName(na);
        this.setCharacter(ch);
        this.setExperience_value(experience_value);
        this.setCoordinate(new Coordinate(x, y));

        this.vision_range = vision_range;
    }

    public int getVision_range() {
        return this.vision_range;
    }
    public void setVision_range(int vision_range) {
        this.vision_range = vision_range;
    }

    public void On_Tick_Do() {
        super.On_Tick_Do();

        ////////// if the range is within the vision_range then attack, if not, move accordingly as described in the assignment
        ///////////  continue
    }
}
