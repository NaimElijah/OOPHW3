package DD_Package;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputReader {
    protected String file_path;
    protected int player;
    protected ArrayList<Monster> Monsters;
    protected ArrayList<Trap> Traps;
    protected Player the_player;

    public InputReader(String file_path, int player){
        this.file_path = file_path;
        this.player = player;
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

    /////////////////////////////////  listen to my recordings and read the rest of the assignment before continuation  ///////////////////
    public ArrayList<ArrayList<Tile>> Read(){  ////  maybe just use the Read() again when we move up a level
        ArrayList<ArrayList<Tile>> res = new ArrayList<ArrayList<Tile>>();
        List<String> lines = Collections.emptyList();

        try{
            lines = Files.readAllLines(Paths.get(this.file_path));
        }catch (IOException e){
            System.out.println(e.getMessage() + "\n" + e.getStackTrace());
        }

        int amount_of_lines = lines.size();
        int line_length = lines.get(0).length();  /// amount of columns
        Monster curr_monster;
        Trap curr_trap;

        for(int i = 0; i < amount_of_lines; i++) {
            ArrayList<Tile> curr_line = new ArrayList<Tile>();
            for(int j=0; j < line_length; j++) {
                if ('#' == (lines.get(i).charAt(j))) {   //// Wall
                    curr_line.add(new Wall(j, i));
                }else if ('.' == (lines.get(i).charAt(j))) {   //// Empty
                    curr_line.add(new Empty(j, i));
                }else if ('s' == (lines.get(i).charAt(j))) {   ////////////////////////////////  Monsters now:
                    curr_monster = new Monster("Lannister Solider", "s", 3, 25, 8, 3, 80, j, i);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                } else if ('k' == (lines.get(i).charAt(j))) {
                    curr_monster = new Monster("Lannister Knight", "k", 4, 50, 14, 8, 200, j, i);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                }else if ('q' == (lines.get(i).charAt(j))) {
                    curr_monster = new Monster("Queen’s Guard", "q", 5, 100, 20, 15, 400, j, i);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                }else if ('z' == (lines.get(i).charAt(j))) {
                    curr_monster = new Monster("Wright", "z", 3, 100, 30, 15, 600, j, i);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                } else if ('b' == (lines.get(i).charAt(j))) {
                    curr_monster = new Monster("Bear-Wright", "b", 4, 250, 75, 30, 1000, j, i);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                }else if ('g' == (lines.get(i).charAt(j))) {
                    curr_monster = new Monster("Giant-Wright", "g", 5, 500, 100, 40, 1500, j, i);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                }else if ('w' == (lines.get(i).charAt(j))) {
                    curr_monster = new Monster("White Walker", "w", 6, 1000, 150, 50, 2000, j, i);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                } else if ('M' == (lines.get(i).charAt(j))) {
                    curr_monster = new Monster("The Mountain", "M", 6, 500, 60, 25, 1000, j, i);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                }else if ('C' == (lines.get(i).charAt(j))) {
                    curr_monster = new Monster("Queen Cersei", "C", 1, 1000, 10, 10, 100, j, i);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                }else if ('K' == (lines.get(i).charAt(j))) {
                    curr_monster = new Monster("Night’s King", "k", 8, 5000, 300, 150, 5000, j, i);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                }else if ('B' == (lines.get(i).charAt(j))) {   ///////////////////////////////// Traps now:
                    curr_trap = new Trap(1, 5, "Bonus Trap", "B", 250, 1, 1, 1, j, i);
                    this.Traps.add(curr_trap);
                    curr_line.add(curr_trap);
                }else if ('Q' == (lines.get(i).charAt(j))) {
                    curr_trap = new Trap(3, 7, "Queen’s Trap", "Q", 100, 50, 10, 250, j, i);
                    this.Traps.add(curr_trap);
                    curr_line.add(curr_trap);
                }else if ('D' == (lines.get(i).charAt(j))) {
                    curr_trap = new Trap(1, 10, "Death Trap", "D", 250, 100, 20, 500, j, i);
                    this.Traps.add(curr_trap);
                    curr_line.add(curr_trap);
                }else if ('@' == (lines.get(i).charAt(j))) {   ///////////////////////////////   Player now:
                    if (this.player == 1){
                        this.the_player = new Warrior(3, "Jon Snow", "@", 30, 4, 300, j, i);
                        curr_line.add(this.the_player);
                    }else if (this.player == 2){
                        this.the_player = new Warrior(5, "The Hound", "@", 20, 6, 400, j, i);
                        curr_line.add(this.the_player);
                    } else if (this.player == 3){
                        this.the_player = new Mage(300, 30, 15, 5, 6, "Melisandre", "@", 5, 1, 100, j, i);
                        curr_line.add(this.the_player);
                    }else if (this.player == 4){
                        this.the_player = new Mage(150, 20, 20, 3, 4, "Thoros of Myr", "@", 25, 4, 250, j, i);
                        curr_line.add(this.the_player);
                    }else if (this.player == 5){
                        this.the_player = new Rogue(20, "Arya Stark", "@", 40, 2, 150, j, i);
                        curr_line.add(this.the_player);
                    }else if (this.player == 6){
                        this.the_player = new Rogue(50, "Bronn", "@", 35, 3, 250, j, i);
                        curr_line.add(this.the_player);
                    }
                }
            }
            res.add(curr_line);
        }
        return res;
    }
}
