package DD_Bussiness_Package;

public class Rogue extends Player{

    protected int cost;
    protected int current_energy;

    public Rogue(int cost, int x, int y, String name, int h_p, int attack_points, int defense_points) {
        super(new Coordinate(x, y), name, new Health(h_p, h_p), attack_points, defense_points);
        this.cost = cost;
        this.current_energy = 100;
    }

    public void Level_Up(){
        super.Level_Up();
        ////////////////////////////  now addons  ////////////////////////////
        this.current_energy = 100;
        this.setAttack_points(this.getAttack_points() + (3*this.getPlayer_Level()));

        int hea_add = (10*this.getPlayer_Level()), att_add = (4*this.getPlayer_Level()), def_add = (this.getPlayer_Level());  ///////  now change them accordingly
        String message = "\n" + this.getName() + " reached level " + this.getPlayer_Level() + ": +" + hea_add + " Health, +" + att_add + " Attack, +" + def_add + " Defense." + "\n";
        this.getMessageCallback().send(message);  /////////////////  the message with the regular upgrades + the class upgrades !!!
    }

    @Override
    public void Ability_Cast(Game_Board game_board) {
        if(this.current_energy < this.cost){
            this.getMessageCallback().send("You don't have enough Energy in order to use your ability");
        }else{
            this.current_energy = this.current_energy - this.cost;
            ////////////////////////////////////////////////////////////// continue casting the ability
        }
    }

    @Override
    public void On_Tick_Do(Game_Board game) {
        this.current_energy = Math.min(this.current_energy + 10, 100);
    }

    @Override
    public String description() {      /////////   returns full information of the current unit, maybe just .send(what we return here), maybe...
        String res = "\n" + "** " + this.getName() + "'s Status ** :        Health: " + this.getHealth().toString() + "        Attack: " + this.getAttack_points() + "        Defense: " + this.getDefense_points() + "        Level: " + this.getPlayer_Level() + "\n";
        res += "        Experience: " + this.getExperience() + "/" + (50*this.getPlayer_Level()) + "        Energy: " + this.current_energy + "/100" + "\n";
        return res;
    }

}
