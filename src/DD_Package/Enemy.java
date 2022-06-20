package DD_Package;

public abstract class Enemy extends Unit{
    protected int Experience_value;

    protected Enemy(String character, Coordinate coordinate, String name, Health health, int attack_points, int defense_points, int experience_value) {
        super(character, coordinate, name, health, attack_points, defense_points);
        this.Experience_value = experience_value;
    }

    public int getExperience_value(){
        return this.Experience_value;
    }

    public void setExperience_value(int experience_value) {
        this.Experience_value = experience_value;
    }

    public void on_death(){
        ////////////
    }

    public abstract void On_Tick_Do(Player player, Game_Board game_board);

}
