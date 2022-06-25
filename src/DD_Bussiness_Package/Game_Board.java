package DD_Bussiness_Package;

import DD_CLI_Package.InputReader;

import java.util.ArrayList;

public class Game_Board {
    protected ArrayList<ArrayList<Tile>> arrays_Board; ///////  listen to my recordings and read the rest of the assignment before continuation   /////
    protected InputReader reader;
    protected Player the_player;
    protected ArrayList<Monster> Monsters;
    protected ArrayList<Trap> Traps;

    public Game_Board(String file_path, int player){
        this.reader = new InputReader(file_path, player);
        this.reader.Read(this);
        this.the_player = this.reader.getThe_player();
        this.Monsters = this.reader.getMonsters();
        this.Traps = this.reader.getTraps();
    }

    public void setThe_player(Player the_player) {
        this.getArrays_Board().get(this.getThe_player().getCoordinate().getY_coor()).set(this.getThe_player().getCoordinate().getX_coor(), the_player);
        this.the_player = the_player;
    }

    public void remove(Enemy enemy){
        if (this.getThe_player().getRange(enemy) <= 1) {    //////  if it's next to it, then replace positions,  check
            this.getThe_player().replace_positions(enemy);
            this.getArrays_Board().get(this.getThe_player().getCoordinate().getY_coor()).set(this.getThe_player().getCoordinate().getX_coor(), new Empty(enemy.getCoordinate().getX_coor(), enemy.getCoordinate().getY_coor()));
        }else {
            this.getArrays_Board().get(enemy.getCoordinate().getY_coor()).set(enemy.getCoordinate().getX_coor(), new Empty(enemy.getCoordinate().getX_coor(), enemy.getCoordinate().getY_coor()));
        }


        if (this.getMonsters().contains(enemy)){                     ////////  check why it doesnt put the player in the dead enemy's position
            this.getMonsters().remove(this.getMonsters().indexOf(enemy));
        }else {
            this.getTraps().remove(this.getTraps().indexOf(enemy));
        }
    }

    public void remove_player(){   ///////  continue
        this.getThe_player().setCharacter("X");
    }


    public void game_tick (){       /////////  does the on_tick_do's of all the units in this Game_Board
        this.getThe_player().On_Tick_Do();

        for (Monster monster:this.getMonsters()) {
            monster.On_Tick_Do(this.getThe_player(), this);
        }

        for (Trap trap:this.getTraps()) {
            trap.On_Tick_Do(this.getThe_player(), this);
        }

    }


    public void arrange_board(){      ///////////////    updates the 2d arraylist(the board)
        ArrayList<ArrayList<Tile>> new_arrays_Board = new ArrayList<ArrayList<Tile>>();
        for(int i=0; i< this.arrays_Board.size(); i++){
            ArrayList<Tile> curr_new_line = new ArrayList<Tile>();
            for (int j=0; j < this.arrays_Board.get(0).size(); j++){
                curr_new_line.add(new Empty(j, i));
            }
            new_arrays_Board.add(curr_new_line);
        }

        for(ArrayList<Tile> line: this.arrays_Board){
            for(Tile tile: line){
                new_arrays_Board.get(tile.getCoordinate().getY_coor()).set(tile.getCoordinate().getX_coor(), tile);
            }
        }
        this.arrays_Board = new_arrays_Board;
    }


    @Override
    public String toString() {    //////////   just return the already sorted arraylist in array list
        this.arrange_board();

        String res = "";
        for(ArrayList<Tile> line: this.arrays_Board) {
            for (Tile tile : line) {
                res += tile.getCharacter();
            }
            res+="\n";
        }
        return res;
    }











    public ArrayList<ArrayList<Tile>> getArrays_Board() {
        return this.arrays_Board;
    }
    public void setArrays_Board(ArrayList<ArrayList<Tile>> arrays_Board) { this.arrays_Board = arrays_Board; }

    public Player getThe_player() {
        return this.the_player;
    }
    public ArrayList<Monster> getMonsters() {
        return this.Monsters;
    }
    public ArrayList<Trap> getTraps() {
        return this.Traps;
    }

}
