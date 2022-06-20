package DD_Package;

public abstract class Player extends Unit{
    protected int Experience;
    protected int Player_Level;

    protected Player(Coordinate coordinate, String name, Health health, int attack_points, int defense_points) {
        super("@", coordinate, name, health, attack_points, defense_points);
        this.Experience = 0;
        this.Player_Level = 1;
    }


    public void Level_Up(){
        this.Experience = this.Experience - (50*this.Player_Level);
        this.Player_Level = this.Player_Level + 1;

        int tempHealth_pool = this.getHealth().getHealth_pool();
        int new_health_pool = tempHealth_pool + (10*this.Player_Level);
        this.setHealth(new Health(new_health_pool, new_health_pool));

        this.setAttack_points(this.getAttack_points() + (4*this.Player_Level));
        this.setDefense_points(this.getDefense_points() + this.Player_Level);
    }

    public abstract void Ability_Cast();

    public void Experience_Addition(int Addition){   ////////  only needed in this class, might need to be in every player class, think it's ok here
        this.Experience = this.Experience + Addition;
        while(this.Experience >= 50*this.Player_Level){
            this.Level_Up();  ////  I want this to activate the Level_Up() of Warrior, Mage or Rogue
        }
    }


    @Override
    public void move(Tile tile){
        tile.move(this);
    }








    public int getExperience(){
        return this.Experience;
    }
    public void setExperience(int experience) {
        this.Experience = experience;
    }

    public int getPlayer_Level() {
        return this.Player_Level;
    }
    public void setPlayer_Level(int player_Level) {
        this.Player_Level = player_Level;
    }


}
