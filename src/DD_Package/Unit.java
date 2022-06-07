package DD_Package;

public abstract class Unit extends Tile {
    private String Name;
    private Health Health;
    private int Attack_points;
    private int Defense_points;

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
