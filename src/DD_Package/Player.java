package DD_Package;

public abstract class Player extends Unit{
    private int Experience;
    private int Player_Level;



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

    public void Experience_Addition(int Addition){   ////////  only needed in this class
        this.Experience = this.Experience + Addition;
        if(this.Experience >= 50*this.Player_Level){
            this.Level_Up();
        }
    }

    public abstract void On_Tick_Do();  //// maybe the same trick with Level_Up, maybe put it in Unit and everyone will override








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
