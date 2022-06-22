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





    public void attack(Unit unit, int attack_amount){  /////////  later see where to do the .send(messages), not complicated
        this.getMessageCallback().send(this.getName()+ " engaged in combat with " + unit.getName()); ///////////   message
        this.getMessageCallback().send(this.description() + "\n" + unit.description()); ///////////   message
        unit.defense(this, attack_amount);
        this.getMessageCallback().send(this.getName()+ "rolled" + attack_amount + ); ///////////   message
    }



    public void defense(Unit unit, int attack_amount){  /////////  later see where to do the .send(messages), not complicated
        int defense_amount = (int)(Math.floor(Math.random()*(this.getDefense_points() + 1)));
        int damage = attack_amount - defense_amount;
        if ( damage > 0){
            this.getHealth().setHealth_amount(this.getHealth().getHealth_amount() - damage);
            this.getMessageCallback().send(""); ///////////   message
        }

        //////// subtract and use .send(messages)
    }


}
