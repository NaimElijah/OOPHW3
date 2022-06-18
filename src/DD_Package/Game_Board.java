package DD_Package;

import java.util.ArrayList;

public class Game_Board {
    protected ArrayList<ArrayList<Tile>> arrays_Board; ///////  listen to my recordings and read the rest of the assignment before continuation   /////
    protected InputReader reader;
    protected Player the_player;
    protected ArrayList<Monster> Monsters;
    protected ArrayList<Trap> Traps;

    public Game_Board(String file_path, int player){
        this.reader = new InputReader(file_path, player);
        this.arrays_Board = this.reader.Read();
        this.the_player = this.reader.getThe_player();
        this.Monsters = this.reader.getMonsters();
        this.Traps = this.reader.getTraps();
    }


    @Override
    public String toString() {
        return ///// the double arraylist, where each line and column are sorted() by their x and y
    }

    ////////////   check and see the methods in Tal's example files










    public ArrayList<ArrayList<Tile>> getArrays_Board() {
        return this.arrays_Board;
    }
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
