package DD_Package;

public abstract class Unit extends Tile {
    protected String Name;
    protected Health Health;
    protected int Attack_points;
    protected int Defense_points;

    protected MessageCallback messageCallback;   ////////  initialize later with a method  !!!!!

    protected Unit(String character, Coordinate coordinate, String name, Health health, int attack_points, int defense_points){
        super(character, coordinate);
        this.messageCallback = System.out::println;  //////  see Tal's answer !!!!!!!!!!!!!! //  basically: (s) -> System.out.println(s), when we create the units, we initialize this for each of them
        this.Name = name;
        this.Health = health;
        this.Attack_points = attack_points;
        this.Defense_points = defense_points;
    }


    ////////////////////   different on tick do()'s in the different unit's classes

    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", getName(), getHealth(), getAttack_points(), getDefense_points());
    }

    public void initialize_messages(MessageCallback m){   //////  when we create the units, we initialize this for each of them, did this in the builder instead !
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

    public abstract void attack(Unit unit);
    public abstract void defense(Unit unit);

}
