package DD_Package;

public class Trap extends Enemy{
    private int visibility_time;
    private int invisibility_time;
    private int ticks_count;
    private boolean visible;

    public Trap(int visibility_time, int invisibility_time){
        this.visibility_time = visibility_time;
        this.invisibility_time = invisibility_time;
        this.ticks_count = 0;
        this.visible = true;
    }

    public int getVisibility_time() {
        return this.visibility_time;
    }
    public void setVisibility_time(int visibility_time) {
        this.visibility_time = visibility_time;
    }

    public int getInvisibility_time() {
        return this.invisibility_time;
    }
    public void setInvisibility_time(int invisibility_time) {
        this.invisibility_time = invisibility_time;
    }

    public int getTicks_count() {
        return this.ticks_count;
    }
    public void setTicks_count(int ticks_count) {   ///// may not be needed
        this.ticks_count = ticks_count;
    }

    public boolean getVisible(){
        return this.visible;
    }
    public void setVisible(boolean newvisible){
        this.visible = newvisible;
    }


}
