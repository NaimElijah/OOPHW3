package DD_Package;

public class Monster extends Enemy{
    private int vision_range;

    public Monster(int vision_range){
        this.vision_range = vision_range;
    }

    public int getVision_range() {
        return this.vision_range;
    }
    public void setVision_range(int vision_range) {
        this.vision_range = vision_range;
    }
}
