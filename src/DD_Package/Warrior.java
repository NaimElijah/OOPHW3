package DD_Package;

public class Warrior extends Player{

    protected int ability_cooldown;
    protected int remaining_cooldown;

    public Warrior(int ability_cooldown, String na, String ch, int a_p, int d_p, int h_p, int x, int y){
        this.setExperience(0);
        this.setPlayer_Level(1);
        this.setAttack_points(a_p);
        this.setDefense_points(d_p);
        this.setHealth(new Health(h_p, h_p));
        this.setName(na);
        this.setCharacter(ch);
        this.setCoordinate(new Coordinate(x, y));

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
    }

    public void On_Tick_Do(){
        super.On_Tick_Do();
        if(this.remaining_cooldown > 0){
            this.remaining_cooldown = this.remaining_cooldown - 1;
        }
        ///////////  continue
    }


}
