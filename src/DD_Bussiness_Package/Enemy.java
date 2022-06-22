package DD_Bussiness_Package;

public abstract class Enemy extends Unit{
    protected int Experience_value;

//    protected EnemyDeathCallback enemyDeathCallback;   //////  may not be needed !

    protected Enemy(String character, Coordinate coordinate, String name, Health health, int attack_points, int defense_points, int experience_value) {
        super(character, coordinate, name, health, attack_points, defense_points);
        this.Experience_value = experience_value;
//        this.enemyDeathCallback = this.on_death(game_board);   //////  may not be needed !
    }

    public String description(){
        return super.description() + "\n" + "        Experience Value: " + this.Experience_value;
    }

    public int getExperience_value(){
        return this.Experience_value;
    }

    public void setExperience_value(int experience_value) {
        this.Experience_value = experience_value;
    }



    public void on_death(Game_Board game_board){   //////////////////  continue
        game_board.remove(this);   ///////  make it new Empty(coordinates of the player) and the set the Coordinate of the player to where the now dead monster was
    }


    @Override
    public void move(Player player) {  /////////  confrontation
        player.attack(this, (int)(Math.floor(Math.random()*(player.getAttack_points() + 1))));    ////////////////    hhheerrreee  ookkk
    }

    @Override
    public void move(Enemy enemy) { } ////////  then don't let it move to here, do nothing




    public abstract void On_Tick_Do(Player player, Game_Board game_board);

}
