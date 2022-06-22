package DD_Bussiness_Package;

import java.util.ArrayList;

public abstract class Player extends Unit{
    protected int Experience;
    protected int Player_Level;

    protected Player(Coordinate coordinate, String name, Health health, int attack_points, int defense_points) {
        super("@", coordinate, name, health, attack_points, defense_points);
        this.Experience = 0;
        this.Player_Level = 1;
    }

    public String description(){
        return  super.description() + "        Level: " + this.Player_Level + "\n" + "        Experience: " + this.Experience + "/" + (50*this.Player_Level);
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

    public abstract void Ability_Cast(Game_Board game_board);

    public ArrayList<Enemy> get_enemies_in_n_range (int range, Game_Board game_board){  //////  maybe give the player the board so we can access the Enemies
        ArrayList<Enemy> res = new ArrayList<Enemy>();
        for (Monster m: game_board.getMonsters()){
            if (m.getRange(game_board.getThe_player()) < range){
                res.add(m);
            }
        }
        for (Trap t: game_board.getTraps()){
            if (t.getRange(game_board.getThe_player()) < range){
                res.add(t);
            }
        }
        return res;
    }

    public void Experience_Addition(int Addition){   ////////  only needed in this class, might need to be in every player class, think it's ok here
        this.Experience = this.Experience + Addition;
        while(this.Experience >= 50*this.Player_Level){
            this.Level_Up();  ////  I want this to activate the Level_Up() of Warrior, Mage or Rogue
        }
    }


    public abstract void On_Tick_Do(Game_Board game);

    public void on_death(Game_Board game_board){   ////////////////  continue
        //////   make it "X" and print with .send(game_board), game over is sent in the CLI, if not do .send("Game Over") here
        game_board.remove_player(this);
    }

    @Override
    public void move(Enemy enemy) {  ////////////  confrontation
        this.attack(enemy, (int)(Math.floor(Math.random()*(this.getAttack_points() + 1))));
    }

    @Override
    public void move(Player player) { } ///////////////  won't reach another player in this game version but in the future we want to make another player so this will be useful !!
    ////////  then don't let it move to here, do nothing








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
