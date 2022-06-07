package DD_Package;

public class Monster extends Enemy{
    private int vision_range;

    public Monster(String na, char ch, int vision_range, int experience_value, int a_p, int d_p, int h_p, int x, int y){
        super.setAttack_points(a_p);
        super.setDefense_points(d_p);
        super.setHealth(new Health(h_p, h_p));
        super.setName(na);
        super.setCharacter(ch);
        super.setExperience_value(experience_value);
        super.setCoordinate(new Coordinate(x, y));
        this.vision_range = vision_range;
    }

    public int getVision_range() {
        return this.vision_range;
    }
    public void setVision_range(int vision_range) {
        this.vision_range = vision_range;
    }
}
