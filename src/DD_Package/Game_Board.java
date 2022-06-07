package DD_Package;

import java.util.ArrayList;

public class Game_Board {
    private ArrayList<ArrayList<Tile>> Board;
    private InputReader reader;

    public Game_Board(String file_path, int player){
        this.reader = new InputReader(file_path, player);
        this.Board = this.reader.Read();
    }




}
