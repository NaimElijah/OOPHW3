package DD_Bussiness_Package;

public abstract class Unit extends Tile {
    protected String Name;
    protected Health Health;
    protected int Attack_points;
    protected int Defense_points;

    protected MessageCallback messageCallback;    ////////  initialized later with a method when a Unit is created  !!!!!

    protected Unit(String character, Coordinate coordinate, String name, Health health, int attack_points, int defense_points){
        super(character, coordinate);
        this.Name = name;
        this.Health = health;
        this.Attack_points = attack_points;
        this.Defense_points = defense_points;
    }


    ////////////////////   different on tick do()'s in the different unit's classes

    public String description(){
        return "\n" + "** " + this.Name + "'s Status ** :        Health: " + this.Health.toString() + "        Attack: " + this.Attack_points + "        Defense: " + this.Defense_points;
    }

    public void initialize_messages(MessageCallback m){  /////  when we create the units, we initialize this for each of them
        this.messageCallback = m;
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

    public int getDefense_points() { return this.Defense_points; }
    public void setDefense_points(int defense_points) {
        this.Defense_points = defense_points;
    }

    public MessageCallback getMessageCallback() { return this.messageCallback; }

    @Override
    public void move(Tile tile) {
        tile.move(this);   //////////////////////////////  and then it goes to move(enemy) or move(player), there it attacks, does nothing...
    }

    public abstract void attack(Unit unit, int attack_amount);
    public abstract void defense(Unit unit, int defense_amount);    ////  see which ones(maybe 2) aren't connected\overriding to this abstract method

}
