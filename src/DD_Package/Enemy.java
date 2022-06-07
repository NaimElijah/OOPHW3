package DD_Package;

public abstract class Enemy extends Unit{
    private int Experience_value;

    public int getExperience_value(){
        return this.Experience_value;
    }

    public void setExperience_value(int experience_value) {
        this.Experience_value = experience_value;
    }

    public void On_Tick_Do() {   //// maybe the same trick with Level_Up, maybe put it in Unit and everyone will override
        super.On_Tick_Do();
        ///////////  continue
    }
}
