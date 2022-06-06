package DD_Package;

public class Trap extends Enemy{
    private TrapVisibility visibility;

    public Trap(int visibility_time, int invisibility_time){
        this.visibility = new TrapVisibility(visibility_time, invisibility_time);
    }

    public TrapVisibility getVisibility() {
        return this.visibility;
    }
    public void setVisibility(TrapVisibility visibility) {
        this.visibility = visibility;
    }


}
