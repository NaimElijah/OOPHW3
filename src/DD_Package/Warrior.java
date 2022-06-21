package DD_Package;

public class Warrior extends Player{

    protected int ability_cooldown;
    protected int remaining_cooldown;

    public Warrior(int x, int y, String name, int h_p, int attack_points, int defense_points, int ability_cooldown) {
        super(new Coordinate(x, y), name, new Health(h_p, h_p), attack_points, defense_points);
        this.ability_cooldown = ability_cooldown;
        this.remaining_cooldown = 0;
    }


    public void Level_Up(){
        super.Level_Up();
        ////////////////////////////  now addons  ////////////////////////////
        this.remaining_cooldown = 0;
        this.getHealth().setHealth_pool(this.getHealth().getHealth_pool() + (5*this.getPlayer_Level()));
        this.setAttack_points(this.getAttack_points() + (2*this.getPlayer_Level()));
        this.setDefense_points(this.getDefense_points() + this.getPlayer_Level());
        this.getMessageCallback().send("");  /////////////////  the message !!!
    }

    @Override
    public void Ability_Cast() {
        if(this.remaining_cooldown > 0){
            System.out.println("You cannot use the ability yet !!");
        }else{
            this.remaining_cooldown = this.ability_cooldown;
            this.getHealth().setHealth_amount(Math.min(this.getHealth().getHealth_amount() + (10*this.getDefense_points()), this.getHealth().getHealth_pool()));
            ////////// continue casting the ability
        }

        this.getMessageCallback().send("");  /////////////////  the message !!!
    }

    @Override
    public void On_Tick_Do(Game_Board game) {
        if(this.remaining_cooldown > 0){
            this.remaining_cooldown = this.remaining_cooldown - 1;
        }
        ///////////  continue
    }


    @Override
    public void interact(Tile other) {
        other.interact(this);

        this.getMessageCallback().send("");  /////////////////  the message !!!   if needed !!
    }

    @Override
    public void attack(Unit unit) {  /////  activates the defend of the unit we're attcking and maybe also give the rolled attack in the arguments to the attacked's defense method

    }

    @Override
    public void defense(Unit unit) {   //////////   here we can also at the end do: this.getMessageCallback.send("the message")

    }
}
