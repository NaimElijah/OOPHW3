package DD_Package;

public abstract class Unit extends Tile {
    protected String Name;
    protected Health Health;
    protected int Attack_points;
    protected int Defense_points;


    public void On_Tick_Do() {   //// maybe the same trick with Level_Up, maybe put it in Unit and everyone will override
        ///////////  continue
    }

    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", getName(), getHealth(), getAttack_points(), getDefense_points());
    }


    public String getName() {
        return this.Name;
    }
    public void setName(String name) {
        this.Name = name;
    }

    public Health getHealth() {
        return this.Health;
    }
    public void setHealth(Health health) {
        this.Health = health;
    }

    public int getAttack_points() {
        return this.Attack_points;
    }
    public void setAttack_points(int attack_points) {
        this.Attack_points = attack_points;
    }

    public int getDefense_points() {
        return this.Defense_points;
    }
    public void setDefense_points(int defense_points) {
        this.Defense_points = defense_points;
    }

}
